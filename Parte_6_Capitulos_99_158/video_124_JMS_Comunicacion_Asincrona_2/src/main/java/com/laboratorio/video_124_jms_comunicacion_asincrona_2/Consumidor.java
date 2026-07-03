
package com.laboratorio.video_124_jms_comunicacion_asincrona_2;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;

public class Consumidor implements MessageListener {
    private final int id;
    private final TopicSession session;
    private final TopicSubscriber subscriber;

    public Consumidor(int id, TopicConnection connection, Topic topic)throws Exception {
        this.id = id;
        this.session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
        this.subscriber = session.createSubscriber(topic);
        this.subscriber.setMessageListener(this);
    }
    
    
    @Override
    public void onMessage(Message msg) {
        try{
            TextMessage message = (TextMessage) msg;
            System.out.printf("Subscriptor %d recibe el mensaje %s\n",id,message.getText());
            
        }catch(Exception e){
            System.out.println("Error al tratar un mensaje del consumidor "+id);
        }
    }
    
    public void cerrar()throws Exception{
        subscriber.close();
        session.close();
    }
    
}
