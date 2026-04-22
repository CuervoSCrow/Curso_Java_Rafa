package com.laboratorio;

import com.laboratorio.animales.Animal;
import com.laboratorio.animales.Gato;
import com.laboratorio.animales.Perro;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Polimorfismo {
    public static void main(String[] args) {
//        Animal animal;
//        animal = new Animal("Oso", "Yogui", 5);
//        animal.comer();

        Animal perro;
        perro = new Perro("Rintintin", 3, "Pastor Alemán");
        perro.comer();
        perro.sonido();

        Animal gato;
        gato = new Gato("Garfield", 2, "Naranja");
        gato.comer();
        gato.sonido();
    }
}