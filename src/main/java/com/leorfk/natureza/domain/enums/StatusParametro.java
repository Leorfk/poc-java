package com.leorfk.natureza.domain.enums;

public enum StatusParametro {
    APROVACAO_PENDENTE(0, "Aprovação Pendente"),
    APROVADO(1, "Ativo"),
    INATIVACAO_PENDENTE(2, "Inativação Pendente"),
    INATIVO(3, "Inativo"),
    REPROVADO(4,"Reprovado");

    private final Integer codigo;
    private final String descricao;

    StatusParametro(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static StatusParametro toEnum(Integer codigo){
        if(codigo == null){
            return null;
        }

        for (StatusParametro parametro:StatusParametro.values()) {
            if(codigo.equals(parametro.getCodigo())){
                return parametro;
            }
        }

        throw new IllegalArgumentException("Status desconhecido: " + codigo);
    }
}
