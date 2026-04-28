package com.laboratorio;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String valor;

        System.out.println("Dime el dia de la semana:(LUNES,MARTES,MIERCOLES,JUEVES,VIERNES,SABADO,DOMINGO) ");
        valor = entrada.nextLine().toUpperCase();
        DiaDeLaSemana dia = DiaDeLaSemana.valueOf(DiaDeLaSemana.class,valor);
        switch(dia){
            case LUNES:
            case MARTES:
            case MIERCOLES:
            case JUEVES:
            case VIERNES:
                System.out.println("Buenos dias!");
                break;
            case SABADO:
            case DOMINGO:
                System.out.println("Buen fín de semana!");
                break;
        }

        DiaSemana dia2 = DiaSemana.valueOf(DiaSemana.class,valor);
        System.out.println("Dia de semana: "+dia2);
        System.out.println("Abreviatura: "+dia2.getAbrev());

    }
}