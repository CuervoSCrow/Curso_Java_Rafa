package com.laboratorio.animales;

public class Perro extends Animal implements Mascota, Canino{
    protected String raza;

    public Perro(String nombre, int edad, String raza) {
        super("Perro", nombre, edad);
        this.raza = raza;
    }
    public void ladrar() {
        System.out.println("El perro " + nombre + " de " + edad + " años, esta ladrando");
    }
    public void moverLaCola() {
        System.out.println("El perro " + nombre + " de " + edad + " años, esta moviendo la cola");
    }

    @Override
    public void comportamiento() {
        System.out.println("Soy un perro y me comporto como una mascota");
    }

    @Override
    public void claseDeAnimal() {
        System.out.println("Soy un perro y soy un canino.");
    }
}
