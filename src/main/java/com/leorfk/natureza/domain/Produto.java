package com.leorfk.natureza.domain;

public class Produto {
    private int id;
    private String codigo;
    private String descricao;
    private String sigla;

    public Produto(int id, String codigo, String descricao, String sigla) {
        this.id = id;
        this.codigo = codigo;
        this.descricao = descricao;
        this.sigla = sigla;
    }

    public Produto() {
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

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
}
