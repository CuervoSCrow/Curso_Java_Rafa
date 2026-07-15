
package com.laboratorio.video_134_enterprise_bean_stateles_sessionbean.ws;

import com.laboratorio.video_134_enterprise_bean_stateles_sessionbean.ejb.BeanForTestLocal;
import com.laboratorio.video_134_enterprise_bean_stateles_sessionbean.ejb.BeanForTestRemote;
import com.laboratorio.video_134_enterprise_bean_stateles_sessionbean.ejb.stateful.BeanConEstado;
import com.laboratorio.video_134_enterprise_bean_stateles_sessionbean.ejb.stateless.BeanSinEstado;
import jakarta.ejb.EJB;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/test")
public class WebService {
    @EJB
    private BeanForTestLocal beanLocal;
    
    @EJB
    private BeanForTestRemote beanRemote;
    
     @EJB
    private BeanSinEstado beanSinEstado;
     
     @EJB
     private BeanConEstado beanConEstado;
    
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
    
    @GET
    @Path("{valor}")
    public String agregar(@PathParam("valor") String valor){
        Integer valorInt =Integer.valueOf(valor);
        return beanConEstado.agregar(valorInt);
    }
    
    @GET
    public String getValores(){
        StringBuilder sb = new StringBuilder();
        
        for(Integer valor : beanConEstado.getValores()){
            if(sb.toString().length()>0){
                sb.append(" - ");
            }
            sb.append(String.valueOf(valor));
            
            
        }
        return sb.toString();
    }
    
}
