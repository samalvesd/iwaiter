package app.iwaiter.services;

import app.iwaiter.dto.ChamadaDto;
import app.iwaiter.entities.Garcom;
import app.iwaiter.repositories.GarcomRepository;
import app.iwaiter.repositories.MesaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChamadaService {

    @Autowired
    private MesaRepository mesaRepository;

    @Autowired
    private GarcomRepository garcomRepository;

    public ChamadaDto chamarGarcom(final ChamadaDto request) {
        Garcom garcomEntityChamado = garcomRepository.findByUsuario(request.getUsuario()).orElseThrow(
                RuntimeException::new
        );
        return new ChamadaDto(garcomEntityChamado.getNome(), garcomEntityChamado.getFotoPerfil());
    }

    public Garcom getGarcomResponsavel(ChamadaDto numeroMesa) {
        return mesaRepository.findById(numeroMesa.getNumeroMesa()).orElseThrow(
                () -> new EntityNotFoundException("Mesa não encontrada.")).getGarcomResponsavel();
    }

}
