package com.webhostapp.mantis_bugtracker.mantisbt.enums;

public enum FormatoData {
    DIA_MES_ANO_HORA_MINUTO_SEGUNDO_MILESIMOS("dd/MM/yyyy HH:mm:ss.SSS"),
    DIA_MES_ANO_HORA_MINUTO_SEGUNDO_MILESIMOS_SEM_SEPARADOR("ddMMyyyyHHmmssSSS");

    private String f;

    private FormatoData(String valor) {
        f = valor;
    }

    public String valor() {
        return f;
    }
}
