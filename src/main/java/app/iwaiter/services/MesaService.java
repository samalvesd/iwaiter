package app.iwaiter.services;

import app.iwaiter.dto.MesaDto;
import app.iwaiter.entities.Garcom;
import app.iwaiter.entities.Mesa;
import app.iwaiter.entities.MesaStatus;
import app.iwaiter.repositories.GarcomRepository;
import app.iwaiter.repositories.MesaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MesaService {

    @Autowired
    private MesaRepository mesaRepository;

    @Autowired
    private GarcomRepository garcomRepository;

    @Transactional
    public MesaDto criarMesa(final MesaDto mesaDto) {
        boolean mesaJaCadastrada = mesaRepository.findByNumeroMesa(mesaDto.getNumeroMesa()).isPresent();
        if (mesaJaCadastrada)
            throw new IllegalArgumentException("Mesa " + mesaDto.getNumeroMesa() + " já cadastrada. Informe outro número de mesa.");

        mesaRepository.save(new Mesa(
                mesaDto.getNumeroMesa(),
                mesaDto.getCapacidade(),
                MesaStatus.valueOf(mesaDto.getStatus().toUpperCase())
        ));
        return new MesaDto(
                mesaDto.getNumeroMesa(),
                mesaDto.getStatus(),
                mesaDto.getCapacidade(),
                mesaDto.getGarcomResponsavelNome(),
                mesaDto.getGarcomResponsavelId()
        );
    }

    @Transactional
    public Mesa atribuirGarcom(Integer numeroMesa, Long garcomId) {
        Mesa mesa = mesaRepository.findById(numeroMesa)
                .orElseThrow(() -> new IllegalArgumentException("Mesa não encontrada."));

        Garcom garcom = garcomRepository.findById(garcomId)
                .orElseThrow(() -> new IllegalArgumentException("Garçom não encontrado."));

        mesa.setGarcomResponsavel(garcom);
        return mesaRepository.save(mesa);
    }

    @Transactional
    public void excluirMesa(Integer numeroMesa) {
        if (!mesaRepository.existsById(numeroMesa))
            throw new IllegalArgumentException("Mesa não encontrada.");
        mesaRepository.deleteById(numeroMesa);
    }

    public List<MesaDto> listaMesas() {
        return mesaRepository.findAll().stream().map(
                cada -> {
                    String nomeGarcom = null;
                    Long idGarcom = null;
                    if (cada.getGarcomResponsavel() != null) {
                        nomeGarcom = cada.getGarcomResponsavel().getNome();
                        idGarcom = cada.getGarcomResponsavel().getId();
                    } else {
                        nomeGarcom = "Nenhum Garçom atribuído.";
                    }
                    return new MesaDto(
                            cada.getNumeroMesa(),
                            cada.getStatus().name(),
                            cada.getCapacidade(),
                            nomeGarcom,
                            idGarcom
                    );
                }
        ).collect(Collectors.toList());
    }
}
