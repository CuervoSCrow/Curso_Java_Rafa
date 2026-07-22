
package com.laboratorio.video_138_enterprise_javabean_uniendo_componentes_jse_jee_1.receptor;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.ActivationConfigProperty;
import jakarta.ejb.MessageDriven;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;
import jakarta.jms.TextMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", 
                              propertyValue = "java:jboss/exported/jms/topic/tutorialtopic"),
//    @ActivationConfigProperty(propertyName = "connectionFactory", 
//                              propertyValue = "java:jboss/exported/jms/RemoteConnectionFactory"),
//    @ActivationConfigProperty(propertyName = "subscriptionDurability", 
//                              propertyValue = "Durable"),
//    @ActivationConfigProperty(propertyName = "subscriptionName", 
//                              propertyValue = "MiSubscripcionDurable"),
    @ActivationConfigProperty(propertyName = "user", 
                              propertyValue = "canzervero"),
    @ActivationConfigProperty(propertyName = "password", 
                              propertyValue = "cuervo")
    
})
public class ReceptorBean implements MessageListener{
    private static Logger logger = LoggerFactory.getLogger(ReceptorBean.class);
    
    @PostConstruct
    public void Inicializar(){
        logger.info("Se construyo el MDB Topic TutorialTopic ********************* ");
    }
    @Override
    public void onMessage(Message msg) {
        try{
            TextMessage message = (TextMessage) msg;
            
            String tipo = message.getStringProperty("TipoMensaje");
            logger.info("Se recibio del mensaje de tipo: "+tipo);
            
            switch(tipo){
                case "Prueba":
                    logger.info("Mensaje recibido.."+message.getText());
                    break;
                case "Persona":
                    logger.info("Persona recibida.. "+message.getText());
                    break;
                default:
                    logger.warn("Mensaje no soportado. "+message.getText());
                    break;
            }
        }catch(JMSException e){
            logger.error("Error procesando mensaje: "+e.getMessage());
        }
    }
      
}
