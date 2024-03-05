package com.vgs.imobiliarium.enums;

public enum Estado {

//    AC,
//    AL,
//    AP,
//    AM,
//    BA,
//    CE,
//    DF,
//    ES,
//    GO,
//    MA,
//    MT,
//    MS,
//    MG,
//    PA,
//    PB,
//    PR,
//    PE,
//    PI,
//    RJ,
//    RN,
//    RS,
//    RO,
//    RR,
//    SC,
//    SP,
//    SE,
//    TO

    AC("Acre"),
    AL("Alagoas"),
    AP("Amapá"),
    AM("Amazonas"),
    BA("Bahia"),
    CE("Ceará"),
    DF("Distrito Federal"),
    ES("Espírito Santo"),
    GO("Goiás"),
    MA("Maranhão"),
    MT("Mato Grosso"),
    MS("Mato Grosso do Sul"),
    MG("Minas Gerais"),
    PA("Pará"),
    PB("Paraíba"),
    PR("Paraná"),
    PE("Pernambuco"),
    PI("Piauí"),
    RJ("Rio de Janeiro"),
    RN("Rio Grande do Norte"),
    RS("Rio Grande do Sul"),
    RO("Rondônia"),
    RR("Roraima"),
    SC("Santa Catarina"),
    SP("São Paulo"),
    SE("Sergipe"),
    TO("Tocantins");

    private String estado;

    Estado(String estado){
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }
}
