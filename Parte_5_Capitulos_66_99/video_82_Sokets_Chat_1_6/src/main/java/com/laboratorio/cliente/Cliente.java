package com.laboratorio.cliente;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    private final int puerto;
    private final Socket conexion;
    private final String host;

    public Cliente( String host,int puerto)throws Exception {
        this.puerto = puerto;
        this.host = host;
        this.conexion = new Socket(host,puerto);
    }

    public int getPuerto(){
        return puerto;
    }
    public String getHost(){
        return host;
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
    public void startCliente() throws Exception{
        DataOutputStream salidaServidor;
        BufferedReader entradaServidor;
        String mensaje;
        boolean seguir = true;
        char operacion;

//        Obtiene los flujos de entrada y salida
        salidaServidor = new DataOutputStream(
                conexion.getOutputStream());
        entradaServidor = new BufferedReader(
                new InputStreamReader(
                        conexion.getInputStream()));

//        Se envia mensaje al servidor
        salidaServidor.writeUTF(
                "Iniciando Transmision al servidor\n");

//       Se recibe mensaje del servidor
        mensaje = entradaServidor.readLine();
        System.out.println("Mensaje del Servidor: " + mensaje);

        do{
            operacion=mostrarMenu();
            switch (operacion){
                case '1':
//                    Se envia un saludo al servidor
                    salidaServidor.writeUTF(
                            "Saludos al servidor\n");
                    break;
                case '2':
                    seguir = false;
                    break;
                default:
                    System.out.println("Opción no valida");
                    break;
            }
        }while(seguir);

        entradaServidor.close();
        salidaServidor.close();
        conexion.close();
    }
}
