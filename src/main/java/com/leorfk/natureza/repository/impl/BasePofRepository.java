package com.leorfk.natureza.repository.impl;

import com.leorfk.natureza.repository.exception.RepositoryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class BasePofRepository {

    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public BasePofRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public void selectBasePof(){
        try {
            ResultSet rs = null;
            List<String> nomeDasColunas = new ArrayList<>();


            List<Map<String, Object>> maps = this.jdbcTemplate.queryForList("select * from pof");
            System.out.println("chave" + maps.get(1).keySet().toString());

            String csv = String.join(";", maps.get(1).keySet()) + "\n";
            nomeDasColunas.addAll(maps.get(1).keySet());

            for (int i = 0; i < maps.size(); i++){
                for (int j =0; j < nomeDasColunas.size(); j++){
                    csv+= "'" + maps.get(i).get(nomeDasColunas.get(j)) + ";";
                }
                csv+= "\n";
            }
            System.out.println(csv);
        } catch (RepositoryException e){
            throw new RepositoryException(e.getMessage());
        }
    }
}
