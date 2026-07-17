
package com.laboratorio.video_136_enterprise_java_bean_singleton.productor;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ejb.Singleton;
import jakarta.jms.Message;
import jakarta.jms.Session;
import jakarta.jms.Topic;
import jakarta.jms.TopicConnection;
import jakarta.jms.TopicConnectionFactory;
import jakarta.jms.TopicPublisher;
import jakarta.jms.TopicSession;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
public class ProductorJMSBean {
    private static final Logger logger = LoggerFactory.getLogger(ProductorJMSBean.class);
    //Creación del contexto que nos permite crear referencias a los objetos registrados en el servidor de aplicaciones
    private InitialContext ic;
    private TopicConnectionFactory connectionFactory;
    private TopicConnection connection;
    private Topic topic; 
    private TopicSession session;
    private TopicPublisher publisher;
    
    @PostConstruct
    public void inicializar(){
         String usuario="canzervero";
        String clave="cuervo";
        
        logger.trace("Iniciando la aplicación....");
        
        //Propiedades para crear el contexto
        Properties env = new Properties();
        env.put(Context.INITIAL_CONTEXT_FACTORY,"org.wildfly.naming.client.WildFlyInitialContextFactory");
        env.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
        env.put(Context.SECURITY_PRINCIPAL, usuario);
        env.put(Context.SECURITY_CREDENTIALS, clave);
        env.put("jboss.naming.client.ejb.context", "true");
        
        
        
        try{
            this.ic = new InitialContext(env);
            
        
            logger.trace("El contexto inicial ha sido creado.");
        
        // Crear el TopicFactory
        this.connectionFactory = (TopicConnectionFactory)ic.lookup("java:/jms/RemoteConnectionFactory");       
        logger.trace("El TopicConnectionFactory ha sido creada");
        
        //Crear la QueueConnection        
        this.connection = connectionFactory.createTopicConnection(usuario,clave);       
        logger.trace("TopicConnection ha sido creado");
        
        //Obtener el acceso al Topic      
        this.topic=(Topic) ic.lookup("java:jboss/exported/jms/topic/tutorialtopic");         
        logger.trace("Topic a sido obtenido");
        
        this.session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
        this.publisher = this.session.createPublisher(topic);
        
        //Iniciar el envio y recepcion del mensaje 
        
       connection.start();
       
        }catch(Exception e){
            logger.error("Error al inicicar JMS: "+e);
            throw new RuntimeException("Fallo la inicialización de ProductorJMSBean",e);
        }  
    }
    public void enviarMensaje(Message message)throws Exception{
        this.publisher.publish(message);
    }

    public TopicSession getSession() {
        return session;
    }
    
    
    @PreDestroy
    public void finalizar(){
         logger.trace("Finalización del proceso");
        try{
            this.connection.stop();
            this.publisher.close();
            
            this.connection.stop();           
            this.connection.close();
            this.ic.close();            
        }catch(Exception e){
            logger.error("Error finalizando procesos");
        }
    
    }
}
