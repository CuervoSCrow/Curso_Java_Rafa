
package com.laboratorio.video120_desarrollo_web_21_webservices_2_soap.entidad;

import java.util.Date;

public class Persona {
    
    private int codigo;
    private String nombre;
    private String apellidos;
    private Date fechaNac;
    private int experiencia;

    public Persona() {
        this.codigo=0;
        this.nombre="";
        this.apellidos="";
        this.fechaNac=null;
        this.experiencia=0;
    }

    public Persona(int codigo, String nombre, String apellidos, Date fechaNac, int experiencia) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNac = fechaNac;
        this.experiencia = experiencia;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }
    
    
    
    
}

