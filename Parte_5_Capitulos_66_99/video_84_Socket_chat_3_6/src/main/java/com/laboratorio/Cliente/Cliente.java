package com.laboratorio.Cliente;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;


public class Cliente extends Thread{
    private final int puerto;
    private final String host;
    private final String nombre;
    private final Socket conexion;
    boolean seguir = true;

    public Cliente(String host, int puerto,String nombre)throws Exception {
        this.host = host;
        this.puerto = puerto;
        this.nombre = nombre;
        this.conexion = new Socket(host, puerto);
    }

    public int getPuerto() {
        return puerto;
    }

    public String getHost() {
        return host;
    }

    public void desconectar() {
        seguir = false;
        try{
            conexion.close();
        }catch(IOException ex){
            System.out.println("Error al cerrar la conexion: " + ex.getMessage());
        }
    }

    @Override
    public void run() {
        DataOutputStream salidaServidor;
        BufferedReader entradaServidor;
        String mensaje;

        try{
//        Obtiene los flujos de entrada y salida
            salidaServidor = new DataOutputStream(
                    conexion.getOutputStream());
            entradaServidor = new BufferedReader(
                    new InputStreamReader(
                            conexion.getInputStream()));

//        Se envia mensaje al servidor
            salidaServidor.writeUTF(nombre+"\n");

            do{
//            Se ejecuta mientras haya mensajes del servidor
                while((mensaje = entradaServidor.readLine())!=null){
                    System.out.println("Mensaje del servidor: " + mensaje);
                }
            }while(seguir);

            entradaServidor.close();
            salidaServidor.close();
            conexion.close();
        }catch(Exception ex){
            if(seguir==true){
//                Avisar a la ventana cliente que se produjo un error
            }
            return;
        }

    }
}
