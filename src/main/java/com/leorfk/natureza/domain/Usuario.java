package com.leorfk.natureza.domain;

public class Usuario {
    private int id;
    private String nome;
    private String racf;
    private String funcional;

    public Usuario(int id, String nome, String racf, String funcional) {
        this.id = id;
        this.nome = nome;
        this.racf = racf;
        this.funcional = funcional;
    }

    public Usuario() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRacf() {
        return racf;
    }

    public void setRacf(String racf) {
        this.racf = racf;
    }

    public String getFuncional() {
        return funcional;
    }

    public void setFuncional(String funcional) {
        this.funcional = funcional;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
