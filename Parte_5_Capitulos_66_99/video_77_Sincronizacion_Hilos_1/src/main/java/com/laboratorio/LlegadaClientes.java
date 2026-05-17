package com.laboratorio;

import java.util.concurrent.CountDownLatch;

public class LlegadaClientes extends Thread{
    private final Cola cola;
    private volatile boolean finalizar;
    private int numCliente;
    private CountDownLatch latch;

    public LlegadaClientes(Cola cola,CountDownLatch latch) {
        this.cola = cola;
        this.latch = latch;
        this.finalizar=false;
        this.numCliente=0;
    }
    @Override
    public void run() {
        int tiempoLlegada;

        while(!finalizar){
            Clientes cliente;
            tiempoLlegada = (int) (Math.random()*5+1);
            try{
                Thread.sleep(tiempoLlegada*1000);
            } catch (InterruptedException e) {
                System.out.println("Error: "+e.getMessage());
            }
            numCliente++;
            System.out.println("LLego el cliente "+numCliente+". Ha demorado "+tiempoLlegada+" segundos");
            cliente = new Clientes(numCliente);
            cola.agregarCliente(cliente);
//            System.out.println("Llega el cliente: "+numCliente);
        }
//        Avisa que el hilo ha terminado
        latch.countDown();
    }
    public synchronized void detener(){
        if(!finalizar) {
            System.out.println("Se cierra la tienda.");
            this.finalizar = true;
        }else{
            System.out.println("La tienda ya esta cerrada.");
        }
    }
}
