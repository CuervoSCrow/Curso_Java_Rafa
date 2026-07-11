
package com.laboratorio.video_131_cdi_beans_interceptores_decoradores.decorador;

import com.laboratorio.video_131_cdi_beans_interceptores_decoradores.service.Despedida;
import jakarta.decorator.Decorator;
import jakarta.decorator.Delegate;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Decorator
public class DecoradorDeDespedida implements Despedida{
    
    private static final Logger logger = LoggerFactory.getLogger(DecoradorDeDespedida.class);

    @Inject
    @Delegate
    private Despedida servicio;
    
    @Override
    public String despedirse() {
        String despedidaOriginal = servicio.despedirse();
        logger.info("**** DECORADOR **** Despedida Original: "+despedidaOriginal);        
        return "<p><b>"+despedidaOriginal+"!</b></p>Nueva linea agregada por el decorador</p>";
    }
    
}
