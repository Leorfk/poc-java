package com.leorfk.natureza.repository.utils;

import com.leorfk.natureza.domain.Natureza;
import com.leorfk.natureza.domain.Produto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdutoRowMapper implements RowMapper<Produto> {

    @Override
    public Produto mapRow(ResultSet row, int rowNum) throws SQLException {
        Produto produto = new Produto();
        produto.setId(row.getInt("idproduto"));
        produto.setCodigo(row.getString("codigo"));
        produto.setDescricao(row.getString("descricao"));
        produto.setSigla(row.getString("sigla"));
        return produto;
    }
}
