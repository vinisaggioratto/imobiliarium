package com.vgs.imobiliarium.enums;

public enum TipoImovel {
    APARTAMENTO("Apartamento"),
    BARRACAO("Barracão"),
    CASA("Casa"),
    CHACARA("Chácara"),
    EMPRESA("Empresa"),
    FAZENDA("Fazenda"),
    SALA_COMERCIAL("Sala Comercial"),
    SITIO("Sítio"),
    TERRENO("Terreno");


    private String tipoImovel;

    TipoImovel(String tipoImovel){
        this.tipoImovel = tipoImovel;
    }

    public String getTipoImovel() {
        return tipoImovel;
    }
}
