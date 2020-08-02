package com.leorfk.natureza.service.impl;

import com.leorfk.natureza.domain.Recolhimento;
import com.leorfk.natureza.repository.interfaces.ICrudRepository;
import com.leorfk.natureza.repository.interfaces.IRecolhimentoRepository;
import com.leorfk.natureza.service.exception.ObjectNotFoundException;
import com.leorfk.natureza.service.interfaces.IRecolhimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecolhimentoService implements IRecolhimentoService {

    @Autowired
    private ICrudRepository<Recolhimento> recolhimentoRepository;
    @Override
    public List<Recolhimento> getAll() {
        return recolhimentoRepository.getAll();
    }

    @Override
    public void add(Recolhimento recolhimento) {
        recolhimentoRepository.add(recolhimento);
    }

    @Override
    public Recolhimento getById(String id) {
        Recolhimento recolhimento = recolhimentoRepository.getById(id);
        if (recolhimento == null){
            throw new ObjectNotFoundException("Recolhimento com código: " + id + " não encontrado");
        }
        return recolhimento;
    }

    @Override
    public void update(String codigo, Recolhimento recolhimento) {
        recolhimentoRepository.update(codigo, recolhimento);
    }

    @Override
    public void delete(String id) {
        recolhimentoRepository.delete(id);
    }
}
