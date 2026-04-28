package com.laboratorio;

public enum DiaSemana {
    LUNES("L"),
    MARTES("Ma"),
    MIERCOLES("Mi"),
    JUEVES("J"),
    VIERNES("V"),
    SABADO("S"),
    DOMINGO("D");

    private String abrev;

    private DiaSemana(String abrev){
        this.abrev = abrev;
    }

    public String getAbrev() {
        return abrev;
    }
}
