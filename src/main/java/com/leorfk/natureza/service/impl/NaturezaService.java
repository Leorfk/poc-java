package com.leorfk.natureza.service.impl;

import com.leorfk.natureza.domain.Natureza;
import com.leorfk.natureza.repository.interfaces.INaturezaRepository;
import com.leorfk.natureza.service.interfaces.INaturezaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NaturezaService implements INaturezaService {

    @Autowired
    private INaturezaRepository naturezaRepository;

    @Override
    public List<Natureza> getAll() {
        return naturezaRepository.getAll();
    }

    @Override
    public boolean add(Natureza natureza) {
        naturezaRepository.add(natureza);
        return true;
    }

    @Override
    public Natureza getById(int id) {
        Natureza natureza = naturezaRepository.getById(id);
        return natureza;
    }

    @Override
    public void update(Natureza natureza) {
        naturezaRepository.update(natureza);
    }

    @Override
    public void delete(int id) {
        naturezaRepository.delete(id);
    }
}
