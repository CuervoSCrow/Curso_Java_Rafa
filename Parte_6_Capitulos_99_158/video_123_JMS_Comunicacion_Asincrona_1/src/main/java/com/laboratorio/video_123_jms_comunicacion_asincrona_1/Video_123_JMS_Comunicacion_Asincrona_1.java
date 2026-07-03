/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.laboratorio.video_123_jms_comunicacion_asincrona_1;

import java.util.Properties;
import javax.jms.JMSException;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author canzervero
 */
public class Video_123_JMS_Comunicacion_Asincrona_1 {

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
        
        
        
        
        
        
        
        System.out.println("Finalización del proceso");
        try{
            connection.close();
            ic.close();
        }catch(JMSException | NamingException e){
            System.out.println("Error finalizando procesos");
        }
    }    
}
