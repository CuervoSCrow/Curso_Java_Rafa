
package com.laboratorio.video_136_enterprise_java_bean_singleton.service;

import com.laboratorio.video_136_enterprise_java_bean_singleton.productor.ProductorJMSBean;
import jakarta.ejb.EJB;
import jakarta.jms.Message;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/mensaje")
public class EnvioMensajeService {
    private static final Logger logger = LoggerFactory.getLogger(EnvioMensajeService.class);
    
    @EJB
    private ProductorJMSBean productor;
    
    @GET
    public String enviarMensaje(){
        logger.trace("Enviando un mensaje");
        try{
            Message message = productor.getSession().createTextMessage("Mensaje de prueba");
            productor.enviarMensaje(message);
        }catch(Exception e){
            logger.error("Error enviando mensaje: "+e.getMessage());
        }
        return "Mensaje enviado";
    }
}
