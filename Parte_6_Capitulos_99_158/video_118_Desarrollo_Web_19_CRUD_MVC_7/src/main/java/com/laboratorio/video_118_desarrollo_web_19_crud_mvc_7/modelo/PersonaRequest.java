
package com.laboratorio.video_118_desarrollo_web_19_crud_mvc_7.modelo;

import java.text.SimpleDateFormat;

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
    
    public PersonaRequest(Persona persona){
        this.codigo = persona.getCodigo();
        this.nombre = persona.getNombre();
        this.apellidos = persona.getApellidos();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        this.fechaNac=formato.format(persona.getFechaNacimiento());
        this.experiencia=String.valueOf(persona.getExperiencia());
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
