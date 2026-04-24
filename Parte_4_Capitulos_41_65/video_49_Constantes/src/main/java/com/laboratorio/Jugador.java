package com.laboratorio;

public class Jugador {
    private final String nombre;
    private int nivel;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.nivel = 1;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void mostrarJugador() {
        System.out.println("Nombre: " + nombre + " - Nivel: " + nivel);
    }
}
