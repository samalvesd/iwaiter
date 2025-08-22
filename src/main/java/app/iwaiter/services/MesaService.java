package app.iwaiter.services;

import app.iwaiter.entities.Garcom;
import app.iwaiter.entities.Mesa;
import app.iwaiter.repositories.GarcomRepository;
import app.iwaiter.repositories.MesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MesaService {

    @Autowired
    private MesaRepository mesaRepository;

    @Autowired
    private GarcomRepository garcomRepository;

    public Mesa criarMesa() {
        return null;
    }

    public Mesa atribuirGarcom(Long numeroMesa, Long garcomId) {
        Mesa mesa = mesaRepository.findById(numeroMesa)
                .orElseThrow(() -> new IllegalArgumentException("Mesa não encontrada."));

        Garcom garcom = garcomRepository.findById(garcomId)
                .orElseThrow(() -> new IllegalArgumentException("Garçom não encontrado."));

        mesa.setGarcomResponsavel(garcom);
        return mesaRepository.save(mesa);
    }

    public List<Mesa> listaMesas() {
        return mesaRepository.findAll();
    }
}
