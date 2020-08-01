package com.leorfk.natureza.domain;

public class Natureza {
    private int id;
    private String codigo;
    private String descricao;

    public Natureza(int id, String codigo, String descricao) {
        this.id = id;
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Natureza() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
