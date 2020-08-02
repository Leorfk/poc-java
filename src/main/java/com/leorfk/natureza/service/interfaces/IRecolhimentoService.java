package com.leorfk.natureza.service.interfaces;

import com.leorfk.natureza.domain.Recolhimento;

import java.util.List;

public interface IRecolhimentoService {
    List<Recolhimento> getAll();
    boolean add(Recolhimento recolhimento);
    Recolhimento getById(int id);
    void update(Recolhimento recolhimento);
    void delete(int id);
}
