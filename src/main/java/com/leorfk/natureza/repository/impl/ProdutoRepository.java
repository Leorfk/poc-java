package com.leorfk.natureza.repository.impl;

import com.leorfk.natureza.domain.Produto;
import com.leorfk.natureza.repository.exception.RepositoryException;
import com.leorfk.natureza.repository.interfaces.ICrudRepository;
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
public class ProdutoRepository implements ICrudRepository<Produto> {

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
    public void add(Produto produto) {
        try {
            this.jdbcTemplate.update(insert, null, produto.getCodigo(), produto.getDescricao(), produto.getSigla());
        }catch (RepositoryException e){
            throw new RepositoryException(e.getMessage());
        }
    }

    @Override
    public void update(String codigo, Produto produto) {
        try{
            this.jdbcTemplate.update(update, produto.getCodigo(), produto.getDescricao(), produto.getSigla(), codigo);
        }catch (RepositoryException e){
            throw new RepositoryException(e.getMessage());
        }
    }

    @Override
    public List<Produto> getAll() {
        try {
            RowMapper<Produto> produtoRowMapper = new ProdutoRowMapper();
            return this.jdbcTemplate.query(select, produtoRowMapper);
        }catch (RepositoryException e){
            throw new RepositoryException(e.getMessage());
        }
    }

    @Override
    public Produto getById(String codigo) {
        String query = select + " WHERE codigo =?";
        try {
            RowMapper<Produto> produtoRowMapper = new ProdutoRowMapper();
            List<Produto> produto =  this.jdbcTemplate.query(query, produtoRowMapper, codigo);
            return produto.size() == 1 ? produto.get(0): null;
        }catch (RepositoryException e){
            throw new RepositoryException(e.getMessage());
        }
    }

    @Override
    public void delete(String codigo) {
        String query = delete + " WHERE codigo=?";
        try {
            this.jdbcTemplate.update(query, codigo);
        }catch (RepositoryException e){
            throw new RepositoryException(e.getMessage());
        }
    }
}
