
package com.laboratorio.video_130_cdi_beans_producer.utiles;

import jakarta.enterprise.inject.Produces;

import java.util.Date;

public class ProductorDeSaludos {
    @Produces    
    public SaludoPersonalizado crearSaludo(){
        String mensaje = obtenerMensajePersonalizado();
        return new SaludoPersonalizado(mensaje);
    }
    
    private String obtenerMensajePersonalizado(){
        return "Hola laboratorio de rafa. Hoy es : "+new Date();
    }
}
