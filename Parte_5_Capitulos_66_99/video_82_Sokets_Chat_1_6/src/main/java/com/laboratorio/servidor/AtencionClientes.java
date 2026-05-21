package com.laboratorio.servidor;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class AtencionClientes extends Thread{
    private final Socket conexion;
    private final int nCliente;

    public AtencionClientes(Socket conexion, int nCliente) {
        this.conexion = conexion;
        this.nCliente = nCliente;
    }

    @Override
    public void run() {
        DataOutputStream salidaCliente;
        BufferedReader entradaCliente;
        String mensaje;

        try{
//            Se obtiene los flujos de entrada y salida
            salidaCliente = new DataOutputStream(
                    conexion.getOutputStream());
            entradaCliente = new BufferedReader(
                    new InputStreamReader(
                            conexion.getInputStream()));

//            Se recibe el primer mensaje del cliente
            mensaje = entradaCliente.readLine();
            System.out.println("Mensaje Cliente "+
                    nCliente+": "+mensaje);

//            Enviamos un mensaje al cliente
            salidaCliente.writeUTF(
                    "Conexión aceptada esperando instrucciones. \n");

//            Se ejecuta mientras haya mensajes del cliente
            while((mensaje=entradaCliente.readLine())!=null){
                System.out.println("Mensaje Cliente "+
                        nCliente+": "+mensaje);
            }
//            Fin de la conexion del cliente
            System.out.println("Fin de la conexion con el cliente.");

//            Fin de la conexion del cliente
            entradaCliente.close();
            salidaCliente.close();
            conexion.close();

        }catch(IOException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
