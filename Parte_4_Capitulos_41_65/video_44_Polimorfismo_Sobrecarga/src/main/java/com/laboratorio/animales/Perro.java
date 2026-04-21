package com.laboratorio.animales;

public class Perro extends Animal{

    protected String raza;
    public Perro(String nombre, int edad, String raza){
        super("Perro",nombre,edad);
        this.raza=raza;
    }
    public void moverLaCola(){
        System.out.println("El perro "+nombre+" de edad "+edad+" y raza "+raza+" esta moviendo la cola");
    }
    @Override
    public void sonido(){
        System.out.println("El perro "+nombre+" de edad "+edad+" y raza "+raza+" esta ladrando");
    }
}
