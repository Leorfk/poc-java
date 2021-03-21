package com.leorfk.natureza.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
public class ViewPofDTO {

    private Integer id;
    private String nomeView;
    private String nomeProduto;
    private String campoChave;

    public ViewPofDTO() {
    }

    public static class Builder{
        private Integer id;
        private String nomeView;
        private String nomeProduto;
        private String campoChave;

        public Builder(String nomeProduto) {
            this.nomeProduto = nomeProduto;
        }

        public Builder id(Integer id){
            this.id = id;
            return this;
        }

        public Builder nomeView(String nomeView){
            this.nomeView = nomeView;
            return this;
        }

        public Builder campoChave(String campoChave){
            this.campoChave = campoChave;
            return this;
        }

        public ViewPofDTO build(){
            return new ViewPofDTO(this);
        }
    }
    private ViewPofDTO(Builder builder){
        this.id = builder.id;
        this.nomeProduto = builder.nomeProduto;
        this.nomeView = builder.nomeView;
        this.campoChave = builder.campoChave;
    }
}
