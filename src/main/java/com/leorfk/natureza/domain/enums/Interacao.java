package com.leorfk.natureza.domain.enums;

public enum Interacao {
    CADASTRO(0, "Cadastro"),
    ALTERACAO(1, "Alteração"),
    INATIVACAO(2,"Inativação"),
    APROVACAO(3, "Aprovação"),
    REPROVACAO(4,"Reprovação");

    private Integer codigo;
    private String descricao;

    Interacao(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Interacao toEnum(Integer codigo){
        if(codigo == null){
            return null;
        }
        for (Interacao interacao: Interacao.values()) {
            if(codigo.equals(interacao.getCodigo())){
                return interacao;
            }
        }

        throw new IllegalArgumentException("Funcionalidade inexistente: " + codigo);
    }
}
