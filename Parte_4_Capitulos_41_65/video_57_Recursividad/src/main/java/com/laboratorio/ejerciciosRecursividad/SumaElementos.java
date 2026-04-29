package com.laboratorio.ejerciciosRecursividad;

import java.util.Scanner;

public class SumaElementos {
    private   Scanner entrada = new Scanner(System.in);
    private  int[] arreglo;
    private  int tamaño;
    private Peticiones peticiones = new Peticiones();
    public  SumaElementos(){

        System.out.println("Programa que suma los numeros de un arreglo");
        llenarArreglo(arreglo);
        mostrarArray(arreglo);
        System.out.println("\nLa suma de los elementos del arreglo es: "+sumar(arreglo));
    }
    public int[] llenarArreglo(int[] array){
        int i=0;
        System.out.println("Dime el tamaño del arreglo: ");
        tamaño=entrada.nextInt();
        entrada.nextLine();
        arreglo=new int[tamaño];
        for(i=0;i<tamaño;i++){
            arreglo[i]= peticiones.dameEnteroPositivo();
        }
        return arreglo;
    }

    public static int sumar(int[] array,int indice){
        if(indice==array.length){
            return 0;
        }
        return array[indice]+sumar(array,indice+1);
    }
    public static int sumar(int[] array){
        return sumar(array,0);
    }
    public static void mostrarArray(int[] array){
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+", ");
        }
    }

}
