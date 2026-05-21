package com.laboratorio;

import com.laboratorio.servidor.Servidor;

public class MainServidor {
    public static void main(String[] args) {
        System.out.println("Iniciando el servidor");
        try{
            Servidor servidor = new Servidor(2468);
            servidor.startServer();
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}