package com.laboratorio;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    private final int puerto;
    private ServerSocket serverSocket;

    public Servidor(int puerto)throws Exception {
        this.puerto = puerto;
        serverSocket = new ServerSocket(puerto);
    }

    public int getPuerto() {
        return puerto;
    }

    public void startServer() throws Exception {
        Socket clienteSocket = new Socket();
        DataOutputStream salidaCliente;
        BufferedReader entradaCliente;
        String mensaje;

        System.out.println("Esperando cliente...");

//        Esperando la conexion de un cliente
        clienteSocket = serverSocket.accept();

        System.out.println("Cliente conectado...");

//        Se obtienen los flujos de entraday salida del cliente
        salidaCliente = new DataOutputStream(
                clienteSocket.getOutputStream());
        entradaCliente = new BufferedReader(
                new InputStreamReader(
                        clienteSocket.getInputStream()));
//        Se recibe el mensaje del cliente
        mensaje = entradaCliente.readLine();
        System.out.println("Mensaje Cliente: " + mensaje);

//        Se envia mensaje al cliente
        salidaCliente.writeUTF(
                "Conexion acceptada esperando instrucciones\n");

//        Se ejecuta mientras haya instrucciones
        while((mensaje= entradaCliente.readLine())!=null) {
            System.out.println("Mensaje cliente: "+mensaje);
            }

        System.out.println("Fin de la conexion");

//            Se cierra la conexion
        clienteSocket.close();
        entradaCliente.close();
        salidaCliente.close();
        serverSocket.close();
    }
}
