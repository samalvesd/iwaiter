package app.iwaiter.controllers;

import app.iwaiter.dto.ChamadaDto;
import app.iwaiter.dto.GarcomDto;
import app.iwaiter.entities.Garcom;
import app.iwaiter.services.ChamadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chamada")
public class ChamadaController {

    @Autowired
    private ChamadaService chamadaService;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @PostMapping
    public ResponseEntity<GarcomDto> chamarGarcom(@RequestBody ChamadaDto request) {
        Garcom garcom = chamadaService.getGarcomResponsavel(request.getNumeroMesa());

        if (garcom == null) {
            return ResponseEntity.notFound().build();
        }

        messagingTemplate.convertAndSend("/topic/chamadas/" + garcom.getUsuario(),
                "CHAMADA: Mesa " + request.getNumeroMesa());

        return ResponseEntity.ok(new GarcomDto(garcom.getNome(), garcom.getFotoPerfil()));
    }
}
