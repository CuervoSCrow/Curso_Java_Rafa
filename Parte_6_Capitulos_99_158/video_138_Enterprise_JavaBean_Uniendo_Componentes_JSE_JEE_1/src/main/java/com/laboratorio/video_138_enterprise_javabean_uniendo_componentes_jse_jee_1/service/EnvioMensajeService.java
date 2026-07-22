
package com.laboratorio.video_138_enterprise_javabean_uniendo_componentes_jse_jee_1.service;

import com.laboratorio.video_138_enterprise_javabean_uniendo_componentes_jse_jee_1.modelo.Persona;
import com.laboratorio.video_138_enterprise_javabean_uniendo_componentes_jse_jee_1.productor.ProductorJMSBean;
import jakarta.ejb.EJB;
import jakarta.jms.Message;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tools.jackson.databind.ObjectMapper;

@Path("/mensaje")
public class EnvioMensajeService {
    private static final Logger logger = LoggerFactory.getLogger(EnvioMensajeService.class);
    
    @EJB
    private ProductorJMSBean productor;
    
    @GET
    public String enviarMensaje(){
        logger.info("Enviando un mensaje");
        try{
            Message message = productor.getSession().createTextMessage("Mensaje de prueba...");
            message.setStringProperty("TipoMensaje", "Prueba");
            productor.enviarMensaje(message);
        }catch(Exception e){
            logger.error("Error enviando mensaje "+e.getMessage());            
        }
        return "Mensaje Enviado";
    }
    
    @POST
    @Path("/persona")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Persona crearPersona(Persona persona){
        logger.info("Creando a una nueva persona...");
        try{
            ObjectMapper mapper = new ObjectMapper();
            String jsonString = mapper.writeValueAsString(persona);
            Message message = productor.getSession().createTextMessage(jsonString);
            message.setStringProperty("TipoMensaje", "Persona");
            productor.enviarMensaje(message);
            
        }catch(Exception e){
            logger.error("Error creando persona "+e.getMessage());
            return null;
        }
        return persona;
    }
    
}
