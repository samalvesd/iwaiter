package app.iwaiter.controllers;

import app.iwaiter.dto.ChamadaDto;
import app.iwaiter.entities.Garcom;
import app.iwaiter.services.ChamadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chamada")
public class ChamadaController {

    @Autowired
    private ChamadaService chamadaService;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @PostMapping
    public ResponseEntity<ChamadaDto> chamarGarcom(@RequestBody ChamadaDto request) {
        Garcom garcomResponsavel = chamadaService.getGarcomResponsavel(request.getNumeroMesa());

        if (garcomResponsavel == null) {
            return ResponseEntity.notFound().build();
        }

        messagingTemplate.convertAndSend("/topic/chamadas/" + garcomResponsavel.getUsuario(),
                "CHAMADA: Mesa " + request.getNumeroMesa());

        return ResponseEntity.status(HttpStatus.OK).body(chamadaService.chamarGarcom(request));
    }

    @GetMapping("/garcom/{garcomId}")
    public ResponseEntity<List<ChamadaDto>> listaChamadas(@PathVariable Long garcomId) {
        return ResponseEntity.ok().body(chamadaService.listChamadasByGarcom(garcomId));
    }

    @PutMapping("/{chamadaId}/aceitar")
    public ResponseEntity<ChamadaDto> aceitarChamada(@PathVariable Long chamadaId) {
        return ResponseEntity.ok().body(chamadaService.aceitarChamada(chamadaId));
    }
}
