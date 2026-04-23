package com.laboratorio.animales;

public class Gato extends Animal implements Mascota, Felino {
    protected String color;

    public Gato( String nombre, int edad, String color) {
        super("Gato", nombre, edad);
        this.color = color;
    }
    public void maullar() {
        System.out.println("El gato "+nombre+" de "+edad+" años, esta maullando");
    }
    public void cazar() {
        System.out.println("El gato "+nombre+" de "+edad+" años, esta cazando");
    }

    @Override
    public void comportamiento() {
        System.out.println("Soy un gato y me comporto como una mascota");
    }

    @Override
    public void claseDeAnimal() {
        System.out.println("Soy un gato y soy un felino.");
    }
}
