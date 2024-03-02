package com.vgs.imobiliarium.enums;

public enum TipoImovel {

    CASA("Casa"),
    APARTAMENTO("Apartamento"),
    BARRACAO("Barracão"),
    TERRENO("Terreno"),
    SITIO("Sítio"),
    CHACARA("Chácara"),
    FAZENDA("Fazenda"),
    SALA_COMERCIAL("Sala Comercial"),
    EMPRESA("Empresa");

    private String tipoImovel;

    TipoImovel(String tipoImovel){
        this.tipoImovel = tipoImovel;
    }

    public String getTipoImovel() {
        return tipoImovel;
    }
}
