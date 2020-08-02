package com.leorfk.natureza.repository.interfaces;

import com.leorfk.natureza.domain.Parametro;
import com.leorfk.natureza.domain.Produto;
import com.leorfk.natureza.domain.Usuario;

import java.util.List;

public interface IProdutoRepository {
    void salvarProduto(Produto produto);
    void alterarProduto(String codigo, Produto produto);
    List<Produto> buscarTodos();
    Produto buscarPorCodigo(String codigo);
    void apagarProduto(String codigo);
}
