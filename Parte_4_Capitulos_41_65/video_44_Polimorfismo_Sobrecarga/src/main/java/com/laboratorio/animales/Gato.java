package com.laboratorio.animales;

public class Gato extends Animal{
    protected String color;

    public Gato(String nombre, int edad, String color){
        super("Gato",nombre,edad);
        this.color=color;
    }

    public void maullar(){
        System.out.println("El gato "+nombre+" de "+edad+" años esta maullando.");
    }
    public void cazar(){
        System.out.println("El gato "+nombre+" de "+edad+" años esta cazando.");
    }
    @Override
    public void sonido(){
        System.out.println("El gato "+nombre+" de "+edad+" años esta maullando.");
    }
}
