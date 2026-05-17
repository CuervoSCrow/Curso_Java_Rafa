package com.laboratorio;

import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Cajero extends Thread{
    private final String nombre;
    private final Cola cola;
    private final CountDownLatch latch;
    private final LlegadaClientes llegada;

    public Cajero(String nombre,Cola cola,CountDownLatch latch,LlegadaClientes llegada){
        this.nombre = nombre;
        this.cola = cola;
        this.latch = latch;
        this.llegada = llegada;
    }
    @Override
    public void run() {
        while(!cola.vacia()){
            Clientes cliente = cola.eliminarCliente();
            System.out.println("El cajero: "+this.nombre+
                    " esta atendiendo al cliente: "+cliente.getNumero());
            try {
                Thread.sleep(cliente.getTiempoAtencion()*1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Ha finalizado la atencion del cliente "+
                    cliente.getNumero()+". Ha demorado "+cliente.getTiempoAtencion()+
                    " segundos");
        }
        llegada.detener();
//        Avisa que el hilo ha terminado
        latch.countDown();
    }
}
