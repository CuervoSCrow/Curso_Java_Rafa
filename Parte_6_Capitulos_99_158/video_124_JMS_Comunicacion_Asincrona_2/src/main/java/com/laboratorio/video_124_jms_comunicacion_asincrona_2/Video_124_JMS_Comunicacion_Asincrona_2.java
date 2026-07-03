package com.laboratorio.video_124_jms_comunicacion_asincrona_2;

import java.util.Properties;
import javax.jms.JMSException;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Video_124_JMS_Comunicacion_Asincrona_2 {

    public static void main(String[] args) {
        String usuario="canzervero";
        String clave="cuervo";
        
        System.out.println("Iniciando la aplicación....");
        
        //Propiedades para crear el contexto
        Properties env = new Properties();
        env.put(Context.INITIAL_CONTEXT_FACTORY,"org.wildfly.naming.client.WildFlyInitialContextFactory");
        env.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
        env.put(Context.SECURITY_PRINCIPAL, usuario);
        env.put(Context.SECURITY_CREDENTIALS, clave);
        env.put("jboss.naming.client.ejb.context", "true");
        
        //Creación del contexto que nos permite crear referencias a los objetos registrados en el servidor de aplicaciones
        InitialContext ic;
        try{
            ic = new InitialContext(env);
            
        }catch(NamingException e){
            System.out.println("Error al crear el contexto inicial.");
            e.printStackTrace();
            return;
        }
        System.out.println("El contexto inicial ha sido creado.");
        
        // Crear la TopicConnectionFactory
        TopicConnectionFactory connectionFactory;
        
        try{
                                
            connectionFactory = (TopicConnectionFactory)ic.lookup("jms/RemoteConnectionFactory");
            
        }catch(NamingException e){
            System.out.println("Error al crear al TopicConnectionFactory");
            e.printStackTrace();    
            return;
        }
        System.out.println("La TopicConnectionFactory ha sido creada");
        
        //Crear el TopicConnection
        TopicConnection connection;
        
        try{
          connection = connectionFactory.createTopicConnection(usuario,clave);
        }catch(JMSException e){
            System.out.println("Error al crear TopicConnection");
            return;
        }
        System.out.println("TopicConnection ha sido creado");
        
        //Obtener el acceso al topic
        Topic topic;
        try{
            topic=(Topic) ic.lookup("jms/topic/tutorialtopic"); 
        }catch(NamingException e){
            System.out.println("Error al obtener Topic");
            return;
        }
        System.out.println("Topic ha sido obtenido");
        
        //Iniciar el envio y recepcion del mensaje 
        
        Productor productor = null;
        Consumidor consumidor = null;
        Consumidor consumidor2 = null;
        Consumidor consumidor3 = null;
        
        try{
            connection.start();
            productor = new Productor(connection, topic);
            consumidor = new Consumidor(1,connection,topic);
            consumidor2 = new Consumidor(2,connection,topic);
            consumidor3 = new Consumidor(3,connection, topic);
            
            System.out.println("Objetos del test creados");
            
            Thread hilo = new Thread(productor);
            hilo.start();
            
            hilo.join();
                  
                 
        }catch(Exception e){
            System.out.println("Se producjo un error durante la ejecucion");
        }        
        
        System.out.println("Finalización del proceso");
        try{
            connection.stop();
            
            if(productor != null){
                productor.cerrar();
            }
            if(consumidor != null){
                consumidor.cerrar();
            }
            if(consumidor2 != null){
                consumidor2.cerrar();
            }
            if(consumidor3 != null){
                consumidor3.cerrar();
            }
            connection.close();
            ic.close();            
        }catch(Exception e){
            System.out.println("Error finalizando procesos");
        }
    }
}
