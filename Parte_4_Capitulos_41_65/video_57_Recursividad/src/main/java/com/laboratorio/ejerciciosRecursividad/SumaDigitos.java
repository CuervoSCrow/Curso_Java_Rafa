package com.laboratorio.ejerciciosRecursividad;

import java.util.Scanner;

public class SumaDigitos {
    Peticiones peticiones = new Peticiones();
    public SumaDigitos() {
        System.out.println("Programa que calcula la suma de los digitos de un numero");
        int num = peticiones.dameEnteroPositivo();

        System.out.println("La suma de los digitos de "+num+" es "+sumaDigitos(num));
    }
    public int sumaDigitos(int num){
        if (num <= 0) {
            return 0;
        }
        return num % 10 + sumaDigitos(num / 10);
    }
}
