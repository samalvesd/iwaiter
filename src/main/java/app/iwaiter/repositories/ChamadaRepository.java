package app.iwaiter.repositories;

import app.iwaiter.entities.Chamada;
import app.iwaiter.entities.ChamadaStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChamadaRepository extends JpaRepository<Chamada, Long> {
    List<Chamada> findByGarcomIdAndStatus(Long garcomId, ChamadaStatus status);
}
