package com.laboratorio;

public class Hija1 {
    String argumento;

    public Hija1(String argumento) {

        this.argumento = argumento;

    }

    public String getArgumento() {
        return argumento;
    }

    public void setArgumento(String argumento) {
        this.argumento = argumento;
    }


    public void mostrar() {
        System.out.println("El Argumento es: " + argumento);
    }
}
