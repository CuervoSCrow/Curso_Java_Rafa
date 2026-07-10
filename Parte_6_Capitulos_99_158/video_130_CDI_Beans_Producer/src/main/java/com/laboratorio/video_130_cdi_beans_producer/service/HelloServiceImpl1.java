
package com.laboratorio.video_130_cdi_beans_producer.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.laboratorio.video_130_cdi_beans_producer.calificadores.HelloServiceQualifier1;

@SessionScoped
//@Named("HelloServiceImpl")
@HelloServiceQualifier1
public class HelloServiceImpl1 implements Serializable, HelloService{
    private static final Logger logger = LoggerFactory.getLogger(HelloServiceImpl1.class);

    public HelloServiceImpl1() {
    }
    
    @PostConstruct
    public void iniciar(){
        logger.info("Creando el bean HelloServiceImpl... "+this.toString());
    }
    
    @PreDestroy
    public void finalizar(){
        logger.info("Destruyendo el bean HelloServiceImpl... "+this.toString());
    }
    
    @Override
    public String saludar(){
        logger.info("Entrando a la función saludar de HelloServiceImpl");
        return "Hola Mundo desde HelloServiceImpl";
    }
}
