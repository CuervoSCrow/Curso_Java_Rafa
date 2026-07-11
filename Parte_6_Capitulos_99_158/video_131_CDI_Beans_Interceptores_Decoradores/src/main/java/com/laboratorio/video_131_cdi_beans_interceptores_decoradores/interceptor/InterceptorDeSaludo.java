
package com.laboratorio.video_131_cdi_beans_interceptores_decoradores.interceptor;

import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.InvocationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InterceptorDeSaludo {
    
    private static final Logger logger = LoggerFactory.getLogger("InterceptorDeSaludo.class");
    
    @AroundInvoke
    private Object inspeccionar(InvocationContext context)throws Exception{
        logger.info("***INTERCEPTOR*** Llamada desde el metodo: "+context.getMethod().toString());

//        Logica del interceptor

//        return context.proceed();
        return null;

    }
    
}
