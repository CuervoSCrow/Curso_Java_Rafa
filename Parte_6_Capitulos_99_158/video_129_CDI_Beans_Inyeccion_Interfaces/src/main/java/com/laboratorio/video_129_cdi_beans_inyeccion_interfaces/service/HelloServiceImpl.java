
package com.laboratorio.video_129_cdi_beans_inyeccion_interfaces.service;

import com.laboratorio.video_129_cdi_beans_inyeccion_interfaces.calificadores.HelloService1Qualifier;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.inject.Qualifier;
import java.io.Serializable;
import jdk.jfr.Name;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SessionScoped
//@Named("HelloServiceImpl")
@HelloService1Qualifier
public class HelloServiceImpl implements Serializable, HelloService{
    private static final Logger logger = LoggerFactory.getLogger(HelloServiceImpl.class);

    public HelloServiceImpl() {
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
