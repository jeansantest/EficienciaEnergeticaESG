package com.fiap.eficienciaenergetica.repository;

import com.fiap.eficienciaenergetica.model.SensorIoT;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorIoTRepository extends JpaRepository<SensorIoT, Long> {
}
