package com.laboratorio;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try{
            //        Realizar la peticion a la API
            URL url = new URL("https://api.frankfurter.dev/v1/latest");
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("GET");
            conexion.connect();

            //        Comprobar si la respuesta es correcta
            int respuesta = conexion.getResponseCode();
            //        Si no es correcta, mostramos mensaje de error
            if (respuesta != 200) {
                System.out.println("Ha ocurrido el erro: "+respuesta+
                        " Procesando la petición ");
                return;
            }
            //        Si es correcta, mostramos la respuesta
            StringBuilder respuestaStr = new StringBuilder();
            Scanner scanner = new Scanner(url.openStream());
            while(scanner.hasNext()){
                respuestaStr.append(scanner.nextLine());
            }
            scanner.close();
            System.out.println("Respuesta: ");
            System.out.println(respuestaStr);
        } catch (Exception e) {
            System.out.println("Error Inesperado al prosesar la petición:" +
                    " " + e.getMessage());
        }
    }
}