package com.laboratorio;

public class Persona {
    private String nombre;
    private int edad;
    private String documento;

    public Persona(
            String nombre,
            int edad,
            String documento){
        this.nombre = nombre;
        this.edad = edad;
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", documento='" + documento + '\'' +
                '}';
    }
}
