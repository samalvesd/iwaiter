package app.iwaiter.services;

import app.iwaiter.dto.ChamadaDto;
import app.iwaiter.entities.Chamada;
import app.iwaiter.entities.ChamadaStatus;
import app.iwaiter.entities.Garcom;
import app.iwaiter.repositories.ChamadaRepository;
import app.iwaiter.repositories.GarcomRepository;
import app.iwaiter.repositories.MesaRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChamadaService {

    @Autowired
    private MesaRepository mesaRepository;

    @Autowired
    private GarcomRepository garcomRepository;

    @Autowired
    private ChamadaRepository chamadaRepository;

    @Transactional
    public ChamadaDto chamarGarcom(final ChamadaDto request) {
        Garcom garcomResponsavel = getGarcomResponsavel(request.getNumeroMesa());

        Chamada novaChamada = new Chamada();
        novaChamada.setNumeroMesa(request.getNumeroMesa());
        novaChamada.setGarcom(garcomResponsavel);
        novaChamada.setHorarioChamada(LocalDateTime.now());
        novaChamada.setStatus(ChamadaStatus.PENDENTE);

        Chamada chamadaSalva = chamadaRepository.save(novaChamada);

        return new ChamadaDto(
                chamadaSalva.getId(),
                chamadaSalva.getNumeroMesa(),
                chamadaSalva.getHorarioChamada()
        );
    }

    @Transactional
    public ChamadaDto aceitarChamada(Long chamadaId) {
        Chamada chamada = chamadaRepository.findById(chamadaId)
                .orElseThrow(() -> new EntityNotFoundException("Chamada não encontrada."));

        chamada.setStatus(ChamadaStatus.FINALIZADA);
        chamada.setHorarioFinalizacao(LocalDateTime.now());

        Chamada chamadaAtualizada = chamadaRepository.save(chamada);

        return new ChamadaDto(
                chamadaAtualizada.getId(),
                chamadaAtualizada.getNumeroMesa(),
                chamadaAtualizada.getHorarioChamada()
        );
    }

    public Garcom getGarcomResponsavel(Integer numeroMesa) {
        return mesaRepository.findById(numeroMesa).orElseThrow(
                () -> new EntityNotFoundException("Mesa não encontrada.")).getGarcomResponsavel();
    }

    public List<ChamadaDto> listChamadasByGarcom(Long garcomId) {
        List<Chamada> chamadas = chamadaRepository.findByGarcomIdAndStatus(garcomId,
                ChamadaStatus.PENDENTE);

        return chamadas.stream().map(
                chamada -> new ChamadaDto(
                        chamada.getId(),
                        chamada.getNumeroMesa(),
                        chamada.getHorarioChamada()
                )).collect(Collectors.toList());
    }
}
