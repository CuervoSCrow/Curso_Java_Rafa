package com.laboratorio;

import java.util.PriorityQueue;

public class Main {
    public static void procesarColaPrioridadPorDefecto(){
        PriorityQueue<Integer> cola=new PriorityQueue<>();
        cola.add(10);
        cola.add(20);
        cola.add(15);
        cola.add(5);
        cola.add(50);

        System.out.println("Primer elemento: "+cola.peek());
        while(!cola.isEmpty()){
            System.out.println("Procesando: "+cola.poll());
        }
    }
    public static void procesarColaConPrioridad(){
        PriorityQueue<Ticket> cola = new PriorityQueue<>();
        Ticket ticket;

        ticket = new Ticket("azul", 1);
        cola.add(ticket);
        ticket = new Ticket("verde",2);
        cola.add(ticket);
        ticket = new Ticket("amarillo",3);
        cola.add(ticket);
        ticket = new Ticket("azul",4);
        cola.add(ticket);
        ticket = new Ticket("verde",5);
        cola.add(ticket);
        ticket = new Ticket("rojo",6);
        cola.add(ticket);
        ticket = new Ticket("verde",7);
        cola.add(ticket);
        ticket = new Ticket("amarillo",8);
        cola.add(ticket);
        ticket = new Ticket("azul",9);
        cola.add(ticket);
        ticket = new Ticket("rojo",10);
        cola.add(ticket);

        System.out.print("Primer Elemento: ");
        cola.peek().escribir();
        while(!cola.isEmpty()){
            cola.poll().escribir();
        }
    }
    public static void main(String[] args) {
//        procesarColaPrioridadPorDefecto();
        procesarColaConPrioridad();
    }

}