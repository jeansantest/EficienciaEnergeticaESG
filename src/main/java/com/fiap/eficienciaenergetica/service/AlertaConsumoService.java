package com.fiap.eficienciaenergetica.service;

import com.fiap.eficienciaenergetica.model.AlertaConsumo;
import com.fiap.eficienciaenergetica.repository.AlertaConsumoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertaConsumoService {

    @Autowired
    private AlertaConsumoRepository repository;

    public List<AlertaConsumo> findAll() {
        return repository.findAll();
    }

    public AlertaConsumo save(AlertaConsumo alertaConsumo) {
        return repository.save(alertaConsumo);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
