package com.leorfk.natureza.repository.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "VIEW_POF")
@Getter @Setter @NoArgsConstructor
public class ViewPof {
    @Id
    @Column(name = "ID_VIEW")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "NOME_VIEW", nullable = false, length = 100)
    private String nomeView;
    @Column(name = "NOME_PRODUTO", nullable = false, length = 100)
    private String nomeProduto;
    @Column(name = "CAMPO_CHAVE", length = 50)
    private String campoChave;
}
