package com.leorfk.natureza.service.interfaces;

import com.leorfk.natureza.domain.Produto;

import java.util.List;

public interface IProdutoService {
    List<Produto> getAll();
    void add(Produto produto);
    Produto getById(String id);
    void update(String codigo, Produto produto);
    void delete(String id);
}
