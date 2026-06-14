package com.laboratorio.video_108_desarrollo_web_9_servlets_2_redirect_forward.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

/**
 *
 * @author 
 */
@Path("jakartaee11")
public class JakartaEE11Resource {
    
    @GET
    public Response ping(){
        return Response
                .ok("ping Jakarta EE")
                .build();
    }
}
