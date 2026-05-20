package com.laboratorio;

import java.net.ServerSocket;

public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando servidor");
        try{
            Servidor servidor = new Servidor(2468);
            servidor.startServer();

        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}