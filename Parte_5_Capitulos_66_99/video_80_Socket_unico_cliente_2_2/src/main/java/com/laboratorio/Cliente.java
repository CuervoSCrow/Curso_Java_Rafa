package com.laboratorio;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Cliente {
    private final String host;
    private final int puerto;
    private Socket conexion;

    public Cliente(String host, int puerto)throws Exception {
        this.host = host;
        this.puerto = puerto;
        conexion = new Socket(host,puerto);
    }

    public String getHost() {
        return host;
    }

    public int getPuerto() {
        return puerto;
    }

    public void startClient() throws Exception {
        DataOutputStream salidaServidor;
        BufferedReader entradaServidor;
        String mensaje;

//        Obtiene los flujos de entrada y salida al servidor
        salidaServidor = new DataOutputStream(
                conexion.getOutputStream());
        entradaServidor = new BufferedReader(
                new InputStreamReader(
                        conexion.getInputStream()));

//        Se envia mensaje al servidor
        salidaServidor.writeUTF("Iniciando transmision " +
                "al servidor\n");

//        Se recibe el mensaje del servidor
        mensaje = entradaServidor.readLine();
        System.out.println("Mensaje servidor: " + mensaje);

//        Se envia mensaje al servidor
        salidaServidor.writeUTF("Instrucción a ejecutar el servidor\n");

        entradaServidor.close();
        salidaServidor.close();
        conexion.close();
    }
}
