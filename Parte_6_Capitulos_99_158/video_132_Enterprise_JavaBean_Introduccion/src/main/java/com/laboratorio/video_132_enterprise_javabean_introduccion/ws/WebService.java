
package com.laboratorio.video_132_enterprise_javabean_introduccion.ws;

import com.laboratorio.video_132_enterprise_javabean_introduccion.ejbean.BeanForTestLocal;
import com.laboratorio.video_132_enterprise_javabean_introduccion.ejbean.BeanForTestRemote;
import jakarta.ejb.EJB;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/test")
public class WebService {

    @EJB
    private BeanForTestLocal beanLocal;
    
    @EJB
    private BeanForTestRemote beanRemoto;
    
    @GET
    @Path("/local")
    public String ejecutarLocal(){
        return beanLocal.localFunction();
    }
    
    @GET
    @Path("/remote")
    public String ejecutarRemote(){
        return beanRemoto.remoteFunction();
    }
}
