package com.laboratorio.video_125_jms_comunicacion_asincrona_3;

import java.util.Properties;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Video_125_JMS_Comunicacion_Asincrona_3 {

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
        
        // Crear la QueueConnectionFactory
        QueueConnectionFactory connectionFactory;
        
        try{
                                
            connectionFactory = (QueueConnectionFactory)ic.lookup("jms/RemoteConnectionFactory");
            
        }catch(NamingException e){
            System.out.println("Error al crear al QueueConnectionFactory");
            e.printStackTrace();    
            return;
        }
        System.out.println("La QueueConnectionFactory ha sido creada");
        
        //Crear la QueueConnection
        QueueConnection connection;
        
        try{
          connection = connectionFactory.createQueueConnection(usuario,clave);
        }catch(JMSException e){
            System.out.println("Error al crear QueueConnection");
            return;
        }
        System.out.println("QueueConnection ha sido creado");
        
        //Obtener el acceso al Queue
        Queue queue;
        try{
            queue=(Queue) ic.lookup("jms/queue/tutorialqueue"); 
        }catch(NamingException e){
            System.out.println("Error al obtener queue");
            return;
        }
        System.out.println("Queue ha sido obtenido");
        
        //Iniciar el envio y recepcion del mensaje 
        
        Sender sender = null;
        Receiver receiver1 = null;
        Receiver receiver2 = null;
        Receiver receiver3 = null;
        
        try{
            connection.start();
            sender = new Sender(connection, queue);
            receiver1 = new Receiver(1,connection,queue);
            receiver2 = new Receiver(2,connection,queue);
            receiver3 = new Receiver(3,connection, queue);
            
            System.out.println("Objetos del test creados");
            
            Thread hilo = new Thread(sender);
            hilo.start();
            
            hilo.join();
                  
                 
        }catch(Exception e){
            System.out.println("Se producjo un error durante la ejecucion");
        }        
        
        System.out.println("Finalización del proceso");
        try{
            connection.stop();
            
            if(sender != null){
                sender.cerrar();
            }
            if(receiver1 != null){
                receiver1.cerrar();
            }
            if(receiver2 != null){
                receiver2.cerrar();
            }
            if(receiver3 != null){
                receiver3.cerrar();   
            }
            connection.close();
            ic.close();            
        }catch(Exception e){
            System.out.println("Error finalizando procesos");
        }
    }
}
