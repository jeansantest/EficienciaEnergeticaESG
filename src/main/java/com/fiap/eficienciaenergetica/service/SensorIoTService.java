package com.fiap.eficienciaenergetica.service;

import com.fiap.eficienciaenergetica.model.SensorIoT;
import com.fiap.eficienciaenergetica.repository.SensorIoTRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorIoTService {

    @Autowired
    private SensorIoTRepository repository;

    public List<SensorIoT> findAll() {
        return repository.findAll();
    }

    public SensorIoT save(SensorIoT sensorIoT) {
        return repository.save(sensorIoT);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public SensorIoT update(Long id, SensorIoT newSensorIoT) {
        return repository.findById(id).map(sensorIoT -> {
            sensorIoT.setNome(newSensorIoT.getNome());
            sensorIoT.setStatus(newSensorIoT.getStatus());
            return repository.save(sensorIoT);
        }).orElseGet(() -> {
            newSensorIoT.setId(id);
            return repository.save(newSensorIoT);
        });
    }
}
