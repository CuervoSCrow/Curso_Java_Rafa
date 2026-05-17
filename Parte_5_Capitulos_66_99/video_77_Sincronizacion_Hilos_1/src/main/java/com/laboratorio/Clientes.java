package com.laboratorio;

public class Clientes {
    private int numero;
    private int tiempoAtencion;

    public Clientes(int numero) {
        this.numero = numero;
        this.tiempoAtencion = (int)(Math.random()*5+1);
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getTiempoAtencion() {
        return tiempoAtencion;
    }

    public void setTiempoAtencion(int tiempoAtencion) {
        this.tiempoAtencion = tiempoAtencion;
    }
}
