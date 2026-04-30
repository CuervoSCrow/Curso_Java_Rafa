package com.laboratorio;


import com.laboratorio.ejerciciosRecursividad.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int opcion;

        do {
            menu();
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
                    ContarDigitos contarDigitos = new ContarDigitos();
                    break;
                case 5:
                    Potencia potencia = new Potencia();
                    break;
                case 6:
                    InvertirCadena invertirCadena = new InvertirCadena();
                    break;
                case 7:
                    Palindromo palindromo = new Palindromo();
                    break;
                case 8:
                    MaximoComunDivisor maximoComunDivisor = new MaximoComunDivisor();
                    break;
                case 9:
                    System.out.println("Saliendo !!!!!!");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (opcion != 9);
    }
    public static void menu(){
        System.out.println("Operaciones que este programa puede realizar ");
        System.out.println("1. Factorial");
        System.out.println("2. Fibonacci");
        System.out.println("3. Suma de elementos de un arreglo");
        System.out.println("4. Contar digitos de un numero");
        System.out.println("5. Potencia");
        System.out.println("6. Invertir Cadena");
        System.out.println("7. Palindromo");
        System.out.println("8. Maximo Comun Divisor");
        System.out.println();
        System.out.println("9. Salir");

    }
}