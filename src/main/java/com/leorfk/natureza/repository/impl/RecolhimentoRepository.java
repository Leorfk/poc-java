package com.leorfk.natureza.repository.impl;

import com.leorfk.natureza.domain.Recolhimento;
import com.leorfk.natureza.repository.interfaces.IRecolhimentoRepository;

import java.util.List;

public class RecolhimentoRepository implements IRecolhimentoRepository {
    @Override
    public void salvarRecolhimento(Recolhimento recolhimento) {}

    @Override
    public void alterarRecolhimento(int id, Recolhimento recolhimento) {}

    @Override
    public List<Recolhimento> buscarTodos() {
        return null;
    }

    @Override
    public Recolhimento buscarPorCodigo(String codigo) {
        return null;
    }

    @Override
    public void apagarRecolhimento(String codigo) {}
}
