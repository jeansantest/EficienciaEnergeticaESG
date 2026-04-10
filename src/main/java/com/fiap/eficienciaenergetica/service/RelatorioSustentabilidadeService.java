package com.fiap.eficienciaenergetica.service;

import com.fiap.eficienciaenergetica.model.RelatorioSustentabilidade;
import com.fiap.eficienciaenergetica.repository.RelatorioSustentabilidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelatorioSustentabilidadeService {

    @Autowired
    private RelatorioSustentabilidadeRepository repository;

    public List<RelatorioSustentabilidade> findAll() {
        return repository.findAll();
    }

    public RelatorioSustentabilidade save(RelatorioSustentabilidade relatorio) {
        return repository.save(relatorio);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
