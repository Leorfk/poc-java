package com.leorfk.natureza.service.interfaces;

import com.leorfk.natureza.domain.Natureza;

import java.util.List;

public interface INaturezaService {

    List<Natureza> getAll();
    boolean add(Natureza natureza);
    Natureza getById(String id);
    void update(String id, Natureza natureza);
    void delete(String id);
}
