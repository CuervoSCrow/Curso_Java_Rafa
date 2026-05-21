package com.laboratorio.servidor;

import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    private final int puerto;
    private final ServerSocket serverSocket;
    private final boolean continuar;
    private int nClientes;

    public Servidor(int puerto) throws Exception {
        this.puerto = puerto;
        this.serverSocket = new ServerSocket(puerto);
        this.continuar = true;
        this.nClientes = 0;
    }

    public int getPuerto() {
        return puerto;
    }

    public void startServer() throws Exception {
        Socket clienteSocket;

        while(continuar){
            System.out.println("Esperando a un cliente...");
//            Espera la conexion con un cliente
            clienteSocket = serverSocket.accept();
            nClientes++;
            System.out.println("Se ha conectado un cliente "
            +nClientes);

            AtencionClientes cliente =
                    new AtencionClientes(clienteSocket,nClientes);
            cliente.start();
        }
        serverSocket.close();
    }
}
