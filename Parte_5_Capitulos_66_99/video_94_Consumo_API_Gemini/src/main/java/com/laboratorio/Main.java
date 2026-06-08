package com.laboratorio;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;

public class Main {
    public static void main(String[] args) {
        llamarGemini();
    }

    public static void llamarGemini() {
        String apiKey="APIKey";
        Client client = Client.builder().apiKey(apiKey).build();

//        Enviar un prompt al modelo
        GenerateContentResponse response =
                client
                .models
                .generateContent("gemini-2.0-flash",
                        "¿Cuál es la capital de Francia?",
                        null);
//        Imprimir la respuesta
        System.out.println(response.text());
    }
}