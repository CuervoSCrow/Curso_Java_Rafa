package com.laboratorio.ejerciciosRecursividad;

import java.util.Scanner;

public class BusquedaBinaria {
    Scanner entrada = new Scanner(System.in);
    Peticiones peticiones = new Peticiones();
    int[] array;
    int posicion;

    public BusquedaBinaria() {
        int numeroBuscar;
        System.out.println("Programa que implementa la Busqueda Binaria");
        array = peticiones.llenarArregloEnteroPositivo();
        array = peticiones.ordenarArregloIntASC(array);
        peticiones.mostrarArray(array);
        System.out.println("Dame el numero que deseas buscar: ");
        numeroBuscar = entrada.nextInt();

        posicion = busquedaBinaria(array,numeroBuscar);
        if(posicion == -1){
            System.out.println("El numero no se encuentra en el arreglo");
        }else{
            System.out.println("El numero se encuentra en la posicion: "+posicion);
        }



    }
    public int busquedaBinaria(int[] array, int objetivo) {
        return busquedaBinaria(array,objetivo,0, array.length-1 );
    }
    public int busquedaBinaria(int[] array, int objetivo, int izquierda, int derecha) {
        if(izquierda>derecha){
            return -1;
        }
//        calculamos el indice del medio (evitando desbordamiento)
        int medio = izquierda + (derecha - izquierda) / 2;
//        caso base 2 encontramos el objetivo
        if(array[medio]==objetivo){
            return medio;
        }
//        Casos recursivos: buscar en la mitad izquierda y derecha
        if(objetivo<array[medio]){
            return busquedaBinaria(array,objetivo,izquierda,medio-1);
        }else{
            return busquedaBinaria(array,objetivo,medio+1,derecha);
        }
    }
}
