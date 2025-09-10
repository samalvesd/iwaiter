package app.iwaiter.controllers;

import app.iwaiter.dto.CardapioDTO;
import app.iwaiter.entities.Cardapio;
import app.iwaiter.repositories.CardapioRepository;
import app.iwaiter.services.CardapioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/cardapio")
public class CardapioController {

    @Autowired
    CardapioService cardapioService;

    @GetMapping
    public ResponseEntity<List<CardapioDTO>> listaCardapio() {
        return ResponseEntity.ok().body(cardapioService.listaCardapio());
    }

    @PostMapping
    public ResponseEntity<CardapioDTO> criarItemCardapio(@RequestBody CardapioDTO itemDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cardapioService.criarItemCardapio(itemDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CardapioDTO> alterarItemCardapio(@PathVariable Long id, @RequestBody CardapioDTO itemDto) {
        return ResponseEntity.ok().body(cardapioService.alterarItemCardapio(id, itemDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarItemCardapio(@PathVariable Long id) {
        cardapioService.deletarItemCardapio(id);
        return ResponseEntity.noContent().build();
    }
}
