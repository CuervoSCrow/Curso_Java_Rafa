
package com.laboratorio.video120_desarrollo_web_21_webservices_2_soap.service;

import com.laboratorio.video120_desarrollo_web_21_webservices_2_soap.entidad.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PersonaDB {
    private final Connection connection;
    private final String queryInsertar = "INSERT INTO personas (nombre,apellido,fecha_nacimiento,experiencia) "+
                    "VALUES(?,?,?,?)";
    private final String queryEditar="UPDATE personas SET nombre=?, apellidos=?, +"
            + "fecha_nacimineto=?, experiencia=? WHERE idpersonas=?";
    private final String queryBuscar="SELECT * FROM personas WHERE idpersonas=? ";
    private final String queryEliminar="DELETE FROM personas WHERE idpersonas=? ";

    public PersonaDB(Connection connection) {
        this.connection = connection;
    }
    
    public List<Persona> getPersonas()throws SQLException{
        List<Persona> personas = new ArrayList<>();
        Persona persona;
        int codigo,experiencia;
        String nombre,apellidos;
        Date fechaNac;
        try{
            String query="SELECT * FROM personas";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            
            while(resultSet.next()){
                codigo=resultSet.getInt("idPersonas");
                nombre = resultSet.getString("nombre");
                apellidos = resultSet.getString("apellidos");
                fechaNac = resultSet.getDate("fecha_nacimiento");
                experiencia=resultSet.getInt("experiencia");
                persona = new Persona(codigo, nombre, apellidos, fechaNac, experiencia);
                personas.add(persona);
            }
        }catch(SQLException e){
            throw e;
        }
        return personas;
    }
    
    public String validar(String nombre, String apellidos, String fechaNac,
                    String experiencia){
        StringBuilder resultado = new StringBuilder();
        
        if(nombre.isEmpty()){
            resultado.append("<p>El nombre no puede estar vacio</p>");
        }else{
            if(nombre.length()<3){
                resultado.append("<p>El nombre debe tener al menos 3 caracteres.</p>");
            }
        }
        if(apellidos.isEmpty()){
            resultado.append("<p>Los apellidos no pueden estar vacios</p>");
        }else{
            if(apellidos.length()<3){
                resultado.append("<p>Los apellidos deben tener al menos 3 caracteres.</p>");
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
            if(experiencia.matches("^(0-9)+$")){
                resultado.append("<p>La experiencia debe ser un numero.</p>");            
            }
        }
         
        return resultado.toString();
    }
    
    public boolean insertar(String nombre, String apellidos,
                            String fechaNac,String experiencia)throws
                            Exception{
        
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = formato.parse(fechaNac);
        java.sql.Date fechaSQL = new java.sql.Date(fecha.getTime());
        
        try{
            String query="INSERT INTO personas (nombre,apellidos,fecha_nacimiento,experiencia) "+
                    "VALUES(?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, nombre);
            ps.setString(2, apellidos);
            ps.setDate(3, fechaSQL);
            ps.setInt(4, Integer.parseInt(experiencia));
            int resultado = ps.executeUpdate();
            if(resultado==0){
                return false;
            }
        }catch(NumberFormatException | SQLException e){
            throw e;
        }
        
        return true;
    }
    
    public boolean editar(int codigo,String nombre,
                String apellidos, String fechaNac,
                String experiencia)throws Exception{
        
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = formato.parse(fechaNac);
        java.sql.Date fechaSQL = new java.sql.Date(fecha.getTime());
        
        try{
            PreparedStatement ps = connection.prepareStatement(queryEditar);
            ps.setString(1, nombre);
            ps.setString(2, apellidos);
            ps.setDate(3, fechaSQL);
            ps.setInt(4, Integer.parseInt(experiencia));
            ps.setInt(5, codigo);
            
            int resultado = ps.executeUpdate();
            if(resultado==0){
                return false;
            }        
        }catch(NumberFormatException | SQLException e){
            throw e;
        }
        return true;
    }
    
    public Persona buscar(int codigo) throws SQLException{
        Persona persona = null;
        try{
            PreparedStatement ps = connection.prepareStatement(queryBuscar);
            ps.setInt(1, codigo);
            ResultSet resultSet = ps.executeQuery();
            
            if(resultSet.next()){
                persona = new Persona();
                persona.setCodigo(codigo);
                persona.setNombre(resultSet.getString("nombre"));
                persona.setApellidos(resultSet.getString("apellidos"));
                persona.setFechaNac(resultSet.getDate("fecha_nacimiento"));
                persona.setExperiencia(resultSet.getInt("experiencia"));
            }
        }catch(SQLException e){
            throw e;
        }
        return persona;
    }
    
    public boolean eliminar(int codigo)throws Exception{
        try{
            PreparedStatement ps = connection.prepareStatement(queryEliminar);
            ps.setInt(1, codigo);
            int resultado = ps.executeUpdate();
            if(resultado == 0){
                return false;
            }
        }catch(SQLException e){
            throw e;
        }
        return true;
    }
}
