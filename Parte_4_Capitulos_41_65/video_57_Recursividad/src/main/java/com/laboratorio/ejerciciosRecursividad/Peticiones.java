package com.laboratorio.ejerciciosRecursividad;

import java.util.Scanner;

public class Peticiones {
    private Scanner entrada = new Scanner(System.in);

    public int dameEnteroPositivo(){
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
    public int[] llenarArregloEnteroPositivo(){
        int i=0,tamaño;
        System.out.println("Dame el tamaño del arreglo: ");
        tamaño = entrada.nextInt();
        entrada.nextLine();

        int[] arreglo = new int[tamaño];
        for(i=0;i<tamaño;i++){
            arreglo[i]=dameEnteroPositivo();
        }
        return arreglo;
    }
    public void mostrarArray(int[] array){
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+", ");
        }
    }

    public String dameCadena(){
        String cadena;
        do {
            System.out.println("Escribe una cadena valida: ");
            cadena = entrada.nextLine();
            if (cadena == null || cadena.trim().isEmpty()) {
                System.out.println("La cadena no puede ser nula o vacia");
                System.out.println("Intente de nuevo.");
            } else {
                break;
            }
        }while(true);

        return cadena.trim();
    }

}
