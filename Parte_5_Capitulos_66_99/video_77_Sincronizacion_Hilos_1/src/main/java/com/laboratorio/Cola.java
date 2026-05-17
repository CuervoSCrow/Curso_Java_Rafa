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
    }
    public synchronized  Clientes eliminarCliente(){
        return cola.remove(0);
    }
    public synchronized boolean vacia(){
        return cola.isEmpty();
    }
}
