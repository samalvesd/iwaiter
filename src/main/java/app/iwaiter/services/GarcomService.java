package app.iwaiter.services;

import app.iwaiter.dto.GarcomDto;
import app.iwaiter.entities.Garcom;
import app.iwaiter.repositories.GarcomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GarcomService {

    @Autowired
    private GarcomRepository garcomRepository;

    public Garcom criarGarcom(Garcom garcom) {
        return garcomRepository.save(garcom);
    }

    public List<GarcomDto> listaGarcons() {
        return garcomRepository.findAll().stream().map(
                cada -> new GarcomDto(
                        cada.getId(),
                        cada.getNome(),
                        cada.getFotoPerfil()
                )
        ).collect(Collectors.toList());
    }
}
