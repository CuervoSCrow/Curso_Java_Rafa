
package com.laboratorio.video_131_cdi_beans_interceptores_decoradores.utils;

import jakarta.enterprise.inject.Produces;
import java.util.Date;


public class ProductorDeSaludos {
    @Produces
    public SaludoPersonalizado crearSaludo(){
        String mensaje = obtenerMensajePersonalizado();
        return new SaludoPersonalizado(mensaje);
    }
    
    private String obtenerMensajePersonalizado(){
        return "Hola Laboratorio de cuervo. Hoy es "+new Date();
    }
}
