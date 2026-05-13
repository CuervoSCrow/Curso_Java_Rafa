package com.laboratorio;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String,String> params = new HashMap<>();
        params.put("usuario","Labarotario de cuervo");
        params.put("idioma","Español");
        params.put("modo","modo oscuro");

        procesarParamatros(params);

    }
    public static void procesarParamatros(Map<String,String> params){

        if(params.containsKey("usuario")){
            String usuario = params.get("usuario");
            System.out.println("Usuario: "+usuario);
        }

        if(params.containsKey("idioma")){
            String idiomas = params.get("idioma");
            System.out.println("Idioma: "+idiomas);
        }
        if(params.containsKey("modo")){
            String modo = params.get("modo");
            System.out.println("Modo: "+modo);
        }
        if(params.containsKey("password")){
            String password = params.get("password");
            System.out.println("Password: "+password);
        }
    }
}