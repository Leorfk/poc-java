package com.leorfk.natureza.domain;

import com.leorfk.natureza.domain.enums.Interacao;
import com.leorfk.natureza.domain.enums.StatusParametro;

import java.util.Date;

public class Parametro {

    private int id;
    private Date data;
    private Integer status;
    private String interacao;

    private Usuario usuario;
    private Natureza natureza;
    private Produto produto;
    private  Recolhimento recolhimento;

    public Parametro(int id, Date data, StatusParametro status, Interacao interacao, Usuario usuario,
                     Natureza natureza, Produto produto, Recolhimento recolhimento) {
        this.id = id;
        this.data = data;
        this.status = status == null ? null: status.getCodigo();
        this.interacao = interacao == null ? null: interacao.getDescricao();
        this.usuario = usuario;
        this.natureza = natureza;
        this.produto = produto;
        this.recolhimento = recolhimento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public StatusParametro getStatus() {
        return StatusParametro.toEnum(status);
    }

    public void setStatus(StatusParametro status) {
        this.status = status.getCodigo();
    }

    public String getInteracao() {
        return interacao;
    }

    public void setInteracao(Interacao interacao) {
        this.interacao = interacao.getDescricao();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Natureza getNatureza() {
        return natureza;
    }

    public void setNatureza(Natureza natureza) {
        this.natureza = natureza;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Recolhimento getRecolhimento() {
        return recolhimento;
    }

    public void setRecolhimento(Recolhimento recolhimento) {
        this.recolhimento = recolhimento;
    }
}
