package app.iwaiter.controllers;

import app.iwaiter.dto.MesaDto;
import app.iwaiter.entities.Mesa;
import app.iwaiter.services.MesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mesas")
public class MesaController {

    @Autowired
    private MesaService mesaService;

    @GetMapping
    public ResponseEntity<List<MesaDto>> getAllMesas() {
        return ResponseEntity.ok().body(mesaService.listaMesas());
    }

    @PutMapping("/{numeroMesa}/{garcomId}")
    public ResponseEntity<?> atribuirGarcom(@PathVariable Integer numeroMesa, @PathVariable Long garcomId) {
        return ResponseEntity.status(HttpStatus.OK).body(mesaService.atribuirGarcom(numeroMesa, garcomId));
    }

    @PostMapping
    public ResponseEntity<MesaDto> criarMesa(@RequestBody MesaDto mesaDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mesaService.criarMesa(mesaDto));
    }
}
