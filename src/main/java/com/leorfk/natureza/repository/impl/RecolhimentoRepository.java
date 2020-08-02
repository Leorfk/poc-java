package com.leorfk.natureza.repository.impl;

import com.leorfk.natureza.domain.Recolhimento;
import com.leorfk.natureza.repository.exception.RepositoryException;
import com.leorfk.natureza.repository.interfaces.IRecolhimentoRepository;
import com.leorfk.natureza.repository.utils.RecolhimentoRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class RecolhimentoRepository implements IRecolhimentoRepository {

    @Value("${recolhimento.update.id}")
    private String update;
    @Value("${recolhimento.insert}")
    private String insert;
    @Value("${recolhimento.select}")
    private String select;
    @Value("${recolhimento.delete}")
    private String delete;

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public RecolhimentoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void salvarRecolhimento(Recolhimento recolhimento) {
        try {
            this.jdbcTemplate.update(insert, null, recolhimento.getCodigo(), recolhimento.getDescricao());
        }catch (RepositoryException e){
            throw new RepositoryException(e.getMessage());
        }
    }

    @Override
    public void alterarRecolhimento(String codigo, Recolhimento recolhimento) {
        String query = update + " WHERE codigo=?";
        try {
            jdbcTemplate.update(query, recolhimento.getCodigo(), recolhimento.getDescricao(), codigo);
        }catch (RepositoryException e){
            throw new RepositoryException(e.getMessage());
        }
    }

    @Override
    public List<Recolhimento> buscarTodos() {

        try {
            RowMapper<Recolhimento> recolhimentoRowMapper = new RecolhimentoRowMapper();
            return this.jdbcTemplate.query(select, recolhimentoRowMapper);
        }catch (RepositoryException e){
            throw new RepositoryException(e.getMessage());
        }
    }

    @Override
    public Recolhimento buscarPorCodigo(String codigo) {
        String query = select + " WHERE codigo=?";
        try {
            RowMapper<Recolhimento> recolhimentoRowMapper = new RecolhimentoRowMapper();
            List<Recolhimento> recolhimentos = jdbcTemplate.query(query, recolhimentoRowMapper, codigo);
            return recolhimentos.size() == 1? recolhimentos.get(0): null;
        }catch (RepositoryException e){
            throw new RepositoryException(e.getMessage());
        }
    }

    @Override
    public void apagarRecolhimento(String codigo) {
        String query = delete + " WHERE codigo=?";
        try {
            jdbcTemplate.update(query, codigo);
        }catch (RepositoryException e){
            throw new RepositoryException(e.getMessage());
        }
    }
}
