
package com.laboratorio.video_138_enterprise_javabean_uniendo_componentes_jse_jee_1.productor;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.annotation.Resource;
import jakarta.ejb.Singleton;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.Session;
import jakarta.jms.Topic;
import jakarta.jms.TopicConnection;
import jakarta.jms.TopicConnectionFactory;
import jakarta.jms.TopicPublisher;
import jakarta.jms.TopicSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
public class ProductorJMSBean {
    private static final Logger logger = LoggerFactory.getLogger(ProductorJMSBean.class);
    
    @Resource(lookup =  "java:jboss/exported/jms/topic/tutorialtopic")
    private Topic topic;
    
    @Resource(lookup = "java:jboss/exported/jms/RemoteConnectionFactory")
    private TopicConnectionFactory connectionFactory;
    
    private TopicConnection connection;
    private TopicSession session;
    private TopicPublisher publisher;
    
    @PostConstruct
    public void inicializar(){
        try{
            // Usa las credenciales si son necesarias, o null si no requiere autenticación
            connection = connectionFactory.createTopicConnection("canzervero","cuervo");
            session = connection.createTopicSession(false,Session.AUTO_ACKNOWLEDGE);
            publisher = session.createPublisher(topic);
            connection.start();
            logger.info("Productor JMSBean inicializando correctamente....");
        }catch(JMSException e){
            logger.error("Error al inicializar JMS: "+e);
            throw new RuntimeException("Fallo la inicicalización de Productor JMSBean ",e);
        }
    }
    
    public void enviarMensaje(Message message) throws JMSException{
        publisher.publish(message);
    }

    public TopicSession getSession() {
        return session;
    }
    
    @PreDestroy
    public void finalizar(){
        try{
            if(publisher!=null)publisher.close();
            if(session!=null)session.close();
            if(connection!=null){
                connection.stop();
                connection.close();
            }
            logger.info("Recursos JMS liberados ============================");
        }catch(JMSException e){
            logger.info("Error al cerrar recursos JMS",e);
        }
    }
    
}
