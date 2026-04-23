package com.laboratorio;

import com.laboratorio.animales.Animal;
import com.laboratorio.animales.Gato;
import com.laboratorio.animales.Perro;

public class Interfaces {
    public static void main(String[] args) {
        Animal animal;
        animal = new Animal("Oso", "Gordo", 5);
        animal.comer();


        Perro perro;
        perro = new Perro("Rintintin", 3,"Pastor");
        perro.moverLaCola();
        perro.comportamiento();
        perro.claseDeAnimal();

        Gato gato;
        gato = new Gato("Garfield", 2, "Naranja");
        gato.cazar();
        gato.comportamiento();
        gato.claseDeAnimal();
    }
}