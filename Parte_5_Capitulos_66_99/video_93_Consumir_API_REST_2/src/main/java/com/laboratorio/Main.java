package com.laboratorio;

import com.laboratorio.entity.Change;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;


import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try{

//        Creamos la conexion al API
//            Client client = ClientBuilder.newClient();
//Codigo deepseek
            Client client= ClientBuilder.newClient();

//        Construir la URI del END POINT
            String URL = "https://api.frankfurter.dev/v1/";
            String endpoint = URL + "latest";
            WebTarget target = client.target(endpoint);

//        Hacer la llamada
            String jsonStr = target.request(MediaType.APPLICATION_JSON)
                    .get(String.class);
            System.out.println("Respuesta: "+jsonStr);

//            Creamos la entidad apartir de la respuesta
            Change change = new Change(jsonStr);
            System.out.println("Entidad: "+change.toString());

        }catch(Exception ex){
            System.out.println("Se ha presentando un error al hacer la llamada: "+
                    ex.getMessage());
        }

    }
}