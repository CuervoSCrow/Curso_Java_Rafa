package com.laboratorio.video_125_jms_comunicacion_asincrona_3;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;

public class Sender implements Runnable{
    private final QueueSession session;
    private final QueueSender sender;

    public Sender(QueueConnection connection, Queue queue)throws Exception {
        this.session = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
        this.sender = this.session.createSender(queue);
    }
    
    

    @Override
    public void run() {
        
        try{
            for(int i=0; i<10; i++){
                Message message = this.session.createTextMessage(String.format("Mensaje numero %02d",i+1));
                this.sender.send(message);
                Thread.sleep(1000);
            }
        }catch(InterruptedException | JMSException e){
            System.out.println("Error al enviar un mensaje");
                  
        }
    }
    
    public void cerrar()throws Exception{
        sender.close();
        session.close();
    }
}
