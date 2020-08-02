package com.leorfk.natureza.repository.impl;

import com.leorfk.natureza.domain.Parametro;
import com.leorfk.natureza.domain.Usuario;
import com.leorfk.natureza.repository.interfaces.IParametroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class ParametroRepository implements IParametroRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ParametroRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public String salvarParametrizacao(Parametro parametro) {
        return null;
    }

    @Override
    public String alterarParametrizacao(int id, Parametro parametro) {
        return null;
    }

    @Override
    public String aprovarParametrizacao(int id, Usuario usuario) {
        return null;
    }

    @Override
    public String reprovarParametrizacao(int id, Usuario usuario) {
        return null;
    }

    @Override
    public Parametro buscarRecentes() {
        return null;
    }

    @Override
    public List<Parametro> buscarTodos() {
        return null;
    }
    @Override
    public Parametro buscarPorId() {
        return null;
    }
}
