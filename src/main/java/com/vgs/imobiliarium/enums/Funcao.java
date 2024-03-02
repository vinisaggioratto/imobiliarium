package com.vgs.imobiliarium.enums;

public enum Funcao {

    SECRETARIA("Secretária"),
    VISTORIADOR("Vistoriador"),
    MANUTENCAO("Zelador"),
    AUXILIAR_ADMINISTRATIVO("Auxiliar Administrativo"),
    PROPRIETARIO("Proprietário");

    private String funcao;
    Funcao(String funcao) {
        this.funcao = funcao;
    }

    public String getFuncao(){
        return funcao;
    }
}
