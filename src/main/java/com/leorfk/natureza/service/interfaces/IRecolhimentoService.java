package com.leorfk.natureza.service.interfaces;

import com.leorfk.natureza.domain.Recolhimento;

import java.util.List;

public interface IRecolhimentoService {
    List<Recolhimento> getAll();
    void add(Recolhimento recolhimento);
    Recolhimento getById(String id);
    void update(String id, Recolhimento recolhimento);
    void delete(String id);
}
