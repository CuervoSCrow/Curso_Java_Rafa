package com.laboratorio.servidor;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class AtencionCliente extends Thread {

    private final Servidor padre;
    private final Socket conexion;
    private final int nCliente;
    DataOutputStream salidaCliente;


    public AtencionCliente(
            Servidor padre,
            Socket conexion,
            int nCliente) {
        this.padre=padre;
        this.conexion = conexion;
        this.nCliente = nCliente;
        this.salidaCliente = null;
    }

    public void enviarMensajes(String mensaje) {
        if(salidaCliente!=null){
            try {
                salidaCliente.writeUTF(mensaje);
            } catch (IOException e) {
                System.out.println("Error Enviando mensaje: "+e.getMessage());
            }
        }
    }

    @Override
    public void run() {
        BufferedReader entradaCliente;
        Participante participante;
        String mensaje, nombre;
        try {
//            Se obtienen los flujos de entrada y salida
            salidaCliente= new DataOutputStream(
                    conexion.getOutputStream());
            entradaCliente = new BufferedReader(
                    new InputStreamReader(
                            conexion.getInputStream()));

//            Se recibe el primer mensaje del cliente
            mensaje = entradaCliente.readLine();
            nombre = mensaje.substring(2,mensaje.length());
            participante = new Participante(nCliente, nombre,this);
            padre.agregarParticipante(participante);


//            Enviamos un mensaje al cliente
            salidaCliente.writeUTF(
                    "Conexion aceptada esperando instrucciones\n");

//            Se ejecuta mientras haya mensajes del cliente
            while((mensaje= entradaCliente.readLine())!=null){
                System.out.println("Mensaje cliente: " +
                        nCliente+" : " + mensaje);
            }

//             Fin de la conexion cliente
            padre.quitarParticipante(participante);

//            Se cierra la conexion
            entradaCliente.close();
            salidaCliente.close();
            conexion.close();

        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
    }
}
