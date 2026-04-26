package com.laboratorio;

public class Calculadora {
    private double v3;

    public Calculadora(double v3) {
        this.v3 = v3;
    }
    public double getNumero(){
        return v3*5;
    }

    public static double suma(double v1, double v2){
        return v1+v2;
    }
    public static double  resta(double v1, double v2){
        return v1-v2;
    }
    public static double multiplicacion(double v1, double v2){
        return v1*v2;
    }
    public static double division(double v1, double v2){
        return v1/v2;
    }
}
