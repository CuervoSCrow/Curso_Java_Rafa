package com.laboratorio;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Persona p1 = new Persona("Rafa", 50, "12345");
        Persona p2 = new Persona("Maria", 41, "67895");
        Persona p3 = new Persona("Juan",35,"23456");

        ListaPersonas lista = new ListaPersonas();

        lista.agregar(p1);
        lista.agregar(p2);
        lista.agregar(p3);

        Optional<Persona> resultado1 = lista.buscarPorDocumento("34567");
        if(resultado1.isPresent()){
            System.out.println("Se encontro la persona: " + resultado1.get());
            Persona p = resultado1.get();
            System.out.println("Persona: "+p.toString());
        }else{
            System.out.println("(1) La persona buscada no existe");
        }

        Optional<Persona> resultado2 = lista.buscarPorDocumento("67895");
        if(resultado2.isEmpty()){
            System.out.println("(2) La persona buscada no existe");
        }else{
            Persona p = resultado2.get();
            System.out.println("Persona: "+p.toString());
        }


    }
}