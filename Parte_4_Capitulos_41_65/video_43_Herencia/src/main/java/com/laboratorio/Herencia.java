package com.laboratorio;

import com.laboratorio.animales.Animal;
import com.laboratorio.animales.Gato;
import com.laboratorio.animales.Perro;

public class Herencia {
    public static void main(String[] args) {
        Animal animal;
        animal = new Animal("Oso", "Gordo", 5);
        animal.comer();

        Perro perro = new Perro("Rintintin", 3, "Pastor Alemán");
        perro.moverLaCola();

        Gato gato = new Gato("Garfield", 5, "Naranja");
        gato.maullar();
        gato.cazar();
        gato.comer()    ;
    }
}