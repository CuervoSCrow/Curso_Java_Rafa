package com.laboratorio.video_131_cdi_beans_interceptores_decoradores.service;

import com.laboratorio.video_131_cdi_beans_interceptores_decoradores.calificadores.HelloServiceQualifier1;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SessionScoped
@HelloServiceQualifier1
public class HelloServiceImpl1 implements Serializable, HelloService {

    private static final Logger logger = LoggerFactory.getLogger(HelloServiceImpl1.class);
    public HelloServiceImpl1() {
    }

    
    @PostConstruct
    public void iniciar(){
        logger.info("Creando el bean HelloServiceImpl1... "+this.toString());
    }
    
    @PreDestroy
    public void finalizar(){
        logger.info("Destruyendo el bean HelloServiceImpl1... "+this.toString());
    }
    
    @Override
    public String saludar() {
        logger.info("Entrando a la funcion saludar() de HelloServiceImpl1");
        return "Hola mundo desde HelloServiceImpl1";
    }
    
}
