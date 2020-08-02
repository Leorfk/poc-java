package com.leorfk.natureza.repository.impl;

import com.leorfk.natureza.domain.Produto;
import com.leorfk.natureza.repository.exception.RepositoryException;
import com.leorfk.natureza.repository.interfaces.IProdutoRepository;
import com.leorfk.natureza.repository.utils.ProdutoRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class ProdutoRepository implements IProdutoRepository {

    @Value("${produto.update.id}")
    private String update;
    @Value("${produto.insert}")
    private String insert;
    @Value("${produto.select}")
    private String select;
    @Value("${produto.delete}")
    private String delete;

    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public ProdutoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void salvarProduto(Produto produto) {
        try {
            this.jdbcTemplate.update(insert, null, produto.getCodigo(), produto.getDescricao());
        }catch (RepositoryException e){
            throw new RepositoryException(e.getMessage());
        }
    }

    @Override
    public void alterarProduto(String codigo, Produto produto) {
        try{
            this.jdbcTemplate.update(update, produto.getCodigo(), produto.getDescricao(), codigo);
        }catch (RepositoryException e){
            throw new RepositoryException(e.getMessage());
        }
    }

    @Override
    public List<Produto> buscarTodos() {
        try {
            RowMapper<Produto> produtoRowMapper = new ProdutoRowMapper();
            return this.jdbcTemplate.query(select, produtoRowMapper);
        }catch (RepositoryException e){
            throw new RepositoryException(e.getMessage());
        }
    }

    @Override
    public Produto buscarPorCodigo(String codigo) {
        String query = select + " WHERE codigo =?";
        try {
            RowMapper<Produto> produtoRowMapper = new ProdutoRowMapper();
            return this.jdbcTemplate.queryForObject(query, produtoRowMapper, codigo);
        }catch (RepositoryException e){
            throw new RepositoryException(e.getMessage());
        }
    }

    @Override
    public void apagarProduto(String codigo) {
        String query = delete + " WHERE codigo=?";
        try {
            this.jdbcTemplate.update(query, codigo);
        }catch (RepositoryException e){
            throw new RepositoryException(e.getMessage());
        }
    }
}
