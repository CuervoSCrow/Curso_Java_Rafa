package com.laboratorio.cliente;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    private final String host;
    private final int puerto;
    private final Socket conexion;

    public Cliente(String host, int puerto) throws Exception {
        this.host = host;
        this.puerto = puerto;
        this.conexion = new Socket(host, puerto);
    }

    public String getHost() {
        return host;
    }

    public int getPuerto() {
        return puerto;
    }

    public char mostrarMenu(){
        Scanner teclado = new Scanner(System.in);

        System.out.println("***************************************");
        System.out.println(" Menu de Opciones:");
        System.out.println(" 1. Enviar Saludo.");
        System.out.println(" 2. Cerrar la conexión.");
        System.out.println(" Indique la Opción: ");
        System.out.println("***************************************");
        return teclado.next().charAt(0);
    }

    public void startCliente()throws Exception{
        DataOutputStream salidaServidor;
        BufferedReader entradaServidor;
        String mensaje;
        boolean seguir=true;
        char operacion;

//        Obtiene el flujo de entrada y salida
        salidaServidor = new DataOutputStream(
                conexion.getOutputStream());
        entradaServidor = new BufferedReader(
                new InputStreamReader(
                        conexion.getInputStream()));

//        Se envia el mensaje al servidor
        salidaServidor.writeUTF("Laboratorio Cuervo2 \t");

//        Se recibe el mensaje del servidor
        mensaje = entradaServidor.readLine();
        System.out.println("Mensaje del servidor: "+mensaje);

        do{
            operacion = mostrarMenu();
            switch (operacion){
                case '1':
//                    Se envia un saludo al servidor
                    salidaServidor.writeUTF("Saludos al servidor\n");
                    break;
                case '2':
                    seguir = false;
                    break;
                default:
                    System.out.println("Opcion inexistente");
                    break;
            }
        }while(seguir);

        entradaServidor.close();
        salidaServidor.close();
        conexion.close();
    }
}
