package com.leorfk.natureza.repository.impl;

import com.leorfk.natureza.domain.Parametro;
import com.leorfk.natureza.domain.Usuario;
import com.leorfk.natureza.repository.db.DB;
import com.leorfk.natureza.repository.db.DbException;
import com.leorfk.natureza.repository.interfaces.IParametroRepository;
import com.leorfk.natureza.repository.utils.Instantiation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        List<Parametro> parametros = new ArrayList<>();
//        try {
//            ps = conn.prepareStatement("select * from parametrizacao");
//            rs = ps.executeQuery();
//
//            while (rs.next()){
//                Parametro parametro = Instantiation.instanciaParametro(rs);
//                parametros.add(parametro);
//            }
//            return parametros;
//        } catch (SQLException e) {
//            throw new DbException(e.getMessage());
//        }finally {
//            DB.closeStatement(ps);
//            DB.closeResultSet(rs);
//        }
    }
    @Override
    public Parametro buscarPorId() {
        return null;
    }
}
