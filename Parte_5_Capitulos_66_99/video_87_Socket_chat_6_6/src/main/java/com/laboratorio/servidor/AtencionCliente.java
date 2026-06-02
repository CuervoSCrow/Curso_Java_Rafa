package com.laboratorio.servidor;

import com.laboratorio.cliente.Contacto;

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
    private String nombre;


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
        String mensaje;
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

                procesarMensaje(mensaje.substring(2,mensaje.length()));
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

    private void procesarMensaje(String mensaje) {
        int pos;
        String comando;
        pos = mensaje.indexOf('\t');
        if (pos < 0) {
            System.out.println("Comando no valido");
            return;
        }
        comando = mensaje.substring(0, pos);

        if (comando.equalsIgnoreCase("MENSAJE")) {
            procesarComandoMensaje(mensaje);
        }
    }

    private void procesarComandoMensaje(String comando) {
        int pos1,pos2,id;
        String mensaje,str;

        pos1 = comando.indexOf('\t');
        pos2 = comando.indexOf('\t',pos1+1);
        str = comando.substring(pos1+1,pos2);
        id=Integer.parseInt(str);
        mensaje= comando.substring(pos2+1,comando.length());
        padre.enviarMensaje(id,mensaje,nombre);

    }


}
