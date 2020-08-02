package com.leorfk.natureza.repository.interfaces;

import com.leorfk.natureza.domain.Natureza;

import java.util.List;

public interface INaturezaRepository {
    List<Natureza> getAll();
    boolean add(Natureza natureza);
    Natureza getById(int id);
    void update(Natureza natureza);
    void delete(int id);
}
