package com.vgs.imobiliarium.enums;

public enum TipoComissao {
    ALUGUEL("ALUGUEL"),
    VENDA("VENDA");

    private String tipoComissao;

    TipoComissao(String tipoComissao){
        this.tipoComissao = tipoComissao;
    }

    public String getTipoComissao() {
        return tipoComissao;
    }
}
