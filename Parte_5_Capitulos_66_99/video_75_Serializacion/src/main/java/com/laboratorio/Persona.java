package com.laboratorio;

import java.io.Serializable;

public class Persona implements Serializable {
    private static final long serialVersionUID=2L;
    private String nombre;
    private String apellido;
    private int edad;
    private transient int dato;

    public Persona(String nombre, String apellido, int edad,int dato) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.dato = dato;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad='" + edad + '\'' +
                '}';
    }
}
