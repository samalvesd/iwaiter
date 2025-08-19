package app.iwaiter.services;

import app.iwaiter.entities.Garcom;
import app.iwaiter.entities.Mesa;
import app.iwaiter.repositories.MesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChamadaService {

    @Autowired
    private MesaRepository mesaRepository;

    public Garcom getGarcomResponsavel(Long numeroMesa) {
        Mesa mesa = mesaRepository.findById(numeroMesa)
                .orElseThrow(() -> new IllegalArgumentException("Mesa não encontrada."));
        return mesa.getGarcomResponsavel();
    }

}
