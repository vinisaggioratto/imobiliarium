package com.vgs.imobiliarium.enums;

public enum FinalidadeImovel {
    ALUGUEL("Aluguel"),
    VENDA("Venda");

    private String finalidade;

    FinalidadeImovel(String finalidade){
        this.finalidade = finalidade;
    }

    public String getFinalidade() {
        return finalidade;
    }
}
