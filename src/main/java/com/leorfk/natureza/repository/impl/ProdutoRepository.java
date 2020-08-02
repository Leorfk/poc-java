package com.leorfk.natureza.repository.impl;

import com.leorfk.natureza.domain.Produto;
import com.leorfk.natureza.repository.interfaces.IProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ProdutoRepository implements IProdutoRepository {

    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public ProdutoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public void salvarProduto(Produto produto) {}

    @Override
    public void alterarProduto(int id, Produto produto) {}

    @Override
    public List<Produto> buscarTodos() {
        return null;
    }

    @Override
    public Produto buscarPorCodigo(String codigo) {
        return null;
    }

    @Override
    public void apagarProduto(String codigo) {

    }
}
