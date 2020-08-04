package com.leorfk.natureza.repository.impl;

import com.leorfk.natureza.domain.Natureza;
import com.leorfk.natureza.repository.exception.RepositoryException;
import com.leorfk.natureza.repository.interfaces.ICrudRepository;
import com.leorfk.natureza.repository.interfaces.INaturezaRepository;
import com.leorfk.natureza.repository.utils.NaturezaRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class NaturezaRepository implements ICrudRepository<Natureza> {

    @Value("${natureza.update.id}")
    private String update;
    @Value("${natureza.insert}")
    private String insert;
    @Value("${natureza.select}")
    private String select;
    @Value("${natureza.delete}")
    private String delete;


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
            return this.jdbcTemplate.query(select, rowMapper);
        }catch (RepositoryException e){
            throw new RepositoryException(e.getMessage());
        }
    }

    @Override
    public void add(Natureza natureza){
        try{
            jdbcTemplate.update(insert, null, natureza.getCodigo(), natureza.getDescricao());
        }catch (RepositoryException e){
            throw new RepositoryException(e.getMessage());
        }
    }

    @Override
    public Natureza getById(String codigo){
        String sql = select + " WHERE codigo =?";
        try {
            RowMapper<Natureza> rowMapper = new NaturezaRowMapper();
            List<Natureza> naturezas = jdbcTemplate.query(sql, rowMapper, codigo);
            return naturezas.size() >= 1 ? naturezas.get(0): null;
        }catch (RepositoryException e){
            throw new RepositoryException(e.getMessage());
        }
    }

    @Override
    public void update(String codigo, Natureza natureza){
        try {
            jdbcTemplate.update(update, natureza.getCodigo(), natureza.getDescricao(), codigo);
        }catch (RepositoryException e){
            throw new RepositoryException(e.getMessage());
        }
    }

    @Override
    public void delete(String id){
        try {
            String sql = delete + " WHERE codigo=?";
            jdbcTemplate.update(sql, id);
        }catch (RepositoryException e){
            throw new RepositoryException(e.getMessage());
        }
    }
}
