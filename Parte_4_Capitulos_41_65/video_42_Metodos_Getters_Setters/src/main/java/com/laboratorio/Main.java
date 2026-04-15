package com.laboratorio;

import com.laboratorio.calculos.AreaCuadrado;
import com.laboratorio.calculos.AreaRectangulo;
import com.laboratorio.calculos.AreaTriangulo;

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

    static double obtenerDatos(String nombreDato){
        double dato;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese "+nombreDato+": ");
        try{
            dato=teclado.nextDouble();
        }catch (Exception e){
            System.out.println("Error el valor debe ser numerico.");
            return 0;
        }
        return dato;
    }

    public static void main(String[] args) {
        char opcion;
        double base,altura;

        do{
            opcion = menuOpciones();
            switch (opcion){
                case '1':
                    AreaRectangulo areaRectangulo;
                    base= obtenerDatos("La longitud de la base del rectangulo: ");
                    if(base!=0){
                        altura=obtenerDatos("La altura del rectangulo: ");
                        if(altura!=0){
                            areaRectangulo = new AreaRectangulo();
                            areaRectangulo.setBase(base);
                            areaRectangulo.setAltura(altura);
                            areaRectangulo.mostrar();
                        }
                    }
                    break;
                case '2':
                    AreaTriangulo areaTriangulo;
                    base= obtenerDatos("La longitud de la base del triangulo: ");
                    if(base!=0){
                        altura=obtenerDatos("La altura del triangulo: ");
                        if(altura!=0){
                            areaTriangulo = new AreaTriangulo();
                            areaTriangulo.setBase(base);
                            areaTriangulo.setAltura(altura);
                            areaTriangulo.mostrar();
                        }
                    }
                    break;
                case '3':
                    double lado;
                    AreaCuadrado areaCuadrado;
                    lado=obtenerDatos("Longitud de un lado del cuadrado: ");
                    if(lado!=0){
                        areaCuadrado=new AreaCuadrado();
                        areaCuadrado.setLado(lado);
                        areaCuadrado.mostrar();
                    }
                    break;
                case '4':
                    break;
                default:
                    System.out.println("Error.. Opcion Inexistente");
                    break;
            }
        }while(opcion != '4');
    }
}