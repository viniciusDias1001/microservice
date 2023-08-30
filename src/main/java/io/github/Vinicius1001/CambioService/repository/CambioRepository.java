package io.github.Vinicius1001.CambioService.repository;

import io.github.Vinicius1001.CambioService.model.Cambio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CambioRepository extends JpaRepository<Cambio,Long> {
    Cambio findByFromAndTo(String from, String to);
}
