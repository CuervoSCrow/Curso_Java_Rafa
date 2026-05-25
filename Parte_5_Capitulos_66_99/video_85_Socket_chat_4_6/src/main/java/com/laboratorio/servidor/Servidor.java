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
    private int nClientes;
    private List<Participante> participantes;

    public Servidor(
            ServidorChat servidorChat,
            int puerto)throws Exception{
        this.ventana = servidorChat;
        this.puerto = puerto;
        this.serverSocket = new ServerSocket(puerto);
        this.continuar = true;
        this.nClientes = 0;
        this.participantes = new ArrayList<>();
    }

    public int getPuerto() {
        return puerto;
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void agregarParticipante(
            Participante participante) {
//        Avisar a otros usuario del nuevo participante
        String mensaje,mensajeNuevo;

        mensaje="CONECTADO\t" + participante.getNombre() + "\n";
        for(Participante p:participantes){
            p.getAtencionCliente().enviarMensaje(mensaje);
            mensajeNuevo = "CONECTADO\t"+p.getNombre()+"\n";
            p.getAtencionCliente().enviarMensaje(mensajeNuevo);
        }

//        Agregar participante a la lista
        ventana.agregarEvento("Se ha conetado "+
                participante.getNombre());
        this.participantes.add(participante);
//        refrescar el contenido de la lista
        ventana.refrescarLista();
    }

    public void quitarParticipante(
            Participante participante) {
        int i;
        for(i=participantes.size()-1;i>=0;i--){
            if(participantes.get(i).getId()==participante.getId()){
                ventana.agregarEvento("Se ha desconectado "+
                        participante.getNombre());
                this.participantes.remove(i);

            }else{
//                Avisar al usuario que el participante no esta disponible
            }
        }
        ventana.refrescarLista();
    }

    public void cerrar(){
        System.out.println("Cierre iniciado ...");
        continuar=false;
        try{
            serverSocket.close();
        }catch(IOException ex){
            System.out.println("Error al cerrar el servidor"+ex.getMessage());
        }
        System.out.println("Cierre finalizado");
    }

    @Override
    public void run(){
        try{
            Socket clienteSocket;
            ventana.agregarEvento("Iniciando el servidor... ");
            while(continuar){
//                Esperar a que un cliente se conecte
                clienteSocket = serverSocket.accept();
                nClientes++;

                AtencionCliente cliente =
                        new AtencionCliente(
                        this,
                        clienteSocket,
                        nClientes);
                cliente.start();
            }
        }catch(Exception ex){

        }
    }
}
