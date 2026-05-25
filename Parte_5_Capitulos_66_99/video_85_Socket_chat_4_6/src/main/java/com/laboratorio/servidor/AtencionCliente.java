package com.laboratorio.servidor;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class AtencionCliente extends Thread{
    private final Servidor padre;
    private final Socket conexion;
    private final int nCliente;
    private DataOutputStream salidaCliente;

    public AtencionCliente(
            Servidor padre,
            Socket conexion,
            int nCliente){
        this.padre = padre;
        this.conexion = conexion;
        this.nCliente = nCliente;
        this.salidaCliente = null;
    }

    public void enviarMensaje(String mensaje){
        if(this.salidaCliente!=null){
            try{
                salidaCliente.writeUTF(mensaje);
            }catch(Exception ex){
                System.out.println("Error enviando un mensaje: "+ex.getMessage());
            }
        }
    }
    @Override
    public void run(){

        BufferedReader entradaCliente;
        Participante participante;

        String mensaje,nombre;
        try{
//            Se obtiene los flujos de entraa y salida
            salidaCliente= new DataOutputStream(
                    conexion.getOutputStream());
            entradaCliente = new BufferedReader(
                    new InputStreamReader(
                            conexion.getInputStream()));
//            Se recibe el primer mensaje del cliente
            mensaje = entradaCliente.readLine();
            nombre = mensaje.substring(2,mensaje.length());
            participante= new Participante(
                    nCliente,
                    nombre,
                    this);
            padre.agregarParticipante(participante);

//            Enviamos un mensaje al cliente
            salidaCliente.writeUTF(
                    "Conexion aceptada esperando instrucciones...");

//            Se ejecuta mientras haya mensajes del cliente
            while((mensaje = entradaCliente.readLine())!=null ){
                System.out.println("Mensaje Cliente "+
                        nCliente+": "+mensaje);
            }
            padre.quitarParticipante(participante);

//            Fin de la conexion del cliente
            entradaCliente.close();
            salidaCliente.close();
            conexion.close();

        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
