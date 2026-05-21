package com.laboratorio.servidor;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class AtencionCliente extends Thread{
    private final Socket conexion;
    private final int nCliente;

    public AtencionCliente(Socket socket, int nCliente) {
        this.conexion = socket;
        this.nCliente = nCliente;
    }

    @Override
    public void run() {
        DataOutputStream salidaCliente;
        BufferedReader entradaCliente;
        String mensaje;

        try{
//            Se obtienen los flujos de entrada y salida
            salidaCliente = new DataOutputStream(
                    conexion.getOutputStream());
            entradaCliente = new BufferedReader(
                    new InputStreamReader(
                            conexion.getInputStream()));

//            Se recibe el primer mensaje del cliente
            mensaje = entradaCliente.readLine();
            System.out.println("Mensaje Cliente "
                    + nCliente + ": " + mensaje);

//            Enviamos un mensaje al cliente
            salidaCliente.writeUTF(
                    "Conexion aceptada esperando instrucciones \n");

//            Se ejecuta mientras haya mensajes del cliente
            while((mensaje=entradaCliente.readLine())!=null){
                System.out.println("Mensaje Cliente "
                        + nCliente + ": " + mensaje);
            }

//            Fin de conexion del cliente
            System.out.println("Fin de la conexion con el cliente "
                    + nCliente);

//            Se cierra la conexion
            entradaCliente.close();
            salidaCliente.close();
            conexion.close();

        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
