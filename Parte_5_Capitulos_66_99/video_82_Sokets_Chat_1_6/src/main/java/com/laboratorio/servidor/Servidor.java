package com.laboratorio.servidor;

import com.laboratorio.ServidorChat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor extends Thread{
    private final ServidorChat ventana;
    private final int puerto;
    private final ServerSocket serverSocket;
    private boolean continuar;
    private int nClientes;


    public Servidor(ServidorChat ventana, int puerto) throws Exception{
        this.ventana= ventana;
        this.puerto = puerto;
        this.serverSocket = new ServerSocket(puerto);
        this.continuar = true;
        this.nClientes = 0;
    }

    public int getPuerto() {
        return puerto;
    }

    @Override
    public void run() {
       try{
           Socket clienteSocket;
           ventana.agregarEvento("Iniciando el servidor...");

           while(continuar){
//            System.out.println("Esperando a un cliente...");
               ventana.agregarEvento("Esperando a un cliente...");
//            Espera la conexion con un cliente
               clienteSocket = serverSocket.accept();
               nClientes++;
               ventana.agregarEvento("Se ha conectado un cliente"+nClientes);
//            System.out.println("Se ha conectado un cliente "
//               +nClientes);

               AtencionClientes cliente =
                       new AtencionClientes(clienteSocket,nClientes);
               cliente.start();
           }

       }catch(IOException e){
           if(continuar==true){
               System.out.println("Error Inesperado: " + e.getMessage());
               ventana.cerrarAplicacion(1);
               return;
           }
       }

    }
    public void cerrar(){
        System.out.println("Cierre iniciado");
        continuar = false;
        try{
            serverSocket.close();
        }catch(IOException e){
            System.out.println("Error al cerrar el servidor: " + e.getMessage());
            return;
        }
        System.out.println("Cierre finalizado");
    }


}
