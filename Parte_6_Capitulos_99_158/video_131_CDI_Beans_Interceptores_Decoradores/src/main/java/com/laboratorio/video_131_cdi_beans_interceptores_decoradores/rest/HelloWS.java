
package com.laboratorio.video_131_cdi_beans_interceptores_decoradores.rest;

import com.laboratorio.video_131_cdi_beans_interceptores_decoradores.calificadores.HelloServiceQualifier1;
import com.laboratorio.video_131_cdi_beans_interceptores_decoradores.interceptor.InterceptorDeSaludo;
import com.laboratorio.video_131_cdi_beans_interceptores_decoradores.service.Despedida;
import com.laboratorio.video_131_cdi_beans_interceptores_decoradores.service.HelloService;
import com.laboratorio.video_131_cdi_beans_interceptores_decoradores.utils.SaludoPersonalizado;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Any;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;
import jakarta.interceptor.Interceptors;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
@Path("/hello")
//@Interceptors({InterceptorDeSaludo.class})
public class HelloWS {    
    private static final Logger logger = LoggerFactory.getLogger(HelloWS.class);
    
    @Inject
    @HelloServiceQualifier1
    private HelloService helloService;
    
    @Inject
    @Any
    private Instance<HelloService> saludos;
    
    @Inject
    private SaludoPersonalizado saludoPersonalizado;

    public HelloWS() {
    }
    
    @Inject
    private Despedida despedida;
    
    @GET
    @Interceptors({InterceptorDeSaludo.class})
    public String getHello(){
        logger.info("Intsancia WS: "+this.toString());
        logger.info("Instancia Servicio: "+helloService.toString());
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
    
    @GET
    @Path("/despedida")
    public String cerrar(){
        return despedida.despedirse();
    }
    
}
