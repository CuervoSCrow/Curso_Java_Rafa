
package com.laboratorio.video_122_desarrollo_web_23_web_service_4_wsrestful.ws;

import com.laboratorio.video_122_desarrollo_web_23_web_service_4_wsrestful.modelo.Persona;
import com.laboratorio.video_122_desarrollo_web_23_web_service_4_wsrestful.modelo.PersonaDB;
import com.laboratorio.video_122_desarrollo_web_23_web_service_4_wsrestful.util.ConnectionPoolManager;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


@Path("personas")
@RequestScoped
public class PersonasResource {

    @Context
    private UriInfo context;

    private Connection connection;
    private PersonaDB personaDB;
    
    public PersonasResource() {
        try{
            connection = ConnectionPoolManager.getConnection();
            personaDB = new PersonaDB(connection);
        }catch(SQLException e){
            connection = null;
            personaDB = null;
        }
    }

   
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("listar")
    public List<Persona> listarPersonas() {
        if(personaDB == null){
            return new ArrayList<>();
        }
        try{
            return personaDB.getPersonas();
        }catch(SQLException e){
            return new ArrayList<>();
        }
    }

    /**
     * PUT method for updating or creating an instance of PersonasResource
     * @param content representation for the resource
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("guardar")
    public Persona guardarPersona(Persona persona) {
        if(personaDB==null){
            return new Persona();
        }
        try{
            
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            String fechaTexto=formato.format(persona.getFechaNac());
            String experiencia = String.valueOf(persona.getExperiencia());
            if(!personaDB.insertar(persona.getNombre(),persona.getApellidos(),fechaTexto, experiencia)){
                return new Persona();
            }
            
        }catch(Exception e){
            return new Persona();
        }
        return persona;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("buscar/{id}")
    public Persona buscarPersona(@PathParam("id") int id){
        if(personaDB == null){
            return new Persona();
        }
        
        Persona persona;
                
        try{
            persona = personaDB.buscar(id);
            if(persona==null){
                return new Persona();
            }
        }catch(Exception e){
            return new Persona();
        }
        return persona;
    }
}
