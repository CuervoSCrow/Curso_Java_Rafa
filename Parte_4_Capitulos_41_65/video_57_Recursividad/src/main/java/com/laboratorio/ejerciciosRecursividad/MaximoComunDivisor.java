package com.laboratorio.ejerciciosRecursividad;

import java.util.Scanner;

public class MaximoComunDivisor {

    public MaximoComunDivisor() {
        System.out.println("Programa que calcula el Maximo comun Divisor");
        System.out.println("Con el Algoritmo de Euclides");
        System.out.println("Introduce el primer numero: ");
        Scanner entrada = new Scanner(System.in);
        int num1 = entrada.nextInt();
        System.out.println("Introduce el segundo numero: ");
        int num2 = entrada.nextInt();
        System.out.println("El Maximo comun Divisor de " + num1 + " y " + num2 + " es " + maximoComunDivisor(num1, num2));
    }
    public int maximoComunDivisor(int n1, int n2){
        n1=Math.abs(n1);
        n2=Math.abs(n2);
        if (n2 == 0) {
            return n1;
        }
        return maximoComunDivisor(n2, n1 % n2);
    }


}
