package com.laboratorio;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        HashSet<Persona> personas = new HashSet<>();

        Persona persona1 = new Persona(
                "Juan", "Perez",
                (short) 16, "1234");
        System.out.println("HashCode: "+persona1.hashCode());
        Persona persona2 = new Persona(
                "Maria", "Valero",
                (short) 26, "5678");
        System.out.println("HashCode: "+persona2.hashCode());
        Persona persona3 = new Persona(
                "Jose", "Martinez",
                (short) 34, "9012");
        System.out.println("HashCode: "+persona3.hashCode());
        Persona persona4 = new Persona(
                "Juan", "Perez",
                (short) 16, "1234");
        System.out.println("HashCode: "+persona4.hashCode());
        System.out.println("");

        personas.add(persona1);
        personas.add(persona2);
        personas.add(persona3);
        personas.add(persona4);

        for (Persona persona : personas) {
            System.out.println(persona);
            System.out.println("HashCode: "+persona.hashCode());
        }
        System.out.println("Tamaño: "+personas.size());
    }
}