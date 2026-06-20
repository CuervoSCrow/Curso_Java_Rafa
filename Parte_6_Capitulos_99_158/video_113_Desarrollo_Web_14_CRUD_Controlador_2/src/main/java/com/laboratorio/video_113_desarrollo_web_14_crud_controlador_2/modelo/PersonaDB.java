
package com.laboratorio.video_113_desarrollo_web_14_crud_controlador_2.modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PersonaDB {
    
    private Connection connection;

    public PersonaDB(Connection connection) {
        this.connection = connection;
    }
    
    public List<Persona> getPersonas() throws SQLException{
        
        List<Persona> personas = new ArrayList<>();
        Persona persona;
        int codigo,experiencia;
        String nombre,apellidos;
        Date fechaNac;
        try{
            String query ="SELECT * FROM personas";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            
            while(resultSet.next()){
                codigo= resultSet.getInt("idPersonas");
                nombre= resultSet.getString("nombre");
                apellidos = resultSet.getString("apellidos");
                fechaNac = resultSet.getDate("fecha_nacimiento");
                experiencia=resultSet.getInt("experiencia");
                persona = new Persona(codigo,nombre,apellidos,fechaNac,experiencia);
                personas.add(persona);
            }
        }catch(SQLException ex){
            throw ex;
        }
        return personas;
    }
    
}
