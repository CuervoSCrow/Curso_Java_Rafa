package com.laboratorio;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Clientes cliente1 = new Clientes(1);
        Clientes cliente2 = new Clientes(2);
        List<Clientes> cola=new ArrayList();
        Cajero1 cajero1 = new Cajero1("Cajero 1", cola);
        Cajero2 cajero2 = new Cajero2("Cajero 2", cola);

        long timpoInicial = System.currentTimeMillis();

        cola.add(cliente1);
        cola.add(cliente2);

        cajero1.start();
        cajero2.run();

        long tiempoFinal = System.currentTimeMillis();
//        System.out.println("Tiempo de ejecucion: "+(tiempoFinal-timpoInicial)/1000+" segundos");
        System.out.println("Finaliza el programa");
    }
}