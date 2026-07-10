
package com.laboratorio.video_130_cdi_beans_producer.rest;

import com.laboratorio.video_130_cdi_beans_producer.service.HelloService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Any;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.laboratorio.video_130_cdi_beans_producer.calificadores.HelloServiceQualifier1;
import com.laboratorio.video_130_cdi_beans_producer.utiles.SaludoPersonalizado;

@ApplicationScoped
@Path("/hello")
public class HelloWS {
    private static final Logger logger = LoggerFactory.getLogger(HelloWS.class);
    
    @Inject
//    @Named("HelloService2   Impl")
    @HelloServiceQualifier1
    private HelloService helloService;
    
    
    @Inject
    @Any
    private Instance<HelloService> saludos;
    
    @Inject
    private SaludoPersonalizado saludoPersonalizado;

    public HelloWS() {
    }
    
//    @Inject
//    public HelloWS(HelloServiceImpl helloService){
//        logger.info("Inyectando la dependencia HelloService");
//        this.helloService = helloService;
//    }
    
    @GET
    public String getHello(){
        logger.info("Intsancia WS: "+this.toString());
        logger.info("Instancia servicio: "+helloService.toString());
        return helloService.saludar();
    }
    
    @GET
    @Path("/saludos")
    public String getSaludos(){
        String str = "";
        for(HelloService helloService : saludos){
            str+="<p>"+helloService.saludar()+"</p>";
        }
        return str;
    }
    
    @GET
    @Path("/produces")
    public String getSaludosPersonalizado(){
        return saludoPersonalizado.getMessage();
    }
}
