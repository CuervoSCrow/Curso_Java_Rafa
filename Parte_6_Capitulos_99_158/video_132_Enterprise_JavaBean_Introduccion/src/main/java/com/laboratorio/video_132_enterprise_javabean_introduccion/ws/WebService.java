
package com.laboratorio.video_132_enterprise_javabean_introduccion.ws;

import com.laboratorio.video_132_enterprise_javabean_introduccion.ejb.BeanForTestLocal;
import com.laboratorio.video_132_enterprise_javabean_introduccion.ejb.BeanForTestRemote;
import jakarta.ejb.EJB;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/test")
public class WebService {
    
    @EJB
    private BeanForTestLocal beanLocal;
    
    @EJB
    private BeanForTestRemote beanRemote;
    
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
    
}
