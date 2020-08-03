package com.leorfk.natureza.dto;

import com.leorfk.natureza.domain.Natureza;
import com.leorfk.natureza.domain.Produto;
import com.leorfk.natureza.domain.Recolhimento;
import com.leorfk.natureza.domain.Usuario;

import java.util.Date;

public class ParametrizacaoDTO {
    private int id;
    private Date data;
    private Integer status;
    private String interacao;

    private String raf;
    private String motivo;

    private String codigoNatureza;
    private String descricaoNatureza;

    private String codigoRecolhimento;
    private String descricaoRecolhimento;

    private String sigla;
    private String codigoProduto;
    private String descricaoProduto;

    public ParametrizacaoDTO(int id, Date data, Integer status, String interacao, String raf, String motivo,
         String codigoNatureza, String descricaoNatureza, String codigoRecolhimento, String descricaoRecolhimento,
         String sigla, String codigoProduto, String descricaoProduto) {
        this.id = id;
        this.data = data;
        this.status = status;
        this.interacao = interacao;
        this.raf = raf;
        this.motivo = motivo;
        this.codigoNatureza = codigoNatureza;
        this.descricaoNatureza = descricaoNatureza;
        this.codigoRecolhimento = codigoRecolhimento;
        this.descricaoRecolhimento = descricaoRecolhimento;
        this.sigla = sigla;
        this.codigoProduto = codigoProduto;
        this.descricaoProduto = descricaoProduto;
    }

    public ParametrizacaoDTO() {
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getInteracao() {
        return interacao;
    }

    public void setInteracao(String interacao) {
        this.interacao = interacao;
    }

    public String getRaf() {
        return raf;
    }

    public void setRaf(String raf) {
        this.raf = raf;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getCodigoNatureza() {
        return codigoNatureza;
    }

    public void setCodigoNatureza(String codigoNatureza) {
        this.codigoNatureza = codigoNatureza;
    }

    public String getDescricaoNatureza() {
        return descricaoNatureza;
    }

    public void setDescricaoNatureza(String descricaoNatureza) {
        this.descricaoNatureza = descricaoNatureza;
    }

    public String getCodigoRecolhimento() {
        return codigoRecolhimento;
    }

    public void setCodigoRecolhimento(String codigoRecolhimento) {
        this.codigoRecolhimento = codigoRecolhimento;
    }

    public String getDescricaoRecolhimento() {
        return descricaoRecolhimento;
    }

    public void setDescricaoRecolhimento(String descricaoRecolhimento) {
        this.descricaoRecolhimento = descricaoRecolhimento;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(String codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }
}
