
package com.laboratorio.video_132_z;

import com.laboratorio.video_132_enterprise_javabean_introduccion.ejb.BeanForTestRemote;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;

public class Video_132_z {

    public static void main(String[] args) throws Exception{
        System.out.println("Iniciando la aplicación cliente");
        
        String usuario = "canzervero";
        String clave = "cuervo";
        
//        Propiedades para crear el contexto
        Properties entorno = new Properties();
        entorno.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        entorno.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
        entorno.put(Context.SECURITY_PRINCIPAL, usuario);
        entorno.put(Context.SECURITY_CREDENTIALS, clave);
        
//        Crear el contexto
        InitialContext ic = new InitialContext(entorno);
        
        System.out.println("El contexto inicial ha sido creado");
        
        String uri = "ejb:/video_132_Enterprise_JavaBean_Introduccion-1.0-SNAPSHOT/BeanForTest!com.laboratorio.video_132_enterprise_javabean_introduccion.ejb.BeanForTestRemote";
        
        BeanForTestRemote beanRemote = (BeanForTestRemote) ic.lookup(uri);
        System.out.println("Llamada remota: "+beanRemote.remoteFunction());
    }
}
