package com.laboratorio.cliente;

public class Contacto {
    private final int id;
    private final String nombre;

    public Contacto(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }
}
