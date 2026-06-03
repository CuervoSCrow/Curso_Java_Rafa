package com.laboratorio;

public class Persona implements Comparable<Persona>{
    private int codigo;
    private String documento;
    private String nombre;

    public Persona(int codigo, String documento, String nombre) {
        this.codigo = codigo;
        this.documento = documento;
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "codigo=" + codigo +
                ", documento='" + documento + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    @Override
    public int compareTo(Persona o) {
        if(this.documento.equalsIgnoreCase(o.getDocumento())){
            return 0;
        }else{
            return this.documento.compareToIgnoreCase(o.getDocumento());
        }

    }
}
