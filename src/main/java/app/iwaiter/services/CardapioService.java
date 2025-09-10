package app.iwaiter.services;

import app.iwaiter.dto.CardapioDTO;
import app.iwaiter.entities.Cardapio;
import app.iwaiter.repositories.CardapioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CardapioService {

    @Autowired
    CardapioRepository cardapioRepository;

    @Transactional
    public CardapioDTO criarItemCardapio(final CardapioDTO itemDto) {
        Cardapio novoItem = new Cardapio(
                itemDto.getNome(),
                itemDto.getDescricao(),
                itemDto.getPreco(),
                itemDto.getCategoria(),
                itemDto.getUrlFoto()
        );
        Cardapio itemSalvo = cardapioRepository.save(novoItem);

        return new CardapioDTO(
                itemSalvo.getId(),
                itemSalvo.getNome(),
                itemSalvo.getDescricao(),
                itemSalvo.getPreco(),
                itemSalvo.getCategoria(),
                itemSalvo.getUrlFoto()
        );
    }

    @Transactional
    public CardapioDTO alterarItemCardapio(Long id, CardapioDTO itemDto) {
        Cardapio itemExistente = cardapioRepository.findById(id).
                orElseThrow(() -> new IllegalArgumentException("Item não encontrado."));

        itemExistente.setNome(itemDto.getNome());
        itemExistente.setDescricao(itemDto.getDescricao());
        itemExistente.setPreco(itemDto.getPreco());
        itemExistente.setCategoria(itemDto.getCategoria());
        itemExistente.setUrlFoto(itemDto.getUrlFoto());

        Cardapio itemSalvo = cardapioRepository.save(itemExistente);

        return new CardapioDTO(
                itemSalvo.getId(),
                itemSalvo.getNome(),
                itemSalvo.getDescricao(),
                itemSalvo.getPreco(),
                itemSalvo.getCategoria(),
                itemSalvo.getUrlFoto()
        );
    }

    @Transactional
    public void deletarItemCardapio(Long id) {
        if (!cardapioRepository.existsById(id))
            throw new IllegalArgumentException("Item não encontrado.");
        cardapioRepository.deleteById(id);
    }

    public List<CardapioDTO> listaCardapio() {
        return cardapioRepository.findAll().stream().map(
                cada -> new CardapioDTO(
                        cada.getId(),
                        cada.getNome(),
                        cada.getDescricao(),
                        cada.getPreco(),
                        cada.getCategoria(),
                        cada.getUrlFoto()
                )
        ).collect(Collectors.toList());
    }
}