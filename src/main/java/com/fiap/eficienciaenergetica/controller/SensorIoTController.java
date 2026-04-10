package com.fiap.eficienciaenergetica.controller;

import com.fiap.eficienciaenergetica.model.SensorIoT;
import com.fiap.eficienciaenergetica.service.SensorIoTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sensores-iot")
public class SensorIoTController {

    @Autowired
    private SensorIoTService service;

    @GetMapping
    public List<SensorIoT> getAllSensores() {
        return service.findAll();
    }

    @PreAuthorize("hasRole('ADM')")
    @PostMapping
    public SensorIoT addSensor(@RequestBody SensorIoT sensorIoT) {
        return service.save(sensorIoT);
    }

    @PreAuthorize("hasRole('ADM')")
    @PutMapping("/{id}")
    public ResponseEntity<SensorIoT> updateSensor(@PathVariable Long id, @RequestBody SensorIoT newSensorIoT) {
        SensorIoT updatedSensor = service.update(id, newSensorIoT);
        return ResponseEntity.ok(updatedSensor);
    }

    @PreAuthorize("hasRole('ADM')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSensor(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
