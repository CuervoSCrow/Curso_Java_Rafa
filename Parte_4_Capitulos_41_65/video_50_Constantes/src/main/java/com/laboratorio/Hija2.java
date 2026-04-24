package com.laboratorio;

public class Hija2 extends Madre2{
    String argumento;

    public Hija2(String argumento,String nombre) {
        super(nombre);
        this.argumento = argumento;
    }

    public String getArgumento() {
        return argumento;
    }

    public void setArgumento(String argumento) {
        this.argumento = argumento;
    }

    public void mostrar(int valor){
        System.out.println("El Argumento es: " + argumento +
                " y el valor es: " + valor);
    }
}
