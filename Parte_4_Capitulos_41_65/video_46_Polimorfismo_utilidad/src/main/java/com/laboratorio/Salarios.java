package com.laboratorio;

import com.laboratorio.empleados.*;

public class Salarios {
    public static void main(String[] args) {
        Empleado plantilla[] = new Empleado[10];

        plantilla[0] = new Carpintero();
        plantilla[1] = new Mecanico();
        plantilla[2] = new Electricista();
        plantilla[3] = new Electricista();
        plantilla[4] = new Fontanero();
        plantilla[5] =new Fontanero();
        plantilla[6] = new Carpintero();
        plantilla[7] = new Mecanico();
        plantilla[8] = new Electricista();
        plantilla[9] = new Fontanero();

        int i;
        double promedio=0;

        for (i=0;i<10;i++){
            promedio += plantilla[i].salario();
        }
        promedio /= 10;
        System.out.println("El salario Promedio es: " + promedio);
    }
}