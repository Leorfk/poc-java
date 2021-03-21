package com.leorfk.natureza.repository.mapper;

import com.leorfk.natureza.domain.Natureza;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NaturezaRowMapper implements RowMapper<Natureza> {

    @Override
    public Natureza mapRow(ResultSet row, int rowNum) throws SQLException {
        Natureza natureza = new Natureza();
        natureza.setId(row.getInt("idnatureza"));
        natureza.setCodigo(row.getString("codigo"));
        natureza.setDescricao(row.getString("descricao"));
        return natureza;
    }
}
