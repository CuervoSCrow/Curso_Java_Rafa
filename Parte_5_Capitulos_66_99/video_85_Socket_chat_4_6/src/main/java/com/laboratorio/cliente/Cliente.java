package com.laboratorio.cliente;

import com.laboratorio.ClienteChat;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;


public class Cliente extends Thread{
    private final ClienteChat ventana;
    private final String host;
    private final int puerto;
    private final String nombre;
    private final Socket conexion;
    boolean seguir = true;

    public Cliente(ClienteChat ventana,
                   String host,
                   int puerto,
                   String nombre)throws Exception {
        this.ventana=ventana;
        this.puerto = puerto;
        this.host = host;
        this.nombre=nombre;
        this.conexion = new Socket(host,puerto);
    }

//    METODOS GET
    public int getPuerto(){
        return puerto;
    }

    public String getHost(){
        return host;
    }

    public void desconectar(){
        seguir=false;
        try{
            conexion.close();
        }catch(IOException ex){
            System.out.println("Error al cerrar la conexion: "+ex.getMessage());
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
            salidaServidor.writeUTF(
                    nombre+"\n");

            do{
//            Se ejecuta mientras haya  mensajes del cliente
                while((mensaje = entradaServidor.readLine())!=null){
                    procesarMensaje(mensaje.substring(2,mensaje.length()));
                }
            }while(seguir);

            entradaServidor.close();
            salidaServidor.close();
        }catch(Exception ex){
            if(seguir==true){
//                Avisar al la ventana cliente que se produjo un error
                ventana.cerrarVentana(1);
            }
        }
    }

    private void procesarMensaje(String mensaje){
        int pos;
        String comando,nombre;
        pos = mensaje.indexOf('\t');
        if(pos<0){
            System.out.println("Comando no valido");
            return;
        }
        comando=mensaje.substring(0,pos);
        nombre=mensaje.substring(pos+1,mensaje.length());
        if(comando.equalsIgnoreCase("CONECTADO")){
            ventana.agregarEvento(nombre+" esta conectado.");
            ventana.agregarParticipante(nombre);
        }

    }
}
