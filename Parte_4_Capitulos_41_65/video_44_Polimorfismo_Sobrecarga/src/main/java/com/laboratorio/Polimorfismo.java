package com.laboratorio;

import com.laboratorio.animales.Animal;
import com.laboratorio.animales.Gato;
import com.laboratorio.animales.Perro;

public class Polimorfismo {
    public static void main(String[] args) {

        Animal animal;
        animal = new Animal("Oso", "Yogui", 5);
        animal.comer();
        animal.sonido();

        Animal perro;
        perro = new Perro("Rintintin", 4, "Pastor Alemán");

        perro.sonido();

        Animal gato;
        gato = new Gato("Garfield", 5, "Naranja");
        gato.sonido();
    }
}