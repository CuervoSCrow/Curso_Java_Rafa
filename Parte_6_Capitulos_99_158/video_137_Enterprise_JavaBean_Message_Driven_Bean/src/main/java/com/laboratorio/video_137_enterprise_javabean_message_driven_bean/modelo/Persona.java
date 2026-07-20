
package com.laboratorio.video_137_enterprise_javabean_message_driven_bean.modelo;

import java.util.Date;



public class Persona {
    private int codigo;
    private String nombres;
    private String apellidos;
    private Date fechaNac;
    private int experiencia;    

    public Persona() {
        this.codigo=0;
        this.nombres="";
        this.apellidos="";
        this.fechaNac=null;
        this.experiencia=0;
    }

    public Persona(int codigo, String nombres, String apellidos, Date fechaNac, int experiencia) {
        this.codigo = codigo;
        this.nombres = nombres;
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

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
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

    @Override
    public String toString() {
        return "Persona{" + 
                "codigo=" + codigo + 
                ", nombres=" + nombres + 
                ", apellidos=" + apellidos + 
                ", fechaNac=" + fechaNac + 
                ", experiencia=" + experiencia + '}';
    }
    
    
    
    
}


