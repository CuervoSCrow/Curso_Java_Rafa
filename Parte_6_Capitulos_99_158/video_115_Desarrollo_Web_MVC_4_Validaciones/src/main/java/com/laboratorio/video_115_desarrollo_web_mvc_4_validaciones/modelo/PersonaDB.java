
package com.laboratorio.video_115_desarrollo_web_mvc_4_validaciones.modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PersonaDB {
    
    private Connection connection;

    public PersonaDB(Connection connecion) {
        this.connection = connecion;
    }
    
    public List<Persona> getPersonas() throws SQLException{
       List<Persona> personas = new ArrayList<>();
       Persona persona;
       int codigo,experiencia;
       String nombre,apellidos;
       Date fechaNac;
       try{
           String query="SELECT * FROM personas";
           Statement statement = connection.createStatement();
           ResultSet resultSet  = statement.executeQuery(query);
           
           while(resultSet.next()){
               codigo=resultSet.getInt("idPersonas");
               nombre=resultSet.getString("nombre");
               apellidos=resultSet.getString("Apellidos");               
               experiencia=resultSet.getInt("experiencia");
               fechaNac = resultSet.getDate("fecha_nacimiento");
               persona = new Persona(codigo,nombre,apellidos,fechaNac,experiencia);
               personas.add(persona);
           }           
       }catch(SQLException e){
           throw e;
       }
       return personas;       
    }
    
    public String validar(
            String nombre,
            String apellidos, 
            String fechaNac,
            String experiencia){
        StringBuilder resultado = new StringBuilder("");
        
        if(nombre.isEmpty()){
            resultado.append("<p>El nombre no puede estar vacio");
        }else{
            if(nombre.length()<2){
                resultado.append("<p>El nombre debe tener al menos 2 caracteres");
            }
        }
        if(apellidos.isEmpty()){
            resultado.append("<p>Los Apellidos no puede estar vacios");
        }else{
            if(nombre.length()<2){
                resultado.append("<p>Los Apellidos debe tener al menos 2 caracteres");
            }
        }
        if(fechaNac.isEmpty()){
            resultado.append("<p>La fecha de nacimiento no puede estar vacia.</p>");
        }else{
            if(!fechaNac.matches("^(?:(19|20)\\d{2})-(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-8])$|^(?:(19|20)(?:[02468][048]|[13579][26]))-02-29$|^(?:(19|20)\\d{2})-(?:0[13-9]|1[0-2])-(?:29|30)$|^(?:(19|20)\\d{2})-(?:0[13578]|1[02])-31$")){
                resultado.append("<p>La fecha tiene un formato incorrecto.</p>");
            }
        }
        
        if(experiencia.isEmpty()){
            resultado.append("<p>La experiencia no puede estar vacia.");
        }else{
            if(!experiencia.matches("^(0-9)+$")){
                resultado.append("<p>La experiencia debe ser un numero.</p>");
            }else{
                if(Integer.parseInt(experiencia)<0){
                    resultado.append("<p>La experiencia debe ser mayor o igual a 0.");
                }
            }
        }
        
        return resultado.toString();
    }
    
}
