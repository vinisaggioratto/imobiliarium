package com.vgs.imobiliarium.enums;

public enum FinalidadeImovel {
    VENDA("Venda"),
    ALUGUEL("Aluguel");

    private String finalidade;

    FinalidadeImovel(String finalidade){
        this.finalidade = finalidade;
    }

    public String getFinalidade() {
        return finalidade;
    }
}
