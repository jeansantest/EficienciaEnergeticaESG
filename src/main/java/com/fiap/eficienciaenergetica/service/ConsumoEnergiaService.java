package com.fiap.eficienciaenergetica.service;

import com.fiap.eficienciaenergetica.model.ConsumoEnergia;
import com.fiap.eficienciaenergetica.repository.ConsumoEnergiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumoEnergiaService {

    @Autowired
    private ConsumoEnergiaRepository repository;

    public List<ConsumoEnergia> findAll() {
        return repository.findAll();
    }

    public ConsumoEnergia save(ConsumoEnergia consumoEnergia) {
        return repository.save(consumoEnergia);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public ConsumoEnergia update(Long id, ConsumoEnergia newConsumoEnergia) {
        return repository.findById(id).map(consumoEnergia -> {
            consumoEnergia.setConsumo(newConsumoEnergia.getConsumo());
            consumoEnergia.setData(newConsumoEnergia.getData());
            return repository.save(consumoEnergia);
        }).orElseGet(() -> {
            newConsumoEnergia.setId(id);
            return repository.save(newConsumoEnergia);
        });
    }
}
