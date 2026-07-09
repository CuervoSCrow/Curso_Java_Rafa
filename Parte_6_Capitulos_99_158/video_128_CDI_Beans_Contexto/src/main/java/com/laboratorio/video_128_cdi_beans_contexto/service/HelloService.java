
package com.laboratorio.video_128_cdi_beans_contexto.service;

import com.laboratorio.video_128_cdi_beans_contexto.rest.HelloWS;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@Dependent
//@ApplicationScoped
//@RequestScoped
@SessionScoped
public class HelloService implements Serializable{
    private static final Logger logger = LoggerFactory.getLogger(HelloService.class);
    
    public HelloService(){ 
    }
    
    @PostConstruct
    public void iniciar(){
        logger.info("Creando el bean: "+this.toString());
    }
    
    @PreDestroy
    public void finalizar(){
        logger.info("Destruyendo el bean"+this.toString());
    }
    
    public String saludar(){
        logger.info("Entrando a la funcion saludar() de HelloService");
        return "Hola Mundo desde HelloService";
    }
}
