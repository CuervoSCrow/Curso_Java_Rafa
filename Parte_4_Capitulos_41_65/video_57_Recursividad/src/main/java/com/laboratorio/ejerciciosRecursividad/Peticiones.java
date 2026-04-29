package com.laboratorio.ejerciciosRecursividad;

import java.util.Scanner;

public class Peticiones {
    public int dameEnteroPositivo(){
        Scanner entrada = new Scanner(System.in);
        int numero;
        try {
            System.out.print("Dime un numero entero: ");
            numero = entrada.nextInt();
        }catch(Exception ex){
            System.out.println("");
            System.out.println("El numero debe ser entero");
            return -1;
        }
        if(numero<0){
            System.out.println("El numero debe ser >= 0");
            return -1;
        }
        return numero;
    }

}
