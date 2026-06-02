package com.laboratorio.cliente;

import com.laboratorio.ClienteChat;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class Cliente extends Thread{
    private final ClienteChat ventana;
    private final String host;
    private final int puerto;
    private final String nombre;
    private final Socket conexion;
    private final List<Contacto> contactos;
    private boolean seguir = true;
    private DataOutputStream salidaServidor;

    public Cliente(
            ClienteChat ventana,
            String host,
            int puerto,
            String nombre)throws Exception {
        this.ventana=ventana;
        this.puerto = puerto;
        this.host = host;
        this.nombre=nombre;
        this.conexion = new Socket(host,puerto);
        this.contactos = new ArrayList<>();
        this.salidaServidor = null;
    }

//    METODOS GET
    public int getPuerto(){
        return puerto;
    }

    public String getHost(){
        return host;
    }

    public List<Contacto> getContactos(){
        return contactos;
    }

    public void desconectar(){
        seguir=false;
        try{
            conexion.close();
        }catch(IOException ex){
            System.out.println("Error al cerrar la conexion: "+ex.getMessage());
        }
    }

    public void enviarMensaje(int pos,String mensaje){
        if(salidaServidor==null){
            return;
        }
        Contacto c = contactos.get(pos);
        int id = c.getId();
        String comando="MENSAJE\t"+id+"\t"+mensaje+"\n";
        try {
            salidaServidor.writeUTF(comando);
        }catch(IOException ex){
            System.out.println("Error al enviar mensaje: "+ex.getMessage());
        }


    }

    @Override
    public void run() {

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
        String comando;
        pos = mensaje.indexOf('\t');
        if(pos<0){
            System.out.println("Comando no valido");
            return;
        }
        comando=mensaje.substring(0,pos);

        if(comando.equalsIgnoreCase("CONECTADO")){
            procesarComandoConectado(mensaje);
        }else{
            if(comando.equalsIgnoreCase("DESCONECTADO")){
                procesarComandoDesconectado(mensaje);
            }
        }

    }

    private void procesarComandoConectado(String comando){
        int pos1,pos2,id;
        String nomParticipante,str;

        pos1 = comando.indexOf('\t');
        pos2 = comando.indexOf('\t',pos1+1);
        nomParticipante = comando.substring(pos1+1,pos2);
        str = comando.substring(pos2+1,comando.length());
        id = Integer.parseInt(str);
        ventana.agregarEvento(nombre+" esta conectado.");
        Contacto c = new Contacto(id,nomParticipante);
        contactos.add(c);

        ventana.actualizarLista();
    }

    private void procesarComandoDesconectado(String comando){
        int pos,id,i;
        String str;
        pos = comando.indexOf('\t');
        str = comando.substring(pos+1,comando.length());
        id=Integer.parseInt(str);
        for(i= contactos.size()-1;i>=0;i--){
            if(contactos.get(i).getId()==id){
                contactos.remove(i);
                break;
            }
        }
        ventana.actualizarLista();
    }
}
