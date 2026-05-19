package com.laboratorio;

public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando Servidor...");
        try {
            Servidor servidor = new Servidor(2468);
            servidor.startServer();
        }catch(Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
    }
}