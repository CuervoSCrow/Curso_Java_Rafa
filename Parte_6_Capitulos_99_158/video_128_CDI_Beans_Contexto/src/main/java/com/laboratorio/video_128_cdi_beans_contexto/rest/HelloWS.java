
package com.laboratorio.video_128_cdi_beans_contexto.rest;

import com.laboratorio.video_128_cdi_beans_contexto.service.HelloService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@RequestScoped
//Dependent
@ApplicationScoped
@Path("/hello")
public class HelloWS {
    private static final Logger logger = LoggerFactory.getLogger(HelloWS.class);
    
    private HelloService helloService;
    
    public HelloWS(){}
    
    @Inject
    public HelloWS(HelloService helloService){
        logger.info("Inyectando la dependencia HelloService");
        this.helloService = helloService;
    }
    
    @GET
    public String getHello(){
        logger.info("Instancia WS: "+this.toString());
        logger.info("Instancia del servicio: "+helloService.toString());
        return helloService.saludar();
    }
}
