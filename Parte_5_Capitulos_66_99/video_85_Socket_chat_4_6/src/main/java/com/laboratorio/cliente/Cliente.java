package com.laboratorio.cliente;

import com.laboratorio.ClienteChat;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Cliente extends Thread {
    private final int puerto;
    private final String host;
    private  String nombre;
    private final Socket conexion;
    private final ClienteChat ventana;
    boolean seguir = true;

    public Cliente(
            String host,
            int puerto,
            String nombre,
            ClienteChat ventana)throws Exception{
        this.host = host;
        this.puerto = puerto;
        this.nombre = nombre;
        this.ventana = ventana;
        this.conexion = new Socket(host, puerto);
    }

    public int getPuerto() {
        return puerto;
    }

    public String getHost() {
        return host;
    }

    public void desconectar(){
        this.seguir = false;
        try {
            this.conexion.close();
        } catch (Exception e) {
            System.out.println("Error al cerrar la conexión: "+e.getMessage());
        }
    }

    @Override
    public void run(){
        DataOutputStream salidaServidor;
        BufferedReader entradaServidor;
        String mensaje;

        try{
//            Obtiene los flujos de entrada y salida
            salidaServidor = new DataOutputStream(
                    this.conexion.getOutputStream());
            entradaServidor = new BufferedReader(
                    new InputStreamReader(
                            this.conexion.getInputStream()));
//            Se envia mensaje al servidor
            salidaServidor.writeUTF(this.nombre+"\n");

            do{
//                Se ejecuta mientras haya un mensaje en el servidor
                while((mensaje = entradaServidor.readLine()) != null){
                    System.out.println("Mensaje del servidor: "+mensaje);
                    procesarMensaje(mensaje.substring(2,mensaje.length()));
                }
            }while(seguir);

            entradaServidor.close();
            salidaServidor.close();
            conexion.close();

        }catch(Exception e){
            if(seguir == true){
//                Avisar a la ventana cliente que se produjo un error
                ventana.cerrarVentana(1);
            }

        }
    }

    private void procesarMensaje(String mensaje){
        int pos;
        String comando;

        pos=mensaje.indexOf('\t');
        if(pos<0){
            return;
        }
        comando=mensaje.substring(0,pos);
        nombre = mensaje.substring(pos+1,mensaje.length());
        if(comando.equalsIgnoreCase("CONECTADO")){
            ventana.agregarEvento(nombre+" Se ha establecido la conexión");
            ventana.agregarParticipante(nombre);
        }
    }
}
