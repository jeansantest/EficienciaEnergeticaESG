package com.fiap.eficienciaenergetica.repository;

import com.fiap.eficienciaenergetica.model.ConsumoEnergia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsumoEnergiaRepository extends JpaRepository<ConsumoEnergia, Long> {
}

