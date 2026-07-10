package com.laboratorio.video_130_cdi_beans_producer.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.laboratorio.video_130_cdi_beans_producer.calificadores.HelloServiceQualifier1;
import com.laboratorio.video_130_cdi_beans_producer.calificadores.HelloServiceQualifier2;

@SessionScoped
//@Named("HelloService2Impl")
@HelloServiceQualifier2
public class HelloServiceImpl2 implements Serializable , HelloService {

    private static final Logger logger = LoggerFactory.getLogger(HelloServiceImpl2.class);

    public HelloServiceImpl2() {
    }
    
    @PostConstruct
    public void iniciar(){
        logger.info("Creando el bean HelloService2Impl: "+this.toString());
    }
    
    @PreDestroy
    public void finalizar(){
        logger.info("Destruyendo el bean HelloService2Impl: "+this.toString());
    }
    
    @Override
    public String saludar() {
        logger.info("Entrando a la funcion saludar() de HelloService2Impl");
        return "Reciban un cordial saludo desde HelloService2Impl";
    }
    
}
