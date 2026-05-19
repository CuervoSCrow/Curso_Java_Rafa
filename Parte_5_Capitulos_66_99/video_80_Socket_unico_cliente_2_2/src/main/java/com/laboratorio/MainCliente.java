package com.laboratorio;

public class MainCliente {
    public static  void main(String[] args) {
        System.out.println("Iniciando el Cliente...");
        try {
            Cliente cliente = new Cliente("127.0.0.1",2468);
            cliente.startClient();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
