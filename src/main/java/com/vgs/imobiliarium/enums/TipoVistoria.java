package com.vgs.imobiliarium.enums;

public enum TipoVistoria {
    ALUGUEL_ENTRADA("Entrada para aluguel"),
    ALUGUEL_SAIDA("Saída de aluguel"),
    IMOVEL_NOVO("Imóvel novo"),
    ORCAMENTO_TERCEIROS("Orçamento para terceiros"),
    VENDA("Venda");

    private String vistoria;

    TipoVistoria(String vistoria){
        this.vistoria = vistoria;
    }

    public String getVistoria() {
        return vistoria;
    }
}
