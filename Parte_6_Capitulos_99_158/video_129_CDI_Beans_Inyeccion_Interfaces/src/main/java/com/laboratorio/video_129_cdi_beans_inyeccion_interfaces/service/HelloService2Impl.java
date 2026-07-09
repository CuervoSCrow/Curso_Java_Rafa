
package com.laboratorio.video_129_cdi_beans_inyeccion_interfaces.service;

import com.laboratorio.video_129_cdi_beans_inyeccion_interfaces.calificadores.HelloService2Qualifier;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SessionScoped
//@Named("HelloService2Impl")
@HelloService2Qualifier
public class HelloService2Impl implements Serializable , HelloService {

    private static final Logger logger = LoggerFactory.getLogger(HelloService2Impl.class);

    public HelloService2Impl() {
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
