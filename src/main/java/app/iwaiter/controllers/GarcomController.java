package app.iwaiter.controllers;

import app.iwaiter.dto.GarcomDto;
import app.iwaiter.services.GarcomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/garcons")
public class GarcomController {

    @Autowired
    private GarcomService garcomService;

    @PostMapping
    public ResponseEntity<GarcomDto> criarGarcom(@RequestBody GarcomDto input) {
        return ResponseEntity.status(HttpStatus.CREATED).body(garcomService.criarGarcom(input));
    }

    @GetMapping
    public ResponseEntity<List<GarcomDto>> listaGarcons() {
        return ResponseEntity.ok().body(garcomService.listaGarcons());
    }
}
