package com.laboratorio.animales;

public class Animal {
    protected String tipo;
    protected String nombre;
    protected int edad;

    public Animal(String tipo, String nombre, int edad) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.edad = edad;
    }

    public void comer() {
        System.out.println(nombre+" de "+edad+" años esta comiendo");
    }

    public void dormir() {
        System.out.println(nombre+" de "+edad+" años esta durmiendo");
    }
    public void caminar() {
        System.out.println(nombre+" de "+edad+" años esta caminando");
    }
}
