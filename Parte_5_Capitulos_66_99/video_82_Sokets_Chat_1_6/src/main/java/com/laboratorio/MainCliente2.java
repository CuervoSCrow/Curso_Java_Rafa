package com.laboratorio;

import com.laboratorio.cliente.Cliente;

public class MainCliente2 {
    public static void main(String[] args) {
        System.out.println("Iniciando el cliente");
        try{
            Cliente cliente = new Cliente(
                    "127.0.0.1",
                    2468);
            cliente.startCliente();
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }

    }
}
