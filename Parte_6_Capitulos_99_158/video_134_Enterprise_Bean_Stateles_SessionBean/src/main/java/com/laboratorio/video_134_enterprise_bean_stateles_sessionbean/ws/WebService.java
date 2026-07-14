
package com.laboratorio.video_134_enterprise_bean_stateles_sessionbean.ws;

import com.laboratorio.video_134_enterprise_bean_stateles_sessionbean.ejb.BeanForTestLocal;
import com.laboratorio.video_134_enterprise_bean_stateles_sessionbean.ejb.BeanForTestRemote;
import com.laboratorio.video_134_enterprise_bean_stateles_sessionbean.ejb.stateless.BeanSinEstado;
import jakarta.ejb.EJB;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/test")
public class WebService {
    @EJB
    private BeanForTestLocal beanLocal;
    
    @EJB
    private BeanForTestRemote beanRemote;
    
     @EJB
    private BeanSinEstado beanSinEstado;
    
    @GET
    @Path("/local")
    public String ejecutarLocal(){
        return beanLocal.localFunction();
    }  
    
    @GET
    @Path("/remote")
    public String ejecutarRemote(){
        return beanRemote.remoteFunction();
    }
    
    @GET
    @Path("/stateless")
    public String incrementar()throws Exception{
        return beanSinEstado.incrementar();
    }
    
}
