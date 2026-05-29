package com.laboratorio;

import com.laboratorio.cliente.Cliente;

public class MainCliente {

    public MainCliente(){
        System.out.println("Iniciando cliente");
        try{
            Cliente cliente = new Cliente(
                    "127.0.0.1",
                    2486);
            cliente.startCliente();
        } catch (Exception e) {
            System.out.println("Error al iniciar el cliente"+e.getMessage());
        }
    }

    public static void main(String[] args) {
        MainCliente mainCliente = new MainCliente();
    }
}
