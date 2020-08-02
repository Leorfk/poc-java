package com.leorfk.natureza.repository.impl;

import com.leorfk.natureza.domain.Natureza;
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
public class NaturezaRespository implements INaturezaRepository {

    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public NaturezaRespository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Natureza> getAll(){
        String sql = "SELECT id, codigo, descricao FROM natureza";
        RowMapper<Natureza> rowMapper = new NaturezaRowMapper();
        /*
        Podemos usar o BeanPropertyRowMapper, quando os campos de nossa tabela e nossa classe possuem o mesmo nome
                RowMapper<Article> rowMapper = new BeanPropertyRowMapper<Article>(Article.class);
        * */
        return this.jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public boolean add(Natureza natureza){
        String sql = "INSERT INTO natureza (idnatureza, codigo, descricao) value (?, ?, ?)";
        jdbcTemplate.update(sql, null, natureza.getCodigo(), natureza.getDescricao());
        return true;
    }

    @Override
    public Natureza getById(int id){
        String sql = "SELECT idnatureza, codigo, descricao FROM natureza WHERE idnatureza = ?";
        RowMapper<Natureza> rowMapper = new NaturezaRowMapper();
        Natureza natureza = jdbcTemplate.queryForObject(sql, rowMapper, id);
        return natureza;
    }

    @Override
    public void update(Natureza natureza){
        String sql = "UPDATE natureza SET codigo=?, descricao=? WHERE id=?";
        jdbcTemplate.update(sql, natureza.getCodigo(), natureza.getDescricao(), natureza.getId());
    }

    @Override
    public void delete(int id){
        String sql = "DELETE FROM natureza WHERE id=?";
        jdbcTemplate.update(sql, id);
    }
}
