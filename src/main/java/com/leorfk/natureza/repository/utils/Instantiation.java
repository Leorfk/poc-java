package com.leorfk.natureza.repository.utils;

import com.leorfk.natureza.domain.*;
import com.leorfk.natureza.domain.enums.Interacao;
import com.leorfk.natureza.domain.enums.StatusParametro;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Instantiation {

    public static Parametro instanciaParametro(ResultSet rs) throws SQLException {
        Parametro parametro = new Parametro();
        parametro.setId(rs.getInt("id"));
        parametro.setData(rs.getDate("data_item"));
        parametro.setInteracao(rs.getString("interacao"));
        parametro.setStatus(StatusParametro.toEnum(rs.getInt("status")));
        parametro.setUsuario(instanciaUsuario(rs));
        parametro.setNatureza(instanciaNatureza(rs));
        parametro.setProduto(instanciaProduto(rs));
        parametro.setRecolhimento(instanciaRecolhimento(rs));
        return parametro;
    }

    public static Natureza instanciaNatureza(ResultSet rs) throws SQLException {
        Natureza natureza = new Natureza();
        natureza.setId(rs.getInt("id"));
        natureza.setCodigo(rs.getString("codigo"));
        natureza.setDescricao(rs.getString("descricao"));
        return natureza;
    }

    public static Produto instanciaProduto(ResultSet rs) throws SQLException {
        Produto produto = new Produto();
        produto.setId(rs.getInt("id"));
        produto.setCodigo(rs.getString("codigo"));
        produto.setDescricao(rs.getString("descricao"));
        return produto;
    }

    public static Recolhimento instanciaRecolhimento(ResultSet rs) throws SQLException {
        Recolhimento recolhimento = new Recolhimento();
        recolhimento.setId(rs.getInt("id"));
        recolhimento.setCodigo(rs.getString("codigo"));
        recolhimento.setDescricao(rs.getString("descricao"));
        return recolhimento;
    }

    public static Usuario instanciaUsuario(ResultSet rs) throws SQLException {
        Usuario user = new Usuario();
        user.setId(rs.getInt("id"));
        user.setRacf(rs.getString("racf"));
        user.setMotivo(rs.getString("motivo"));
        return user;
    }
}