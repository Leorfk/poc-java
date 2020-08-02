package com.leorfk.natureza.repository.impl;

import com.leorfk.natureza.domain.Natureza;
import com.leorfk.natureza.repository.exception.RepositoryException;
import com.leorfk.natureza.repository.interfaces.INaturezaRepository;
import com.leorfk.natureza.repository.utils.NaturezaRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class NaturezaRepository implements INaturezaRepository {

    private static final String SELECT = "SELECT idnatureza, codigo, descricao FROM natureza";
    private static final String INSERT = "INSERT INTO natureza (idnatureza, codigo, descricao) value (?, ?, ?)";
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public NaturezaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Natureza> getAll(){
                /*
        Podemos usar o BeanPropertyRowMapper, quando os campos de nossa tabela e nossa classe possuem o mesmo nome
                RowMapper<Article> rowMapper = new BeanPropertyRowMapper<Article>(Article.class);
        * */
        try {
            RowMapper<Natureza> rowMapper = new NaturezaRowMapper();
            return this.jdbcTemplate.query(SELECT, rowMapper);
        }catch (RepositoryException e){
            throw new RepositoryException(e.getMessage());
        }
    }

    @Override
    public void add(Natureza natureza){
        try{
            jdbcTemplate.update(INSERT, null, natureza.getCodigo(), natureza.getDescricao());
        }catch (RepositoryException e){
            throw new RepositoryException(e.getMessage());
        }
    }

    @Override
    public Natureza getById(int id){
        String sql = SELECT + " WHERE idnatureza = ?";
        try {
            RowMapper<Natureza> rowMapper = new NaturezaRowMapper();
            return jdbcTemplate.queryForObject(sql, rowMapper, id);
        }catch (RepositoryException e){
            throw new RepositoryException(e.getMessage());
        }
    }

    @Override
    public void update(Natureza natureza){
        try {
            String sql = "UPDATE natureza SET codigo=?, descricao=? WHERE idnatureza=?";
            jdbcTemplate.update(sql, natureza.getCodigo(), natureza.getDescricao(), natureza.getId());
        }catch (RepositoryException e){
            throw new RepositoryException(e.getMessage());
        }
    }

    @Override
    public void delete(int id){
        try {
            String sql = "DELETE FROM natureza WHERE idnatureza=?";
            jdbcTemplate.update(sql, id);
        }catch (RepositoryException e){
            throw new RepositoryException(e.getMessage());
        }
    }
}
