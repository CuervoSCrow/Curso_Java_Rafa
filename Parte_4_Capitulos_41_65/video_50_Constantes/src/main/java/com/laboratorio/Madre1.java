package com.laboratorio;

public  final class Madre1 {
    String nombre;

    public Madre1(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void mostrar() {
        System.out.println("El Nombre es: " + nombre);
    }
}
