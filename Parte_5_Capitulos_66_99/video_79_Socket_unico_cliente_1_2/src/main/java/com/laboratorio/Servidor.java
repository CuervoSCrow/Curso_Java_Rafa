package com.laboratorio;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    private final int puerto;
    private ServerSocket serverSocket;


    public Servidor(int puerto) throws Exception {
        this.puerto = puerto;
        serverSocket=new ServerSocket(puerto);
    }

    public int getPuerto() {
        return puerto;
    }

    public void startServer() throws Exception {
        Socket clienteSocket = new Socket();
        DataOutputStream salidaCliente;
        BufferedReader entradaCliente;
        String mensaje;

        System.out.println("Esperando un cliente");

//        Esperar una conexion con un cliente
        clienteSocket = serverSocket.accept();

        System.out.println("Cliente conectado...");

//        Se obtiene los flujos de entrada y salida del cliente
        salidaCliente = new DataOutputStream(
                clienteSocket.getOutputStream());
        entradaCliente = new BufferedReader(
                new InputStreamReader(
                        clienteSocket.getInputStream()));
//        Se recibe el primer mensaje del cliente
        mensaje = entradaCliente.readLine();
        System.out.println("Mensaje cliente: "+mensaje);

//        Se envia un mensaje al cliente
        salidaCliente.writeUTF(
                "Conexion acceptada esperando instrucciones\n");

//            Se ejecuta miestras haya mensajes del cliente
        while ((mensaje = entradaCliente.readLine()) != null) {
            System.out.println("Mensaje cliente: " + mensaje);
        }
//        Se cierra la conexion
        entradaCliente.close();
        salidaCliente.close();
        clienteSocket.close();
        serverSocket.close();
    }
}
