/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.laboratorio.video_134_x_cliente;

import com.laboratorio.video_134_enterprise_bean_stateles_sessionbean.ejb.BeanForTestRemote;
import com.laboratorio.video_134_enterprise_bean_stateles_sessionbean.ejb.stateful.BeanConEstado;
import com.laboratorio.video_134_enterprise_bean_stateles_sessionbean.ejb.stateful.BeanConEstadoRemote;
import java.util.Properties;
import java.util.Random;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


public class Video_134_x_Cliente {

    public static void main(String[] args) {
        try {

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
            Context ic = new InitialContext(entorno);

            System.out.println("El contexto inicial ha sido creado");

//            String uri = "ejb:/video_132_Enterprise_JavaBean_Introduccion-1.0-SNAPSHOT/BeanForTest!com.laboratorio.video_132_enterprise_javabean_introduccion.ejb.BeanForTestRemote";
            String uri_134="ejb:/video_134_Enterprise_Bean_Stateles_SessionBean-1.0-SNAPSHOT/BeanConEstado!com.laboratorio.video_134_enterprise_bean_stateles_sessionbean.ejb.stateful.BeanConEstadoRemote?stateful";

//            BeanForTestRemote beanRemote = (BeanForTestRemote) ic.lookup(uri_134);
//
//            String resultado = beanRemote.remoteFunction();
//
//            System.out.println("Llamada remota: " + resultado);
            
            BeanConEstadoRemote beanConEstado = (BeanConEstadoRemote) ic.lookup(uri_134);
            
            for(int i=0;i<10;i++){
                beanConEstado.agregar(aleatorio(20));
            }
            System.out.println("Valores: "+beanConEstado.getValores());
            
        } catch (NamingException e) {
            System.out.println("Error en el lookup JNDI");
            e.printStackTrace();
        }
    }
    
    public static Integer aleatorio(int max){
        Random r = new Random(System.currentTimeMillis());
        Integer valor = r.nextInt(max)+1;
        System.out.println("Valor generado: "+valor);
        return valor;
                
    }
 }

