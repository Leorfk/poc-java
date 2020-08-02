package com.leorfk.natureza.service.interfaces;

import com.leorfk.natureza.domain.Produto;

import java.util.List;

public interface IProdutoService {
    List<Produto> getAll();
    boolean add(Produto produto);
    Produto getById(int id);
    void update(Produto produto);
    void delete(int id);
}
