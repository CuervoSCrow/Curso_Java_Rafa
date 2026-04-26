package com.laboratorio;

import com.laboratorio.animales.Animal;
import com.laboratorio.animales.Gato;
import com.laboratorio.animales.Perro;

public class Scraping {
    public static void main(String[] args) {
        Animal animal[] = new Animal[5];
        animal[0] = new Animal("Caballo", "Relampago", 5);
        animal[1] = new Perro("Rintintin", 3, "Pastor Alemán");
        animal[2] = new Gato("Garfield", 5, "Naranja");
        animal[3] = new Animal("Vaca","Lola",7);
        animal[4] = new Animal("Conejo","Orejón",2);


        animal[0].comer();
        Perro perro=(Perro)animal[1];
        perro.moverLaCola();
        Gato gato =(Gato)animal[2];
        gato.cazar();

    }
}