package com.laboratorio;

public class Main {
    public static void main(String[] args) {
//        Metodos de Math usados en el codigo
//        1.- Valor de Pi y e
//        2.- Logaritmos
//        3.- Raices
//        4.- Seno, Coseno y Tangente
//        5.- Conversión entre grados y radianes

        double resultado1,resultado2,resultado3;
        double resultado4,resultado5,resultado6,angulo=45,radianes;
        System.out.println("Valor de Pi: "+Math.PI);
        System.out.println("Valor de e: "+Math.E);
        resultado1=Math.log(Math.E);
        System.out.println("El resultado de la operacion " +
                "logaritmo natural de e: "+resultado1);
        resultado2=Math.log10(100);
        System.out.println("El resultado de la operacion " +
                "logaritmo base 10 de 100: "+resultado2);
        resultado3=Math.sqrt(4);
        System.out.println("El resultado de la operacion " +
                "raiz cuadrada de 4: "+resultado3);

        radianes = Math.toRadians(angulo);
        resultado4=Math.sin(radianes);
        System.out.println("El resultado de la operacion " +
                "seno de 45 grados: "+resultado4);

        resultado5=Math.cos(radianes);
        System.out.println("El resultado de la operacion " +
                "coseno de 45 grados: "+resultado5);

        resultado6=Math.tan(radianes);
        System.out.println("El resultado de la operacion " +
                "tangente de 45 grados: "+resultado6);
    }
}