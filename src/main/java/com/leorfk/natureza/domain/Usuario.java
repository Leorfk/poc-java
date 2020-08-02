package com.leorfk.natureza.domain;

public class Usuario {
    private int id;
    private String racf;
    private String motivo;

    public Usuario(int id, String racf, String motivo) {
        this.id = id;
        this.racf = racf;
        this.motivo = motivo;
    }

    public Usuario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRacf() {
        return racf;
    }

    public void setRacf(String racf) {
        this.racf = racf;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
}
