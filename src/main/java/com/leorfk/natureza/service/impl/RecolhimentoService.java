package com.leorfk.natureza.service.impl;

import com.leorfk.natureza.domain.Recolhimento;
import com.leorfk.natureza.repository.interfaces.IRecolhimentoRepository;
import com.leorfk.natureza.service.exception.ObjectNotFoundException;
import com.leorfk.natureza.service.interfaces.IRecolhimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecolhimentoService implements IRecolhimentoService {

    @Autowired
    private IRecolhimentoRepository recolhimentoRepository;
    @Override
    public List<Recolhimento> getAll() {
        return recolhimentoRepository.buscarTodos();
    }

    @Override
    public void add(Recolhimento recolhimento) {
        recolhimentoRepository.salvarRecolhimento(recolhimento);
    }

    @Override
    public Recolhimento getById(String id) {
        Recolhimento recolhimento = recolhimentoRepository.buscarPorCodigo(id);
        if (recolhimento == null){
            throw new ObjectNotFoundException("Recolhimento com código: " + id + " não encontrado");
        }
        return recolhimento;
    }

    @Override
    public void update(String codigo, Recolhimento recolhimento) {
        recolhimentoRepository.alterarRecolhimento(codigo, recolhimento);
    }

    @Override
    public void delete(String id) {
        recolhimentoRepository.apagarRecolhimento(id);
    }
}
