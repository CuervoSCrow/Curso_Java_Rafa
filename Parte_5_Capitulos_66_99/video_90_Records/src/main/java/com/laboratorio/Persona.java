package com.laboratorio;

public record Persona(
        String nombre,
        String apellido,
        int edad,
        String ciudad,
        boolean tieneEmpleo
) {
    public Persona (String nombre,
                    String apellido,
                    int edad,
                    String ciudad){
        this(nombre,apellido,edad,ciudad,true);
    }
    public String nombreCompleto(){
        return nombre+" "+apellido;
    }
}
