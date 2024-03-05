package com.vgs.imobiliarium.enums;

public enum Funcao {

    AUXILIAR_ADMINISTRATIVO("Auxiliar Administrativo"),
    PROPRIETARIO("Proprietário"),
    SECRETARIA("Secretária"),
    VISTORIADOR("Vistoriador"),
    ZELADOR("Zelador");

    private String funcao;
    Funcao(String funcao) {
        this.funcao = funcao;
    }

    public String getFuncao(){
        return funcao;
    }
}
