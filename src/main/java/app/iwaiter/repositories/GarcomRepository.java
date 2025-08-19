package app.iwaiter.repositories;

import app.iwaiter.entities.Garcom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GarcomRepository extends JpaRepository<Garcom, Long> {
    Optional<Garcom> findByLogin(String usuario);
}
