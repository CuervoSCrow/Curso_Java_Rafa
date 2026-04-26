package com.laboratorio;

public class Main {
    public static void main(String[] args) {
       double resultado;

        resultado = Calculadora.suma(2, 3);
        System.out.println("resultado de la suma = " + resultado);

        resultado = Calculadora.resta(6, 4);
        System.out.println("resultado de la resta = " + resultado);

        resultado = Calculadora.multiplicacion(5, 6);
        System.out.println("resultado de la multiplicacion = " + resultado);

        resultado = Calculadora.division(8,4);
        System.out.println("resultado de la division= " + resultado);
    }
}