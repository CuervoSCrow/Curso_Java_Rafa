package com.laboratorio.servidor;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class AtencionCliente extends Thread {
    private final Servidor padre;
    private final Socket conexion;
    private final int nCliente;

    public AtencionCliente(Servidor padre,Socket conexion, int nCliente) {
        this.conexion = conexion;
        this.nCliente = nCliente;
        this.padre = padre;
    }

    @Override
    public void run(){
        DataOutputStream salidaCliente;
        BufferedReader entradaCliente;
        Participante participante;
        String mensaje, nombre;
        try{
//            Se obtiene los flujos de entrada y salida
            salidaCliente = new DataOutputStream(
                    conexion.getOutputStream());
            entradaCliente = new BufferedReader(
                    new InputStreamReader(
                            conexion.getInputStream()));

//            Se recibe el primer mensaje del cliente
            mensaje = entradaCliente.readLine();
            nombre = mensaje.substring(2, mensaje.length());
            participante = new Participante(
                    nCliente,
                    nombre,
                    this
            );
            padre.agregarParticipante(participante);

//            Enviamos un mensaje al cliente
            salidaCliente.writeUTF(
                    "Conexion aceptada esperando instrucciones \n");

//            Se ejecuta mientras haya mensajes del cliente
            while((mensaje=entradaCliente.readLine())!=null){
                System.out.println("Mensaje Cliente "+
                        nCliente+": "+mensaje);
            }

            padre.quitarParticipante(participante);

//            Fin de la conexión del cliente
            entradaCliente.close();
            salidaCliente.close();
            conexion.close();
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
