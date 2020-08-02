package com.leorfk.natureza.repository.interfaces;

import com.leorfk.natureza.domain.Recolhimento;

import java.util.List;

public interface IRecolhimentoRepository {
    void salvarRecolhimento(Recolhimento recolhimento);
    void alterarRecolhimento(String id, Recolhimento recolhimento);
    List<Recolhimento> buscarTodos();
    Recolhimento buscarPorCodigo(String codigo);
    void apagarRecolhimento(String codigo);
}
