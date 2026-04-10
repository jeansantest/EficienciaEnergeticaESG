package com.fiap.eficienciaenergetica.controller;

import com.fiap.eficienciaenergetica.model.ConsumoEnergia;
import com.fiap.eficienciaenergetica.service.ConsumoEnergiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consumo-energia")
public class ConsumoEnergiaController {

    @Autowired
    private ConsumoEnergiaService service;

    @GetMapping
    public List<ConsumoEnergia> getAllConsumo() {
        return service.findAll();
    }

    @PreAuthorize("hasRole('ADM')")
    @PostMapping
    public ConsumoEnergia createConsumo(@RequestBody ConsumoEnergia consumoEnergia) {
        return service.save(consumoEnergia);
    }

    @PreAuthorize("hasRole('ADM')")
    @PutMapping("/{id}")
    public ResponseEntity<ConsumoEnergia> updateConsumo(@PathVariable Long id, @RequestBody ConsumoEnergia newConsumoEnergia) {
        ConsumoEnergia updatedConsumo = service.update(id, newConsumoEnergia);
        return ResponseEntity.ok(updatedConsumo);
    }

    @PreAuthorize("hasRole('ADM')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConsumo(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
