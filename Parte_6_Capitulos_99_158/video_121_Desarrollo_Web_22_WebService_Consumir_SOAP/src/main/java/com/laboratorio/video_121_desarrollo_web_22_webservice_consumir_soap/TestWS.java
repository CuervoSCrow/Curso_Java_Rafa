
package com.laboratorio.video_121_desarrollo_web_22_webservice_consumir_soap;

import com.laboratorio.cliente.soap.generado.Persona;
import com.laboratorio.cliente.soap.generado.PersonaWebService;
import com.laboratorio.cliente.soap.generado.PersonaWebService_Service;
import com.laboratorio.cliente.soap.generado.Resultado;
import java.util.List;


public class TestWS {
    public static void main(String args[]){
        PersonaWebService_Service servicio = new PersonaWebService_Service();
        PersonaWebService cliente = servicio.getPersonaWebServicePort();
        
        Resultado res = cliente.crearPersona("Sofia", "Castaño", "1979-07-25", 9);
        
        System.out.println("El resultado: "+res.getCodigo()+" - "+res.getMensaje());
        
        List<Persona> personas = cliente.listarPersonas();
        for(Persona p: personas){
            System.out.println("");
            System.out.println("Codigo: "+p.getCodigo());
            System.out.println("Nombres: "+p.getNombre());
            System.out.println("Apellidos: "+p.getApellidos());
            System.out.println("Fecha nacimiento: "+p.getFechaNac());
            System.out.println("Experiencia: "+p.getExperiencia()+" años.");
                
        }
    }
    
}
