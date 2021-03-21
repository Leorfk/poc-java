package com.leorfk.natureza.repository.mapper;

import com.leorfk.natureza.domain.*;
import com.leorfk.natureza.domain.enums.StatusParametro;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ParametroRowMapper implements RowMapper<Parametro> {

    @Override
    public Parametro mapRow(ResultSet row, int rowNum) throws SQLException {
        Parametro parametro = new Parametro();
        Produto produto = new Produto();
        Natureza natureza = new Natureza();
        Recolhimento recolhimento = new Recolhimento();
        Usuario usuario = new Usuario();

        produto.setCodigo(row.getString("codigo_produto"));
        produto.setDescricao(row.getString("descricao_produto"));
        produto.setSigla(row.getString("sigla"));

        natureza.setCodigo(row.getString("codigo_natureza"));
        natureza.setDescricao(row.getString("descricao_natureza"));

        recolhimento.setCodigo(row.getString("codigo_recolhimento"));
        recolhimento.setDescricao(row.getString("descricao_recolhimento"));

        usuario.setRacf(row.getString("racf"));
        usuario.setMotivo(row.getString("motivo"));

        parametro.setId(row.getInt("id"));
        parametro.setData(row.getDate("data_item"));
        parametro.setInteracao(row.getString("interacao"));
        parametro.setStatus(StatusParametro.toEnum(row.getInt("status")));
        parametro.setProduto(produto);
        parametro.setNatureza(natureza);
        parametro.setRecolhimento(recolhimento);
        parametro.setUsuario(usuario);
        return parametro;
    }
}
