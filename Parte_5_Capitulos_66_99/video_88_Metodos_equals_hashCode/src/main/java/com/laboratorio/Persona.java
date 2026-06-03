package com.laboratorio;

import java.util.Objects;

public class Persona {
    String nombre;
    String apellido;
    short edad;
    String nroDocumento;

    public Persona(String nombre,
                   String apellido,
                   short edad,
                   String nroDocumento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.nroDocumento = nroDocumento;
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

    public short getEdad() {
        return edad;
    }

    public void setEdad(short edad) {
        this.edad = edad;
    }

    public String getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(String nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", nroDocumento='" + nroDocumento + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return Objects.equals(nroDocumento, persona.nroDocumento);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nroDocumento);
    }
}
