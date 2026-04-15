package com.laboratorio;

import com.laboratorio.calculos.AreaCuadrado;

import java.util.Scanner;

public class Main {
    static char menuOpciones(){
        char opcion;
        Scanner teclado = new Scanner(System.in);
        System.out.println("");
        System.out.println("");
        System.out.println("****************");
        System.out.println("Menu de Opciones");
        System.out.println("****************");
        System.out.println("(1) Calcular el area de un rectangulo.");
        System.out.println("(2) Calcular el area de un triangulo.");
        System.out.println("(3) Calcular el area de un cuadrado.");
        System.out.println("(4) Fin del Programa.");
        System.out.println("");
        System.out.println("Indique su opción: ");

        opcion=teclado.next().charAt(0);

        return opcion;
    }
    public static void main(String[] args) {
        char opcion;

        do{
            opcion = menuOpciones();
            switch (opcion){
                case '1':
                    AreaCuadrado areaCuadrado;
                    areaCuadrado=new AreaCuadrado();
                    areaCuadrado.mostrar();
                    System.out.println("Calculo del area de un rectangulo.");
                    break;
                case '2':
                    System.out.println("Calculo del area de un triangulo.");
                    break;
                case '3':
                    System.out.println("Calculo del area de un cuadrado.");
                    break;
                case '4':
                    System.out.println("Saliendo el programa .....!");
                    break;
                default:
                    System.out.println("Error.. Opcion Inexistente");
                    break;
            }
        }while(opcion != '4');
    }
}