package com.laboratorio.video_126_jms_comunicacion_asincrona_mensajes_4;

import com.laboratorio.video_126_jms_comunicacion_asincrona_mensajes_4.modelo.Persona;
import java.util.Date;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import org.apache.activemq.artemis.commons.shaded.json.JsonException;
import tools.jackson.databind.ObjectMapper;

public class Sender implements Runnable{
    private final QueueSession session;
    private final QueueSender sender;

    public Sender(QueueConnection connection, Queue queue)throws Exception {
        this.session = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
        this.sender = this.session.createSender(queue);
    }
    
    

    @Override
    public void run() {
        
        Message message;
        
        try{
            for(int i=0; i<10; i++){
                if(i %2 == 0){
                    message = this.session.createTextMessage(String.format("Mensaje numero %02d",i+1));
                    message.setJMSType("Mensaje");
                }else{
                    Persona persona = new Persona(i,"Test","Test",new Date(),i);
                    ObjectMapper objectMapper = new ObjectMapper();
                    String personaStr = objectMapper.writeValueAsString(persona);
                    message = this.session.createTextMessage(personaStr);
                    message.setJMSType("Persona");
                    message.setJMSTimestamp(System.currentTimeMillis());
                    message.setStringProperty("Personalizada", "Valor personalizado");
                }
                message.setJMSMessageID(String.format("ID:MSG%d",i));
                this.sender.send(message);
                Thread.sleep(1000);
            }
        }catch(JsonException | InterruptedException | JMSException e){
            System.out.println("Error al enviar un mensaje");
                  
        }
    }
    
    public void cerrar()throws Exception{
        sender.close();
        session.close();
    }
}
