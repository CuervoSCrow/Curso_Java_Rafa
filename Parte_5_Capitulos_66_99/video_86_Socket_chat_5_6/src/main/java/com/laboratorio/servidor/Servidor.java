package com.laboratorio.servidor;

import com.laboratorio.ServidorChat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Servidor extends Thread{
    private ServidorChat ventana;
    private final int puerto;
    private final ServerSocket serverSocket;
    private boolean continuar;
    private int nCliente;
    private List<Participante> participantes;

    public Servidor(ServidorChat ventana,int puerto) throws Exception {
        this.puerto = puerto;
        this.ventana = ventana;
        this.serverSocket = new ServerSocket(puerto);
        this.continuar=true;
        this.nCliente=0;
        this.participantes = new ArrayList<>();
    }

    public int getPuerto() {
        return puerto;
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void agregarParticipante(Participante participante) {
//        Avisar a otros usuarios del nuevo participante
        String mensaje, mensajeNuevo;
        mensaje="CONECTADO\t"+participante.getNombre()+"\t"+participante.getId()+"\n";
        for(Participante part: participantes){
            part.getAtencionCliente().enviarMensajes(mensaje);
            mensajeNuevo = "CONECTADO\t"+part.getNombre()+"\t"+part.getId()+"\n";
            participante.getAtencionCliente().enviarMensajes(mensajeNuevo);
        }

        ventana.agregarEvento("Se ha conectado " + participante.getNombre());
        this.participantes.add(participante);

//        Refrescar el contenido de la lista
        ventana.refrescarLista();
    }

    public void quitarParticipante(Participante participante) {
        int i;
        Participante part;
        String mensaje="DESCONECTADO\t"+participante.getId()+"\n";
        for(i= participantes.size()-1;i>=0;i--){
            part=participantes.get(i);
            if(part.getId()==participante.getId()){
                ventana.agregarEvento("Se ha desconectado " + participante.getNombre());
                this.participantes.remove(i);

            }else{
//                Avisar al usuario que el participante ya no esta disponible
                part.getAtencionCliente().enviarMensajes(mensaje);
            }
        }
//        Refrescar la lista
        ventana.refrescarLista();

    }

    public void cerrar() {
        System.out.println("Cierre iniciado...");
        continuar = false;
        try{
            serverSocket.close();
        } catch (IOException ex) {
            System.out.println("Se ha producido un error inesperado al cerrar el socket "+ex.getMessage());
            return;
        }
        System.out.println("Cierre finalizado");
    }

    @Override
    public void run() {
        Socket clienteSocket = new Socket();

        try{
            ventana.agregarEvento("Iniciando servidor...");

            while(continuar){

//        Esperando la conexion con un cliente
                clienteSocket = serverSocket.accept();
                nCliente++;

                AtencionCliente atencionCliente = new AtencionCliente(
                        this,
                        clienteSocket,
                        nCliente);
                atencionCliente.start();
            }

        } catch (IOException ex) {
            if(continuar) {
                System.out.println("Se ha producido un error inesperado " + ex.getMessage());
                ventana.cerrarAplicacion(1);
            }
            return;
        }
    }
}
