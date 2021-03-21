package com.leorfk.natureza.repository.mapper;

import com.leorfk.natureza.domain.Recolhimento;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RecolhimentoRowMapper implements RowMapper<Recolhimento> {

    @Override
    public Recolhimento mapRow(ResultSet row, int rowNum) throws SQLException {
        Recolhimento recolhimento = new Recolhimento();
        recolhimento.setId(row.getInt("idrecolhimento"));
        recolhimento.setCodigo(row.getString("codigo"));
        recolhimento.setDescricao(row.getString("descricao"));
        return recolhimento;
    }
}
