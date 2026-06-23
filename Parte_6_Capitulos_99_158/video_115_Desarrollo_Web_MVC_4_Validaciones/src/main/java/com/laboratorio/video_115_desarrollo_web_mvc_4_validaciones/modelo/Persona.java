
package com.laboratorio.video_115_desarrollo_web_mvc_4_validaciones.modelo;

import java.util.Date;

public class Persona {
    private int codigo;
    private String nombre;
    private String apellidos;
    private Date fechaNacimiento;
    private int experiencia;
    
    public Persona(){
        this.codigo=0;
        this.nombre="";
        this.apellidos="";
        this.fechaNacimiento=null;
        this.experiencia=0;
    }

    public Persona(int codigo, String nombre, String apellidos, Date fechaNacimiento, int experiencia) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
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

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }
    
    
    
    
    
    
    
}
