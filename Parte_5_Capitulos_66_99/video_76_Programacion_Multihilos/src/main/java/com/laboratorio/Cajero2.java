package com.laboratorio;

import java.util.List;

public class Cajero2 implements Runnable{
    private final String nombre;
    private final List<Clientes> cola;

    public Cajero2(String nombre, List<Clientes> cola){
        this.nombre = nombre;
        this.cola = cola;
    }
    @Override
    public void run() {
        while(!cola.isEmpty()){
            Clientes cliente = cola.remove(0);
            System.out.println("El cajero "+this.nombre);
            System.out.println("Esta atendiendo al cliente: "+cliente.getNumero());
            try{
                Thread.sleep(cliente.getTiempoAtencion()*1000);
            }catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
            System.out.println("Ha finalizado la atención del cliente "+
                    cliente.getNumero()+" en "+this.nombre+" en "+cliente.getTiempoAtencion()+
                    " segundos");
        }

    }
}
