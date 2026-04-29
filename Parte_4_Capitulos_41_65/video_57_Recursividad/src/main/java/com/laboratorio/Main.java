package com.laboratorio;


import com.laboratorio.ejerciciosRecursividad.Factorial;
import com.laboratorio.ejerciciosRecursividad.Fibonacci;
import com.laboratorio.ejerciciosRecursividad.SumaElementos;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int opcion;

        System.out.println("Operaciones que este programa puede realizar ");
        System.out.println("1. Factorial");
        System.out.println("2. Fibonacci");
        System.out.println("3. Suma de elementos de un arreglo");
        System.out.println("4. Salir");

        do {
            Scanner entrada = new Scanner(System.in);
            System.out.println("Elije la opcion: ");
            opcion = entrada.nextInt();
            switch (opcion) {
                case 1:
                    Factorial factorial = new Factorial();
                    break;
                case 2:
                    Fibonacci fibonacci = new Fibonacci();
                    break;
                case 3:
                    SumaElementos sumaElementos = new SumaElementos();
                    break;
                case 4:
                    System.out.println("Saliendo !!!!!!");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (opcion != 4);
    }
}