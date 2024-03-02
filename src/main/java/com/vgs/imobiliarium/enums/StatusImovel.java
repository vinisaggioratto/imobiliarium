package com.vgs.imobiliarium.enums;

public enum StatusImovel {
    CANCELADO("Cancelado"),
    DISPONIVEL("Disponível"),
    PAUSADO("Pausado"),
    RESERVADO("Reservado"),
    VENDIDO("Vendido");

    private String status;

    StatusImovel(String status){
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
