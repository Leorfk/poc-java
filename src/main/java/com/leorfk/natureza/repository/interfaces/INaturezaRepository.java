package com.leorfk.natureza.repository.interfaces;

import com.leorfk.natureza.domain.Natureza;

import java.util.List;

public interface INaturezaRepository {
    List<Natureza> getAll();
    void add(Natureza natureza);
    Natureza getById(String id);
    void update(Natureza natureza);
    void delete(int id);
}
