package com.laboratorio.api;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;

public class FrankFurteAPI {
    private final String URL;

    public FrankFurteAPI(String url) {
        this.URL = url;
    }

    public String ejecutar(FrankFurteAPIEnum operacion){
        String URI;
        switch(operacion){
            case LATEST:
                URI = this.URL+"/latest";
                break;
            case CURRENCIES:
                URI = this.URL+"/currencies";
                break;
            default:
                throw new IllegalArgumentException("Operacion no soportada");
        }
        try{
            Client client = ClientBuilder.newClient();
            WebTarget target = client.target(URI);

//            Hacer la llamada a la API
            String jsonStr = target.request(MediaType.APPLICATION_JSON).get(String.class);

            return jsonStr;
        }catch(Exception e){
            System.out.println("Error al procesar la petición: "+e.getMessage());
            return null;
        }
    }
}
