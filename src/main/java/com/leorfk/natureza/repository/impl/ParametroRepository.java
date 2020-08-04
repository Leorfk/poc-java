package com.leorfk.natureza.repository.impl;

import com.leorfk.natureza.domain.Parametro;
import com.leorfk.natureza.domain.Usuario;
import com.leorfk.natureza.repository.exception.RepositoryException;
import com.leorfk.natureza.repository.interfaces.IParametroRepository;
import com.leorfk.natureza.repository.utils.ParametroRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class ParametroRepository implements IParametroRepository {

    @Value("${parametrizacao.insert}")
    private String insert;
    @Value("${parametrizacao.select}")
    private String select;

    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public ParametroRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int salvarParametrizacao(Parametro parametro) {
        try{
            int resp = this.jdbcTemplate.update(insert, parametro.getUsuario().getMotivo(),
                    parametro.getStatus().getCodigo(), parametro.getInteracao(), parametro.getNatureza().getCodigo(),
                    parametro.getNatureza().getDescricao(), parametro.getProduto().getCodigo(),
                    parametro.getProduto().getDescricao(), parametro.getRecolhimento().getCodigo(),
                    parametro.getRecolhimento().getDescricao(), parametro.getUsuario().getRacf() ,
                    parametro.getProduto().getSigla());
            return resp;
        }catch (RepositoryException e){
            throw new RepositoryException(e.getMessage());
        }
    }

    @Override
    public boolean alterarParametrizacao(int id, Parametro parametro) {
        return false;
    }

    @Override
    public boolean aprovarParametrizacao(int id, Usuario usuario) {
        return false;
    }

    @Override
    public boolean reprovarParametrizacao(int id, Usuario usuario) {
        return false;
    }

    @Override
    public Parametro buscarRecentes() {
        return null;
    }

    @Override
    public List<Parametro> buscarTodos() {
        try {
            RowMapper<Parametro> parametroRowMapper = new ParametroRowMapper();
            return this.jdbcTemplate.query(select, parametroRowMapper);
        }catch (RepositoryException e){
            throw new RepositoryException(e.getMessage());
        }
    }

    @Override
    public List<Parametro> buscarPorId(int id) {
        String query = select + " WHERE id=?";
        try {
            RowMapper<Parametro> parametroRowMapper = new ParametroRowMapper();
            return this.jdbcTemplate.query(query, parametroRowMapper, id);
        }catch (RepositoryException e){
            throw new RepositoryException(e.getMessage());
        }
    }
}
