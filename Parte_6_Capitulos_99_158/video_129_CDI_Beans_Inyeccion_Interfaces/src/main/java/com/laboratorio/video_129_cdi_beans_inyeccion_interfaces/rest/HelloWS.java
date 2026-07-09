
package com.laboratorio.video_129_cdi_beans_inyeccion_interfaces.rest;

import com.laboratorio.video_129_cdi_beans_inyeccion_interfaces.calificadores.HelloService1Qualifier;
import com.laboratorio.video_129_cdi_beans_inyeccion_interfaces.calificadores.HelloService2Qualifier;
import com.laboratorio.video_129_cdi_beans_inyeccion_interfaces.service.HelloService;
import com.laboratorio.video_129_cdi_beans_inyeccion_interfaces.service.HelloServiceImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Any;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
@Path("/hello")
public class HelloWS {
    private static final Logger logger = LoggerFactory.getLogger(HelloWS.class);
    
    @Inject
//    @Named("HelloService2   Impl")
    @HelloService1Qualifier
    private HelloService helloService;
    
    
    @Inject
    @Any
    private Instance<HelloService> saludos;

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
    
}
