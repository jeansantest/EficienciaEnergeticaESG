package com.fiap.eficienciaenergetica.controller;

import com.fiap.eficienciaenergetica.model.AlertaConsumo;
import com.fiap.eficienciaenergetica.service.AlertaConsumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alertas-consumo")
public class AlertaConsumoController {

    @Autowired
    private AlertaConsumoService service;

    @GetMapping
    public List<AlertaConsumo> getAllAlertas() {

        return service.findAll();
    }

    @PreAuthorize("hasRole('ADM')")
    @PostMapping
    public AlertaConsumo createAlerta(@RequestBody AlertaConsumo alertaConsumo) {

        return service.save(alertaConsumo);
    }

    @PreAuthorize("hasRole('ADM')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlerta(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
