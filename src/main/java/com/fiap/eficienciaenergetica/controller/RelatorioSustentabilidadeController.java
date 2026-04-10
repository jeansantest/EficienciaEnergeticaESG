package com.fiap.eficienciaenergetica.controller;

import com.fiap.eficienciaenergetica.model.RelatorioSustentabilidade;
import com.fiap.eficienciaenergetica.service.RelatorioSustentabilidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/relatorios-sustentabilidade")
public class RelatorioSustentabilidadeController {

    @Autowired
    private RelatorioSustentabilidadeService service;

    @GetMapping
    public List<RelatorioSustentabilidade> getAllRelatorios() {
        return service.findAll();
    }

    @PreAuthorize("hasRole('ADM')")
    @PostMapping
    public RelatorioSustentabilidade createRelatorio(@RequestBody RelatorioSustentabilidade relatorio) {
        return service.save(relatorio);
    }

    @PreAuthorize("hasRole('ADM')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRelatorio(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
