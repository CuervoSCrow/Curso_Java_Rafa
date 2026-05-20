package com.laboratorio;

import java.util.ArrayList;
import java.util.List;

public class Cola {
    List<Clientes> cola;

    public Cola() {
        this.cola = new ArrayList<>();
    }
    public synchronized void agregarCliente(Clientes cliente){
        cola.add(cliente);
        if(cola.size()>=5){
            System.out.println("Se notifica la apertura de la tienda.");
            notifyAll();
        }
    }
    public synchronized  Clientes eliminarCliente(){
        return cola.remove(0);
    }
    public synchronized boolean vacia(){
        return cola.isEmpty();
    }
    public synchronized void esperarApertura(String nombre) {
        try{
            System.out.println("El cajero: "+nombre+
                    " esta esperando la apertura de la Tienda.");
            wait();
            System.out.println("El cajero: "+nombre+
                    " comienza a trabajar.");
        }catch(InterruptedException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
