
package com.laboratorio.video_127_cdi_beans_inyeccion_dependencias.rest;

import com.laboratorio.video_127_cdi_beans_inyeccion_dependencias.service.HelloService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/hello")
public class HelloWebService {   
    
    private static final Logger logger = LoggerFactory.getLogger(HelloWebService.class);
//  Formas de Inyección
    
//    Forma 1
//    @Inject
//    private HelloService helloService;

    
//    Forma 2
//    private HelloService helloService;
//    @Inject
//    public void setHelloService(HelloService helloService) {
//        logger.info("Inyectando la dependencia de HelloService");
//        this.helloService = helloService;
//    }
    
//    Forma 3
    private HelloService helloService;
    
    public HelloWebService(){}

    @Inject
    public HelloWebService(HelloService helloService) {
        logger.info("Intyectando la dependencia HelloService");
        this.helloService = helloService;
    }
    
    
    
    
    @GET    
    public String getHello(){
        logger.info("Entrando al WebService Hello");
        return helloService.saludar();
    }
    
}
