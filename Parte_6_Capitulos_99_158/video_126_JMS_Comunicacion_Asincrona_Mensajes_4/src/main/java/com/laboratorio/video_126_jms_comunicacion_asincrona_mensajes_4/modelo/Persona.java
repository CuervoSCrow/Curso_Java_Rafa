
package com.laboratorio.video_126_jms_comunicacion_asincrona_mensajes_4.modelo;

import java.util.Date;


public class Persona {
    
    private int codigo;
    private String nombre;
    private String apellidos;
    private Date fechaNac;
    private int experencia;

    public Persona() {
        this.codigo = 0;
        this.nombre = "";
        this.apellidos = "";
        this.fechaNac = null;
        this.experencia = 0;
    }

    public Persona(int codigo, String nombre, String apellidos, Date fechaNac, int experencia) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNac = fechaNac;
        this.experencia = experencia;
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

    public int getExperencia() {
        return experencia;
    }

    public void setExperencia(int experencia) {
        this.experencia = experencia;
    }

    @Override
    public String toString() {
        return "Persona{" + 
                "codigo=" + codigo + 
                ", nombre=" + nombre + 
                ", apellidos=" + apellidos + 
                ", fechaNac=" + fechaNac + 
                ", experencia=" + experencia + '}';
    }    
}
