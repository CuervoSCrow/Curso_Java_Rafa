
package com.laboratorio.video_127_cdi_beans_inyeccion_dependencias.service;

import com.laboratorio.video_127_cdi_beans_inyeccion_dependencias.rest.HelloWebService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class HelloService {
    private static final Logger logger = LoggerFactory.getLogger(HelloWebService.class);

    public HelloService() {
    }
    
    public String saludar(){
        logger.info("Entrando a la función saludar() de HelloService");
        return "Hello World desde HelloService";
    }
    
}
