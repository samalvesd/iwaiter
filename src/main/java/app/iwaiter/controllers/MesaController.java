package app.iwaiter.controllers;

import app.iwaiter.entities.Mesa;
import app.iwaiter.services.MesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mesas")
public class MesaController {

    @Autowired
    private MesaService mesaService;

    @GetMapping
    public List<Mesa> getAllMesas() {
        return mesaService.listaMesas();
    }

    @PostMapping("/{numeroMesa}/{garcomId}")
    public ResponseEntity<Mesa> atribuirGarcom(@PathVariable Long numeroMesa, @PathVariable Long garcomId) {
        return ResponseEntity.ok(mesaService.atribuirGarcom(numeroMesa, garcomId));
    }
}
