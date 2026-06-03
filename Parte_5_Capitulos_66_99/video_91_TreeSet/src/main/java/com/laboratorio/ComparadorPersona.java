package com.laboratorio;

import java.util.Comparator;

public class ComparadorPersona
        implements Comparator<Persona> {
    @Override
    public int compare(Persona o1, Persona o2) {
       String nombre1= o1.getNombre();
       String nombre2= o2.getNombre();
       return nombre1.compareToIgnoreCase(nombre2);
    }
}
