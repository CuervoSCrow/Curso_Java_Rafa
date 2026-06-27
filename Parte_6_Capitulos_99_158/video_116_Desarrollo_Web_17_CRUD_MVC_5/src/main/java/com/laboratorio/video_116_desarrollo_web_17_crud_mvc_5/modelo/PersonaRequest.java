
package com.laboratorio.video_116_desarrollo_web_17_crud_mvc_5.modelo;

public class PersonaRequest {
    private int codigo;
    private String nombre;
    private String apellidos;
    private String fechaNac;
    private String experiencia;

    public PersonaRequest() {
        this.codigo=0;
        this.nombre="";
        this.apellidos="";
        this.fechaNac=null;
        this.experiencia = "0";
    }

    public PersonaRequest(int codigo, String nombre, String apellidos, String fechaNac, String experiencia) {
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

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    
    
    
    
}
