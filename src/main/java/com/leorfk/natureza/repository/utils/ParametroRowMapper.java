package com.leorfk.natureza.repository.utils;

import com.leorfk.natureza.domain.Natureza;
import com.leorfk.natureza.domain.Parametro;
import com.leorfk.natureza.domain.enums.StatusParametro;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ParametroRowMapper implements RowMapper<Parametro> {
    @Override
    public Parametro mapRow(ResultSet row, int rowNum) throws SQLException {
        Parametro parametro = new Parametro();
        parametro.setId(row.getInt("id"));
        parametro.setData(row.getDate("data_item"));
        parametro.setInteracao(row.getString("interacao"));
        parametro.setStatus(StatusParametro.toEnum(row.getInt("status")));
        return parametro;
    }
}
