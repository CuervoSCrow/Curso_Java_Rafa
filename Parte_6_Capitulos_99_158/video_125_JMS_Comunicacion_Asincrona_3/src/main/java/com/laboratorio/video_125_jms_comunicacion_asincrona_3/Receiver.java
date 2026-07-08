
package com.laboratorio.video_125_jms_comunicacion_asincrona_3;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;

public class Receiver implements MessageListener{
    
    private final int id;
    private final QueueSession session;
    private final QueueReceiver receiver;

    public Receiver(int id, QueueConnection connection, Queue queue )throws Exception{
        this.id = id;
        this.session = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
        this.receiver = this.session.createReceiver(queue);
        this.receiver.setMessageListener(this);
    }
    
    @Override
    public void onMessage(Message msg) {
        try{
            TextMessage message = (TextMessage)msg;
            System.out.printf("El receptor %d recibe el mensaje: %s\n",id,message.getText());
        }catch(JMSException e){
            System.out.println("Error al tratar un mensaje del receptor "+id);
        }
    }
    
    public void cerrar() throws Exception{
        receiver.close();
        session.close();
    }
    
}
