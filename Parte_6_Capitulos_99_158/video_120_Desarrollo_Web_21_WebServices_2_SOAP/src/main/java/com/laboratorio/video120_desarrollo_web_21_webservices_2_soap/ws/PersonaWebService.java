/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package com.laboratorio.video120_desarrollo_web_21_webservices_2_soap.ws;

import com.laboratorio.video120_desarrollo_web_21_webservices_2_soap.entidad.Persona;
import com.laboratorio.video120_desarrollo_web_21_webservices_2_soap.service.PersonaDB;
import com.laboratorio.video120_desarrollo_web_21_webservices_2_soap.util.ConnectionPoolManager;
import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author canzervero
 */
@WebService(serviceName = "PersonaWebService")
public class PersonaWebService {
    private Connection connection;
    private PersonaDB personaDB;
    
    
    public PersonaWebService(){
        try{
            connection = ConnectionPoolManager.getConnection();
            personaDB = new PersonaDB(connection);
        }catch(SQLException e){
            connection = null;
            personaDB = null;
        }

    }
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "ListarPersonas")
    public List<Persona> listarPersonas() {
        if(personaDB==null){
            return new ArrayList<>();
        }
        try{
            return personaDB.getPersonas();
        }catch(SQLException e){
            return new ArrayList<>();
        }
        
    }
    
    @WebMethod(operationName = "CrearPersona")
    public Resultado crearPersona(
            @WebParam(name = "nombre") String nombre,
            @WebParam(name = "apellidos") String apellidos,
            @WebParam(name = "fechaNac") String fechaNac,
            @WebParam(name = "experiencia") int experiencia) {
        
        if (personaDB == null) {
            return new Resultado(-1, "No hay conexión a la base datos");
        }
        
        String validaciones = personaDB.validar(nombre, apellidos, fechaNac, String.valueOf(experiencia));
        if (!validaciones.isEmpty()) {
            return new Resultado(-2, validaciones);
        }
        
        try {
            if (!personaDB.insertar(nombre, apellidos, fechaNac, String.valueOf(experiencia))) {
                return new Resultado(0, "Se ha presentado un error al insertar la persona");
            }
        } catch (Exception e) {
            return new Resultado(-3, "Se ha presentado un error desconocido al insertar la persona");
        }
        
        return new Resultado(1, "Se ha insertado la persona correctamente");
    }
}
