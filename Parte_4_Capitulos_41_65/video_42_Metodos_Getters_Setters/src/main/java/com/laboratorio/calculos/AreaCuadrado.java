package com.laboratorio.calculos;

public class AreaCuadrado {
    private double lado;
    private double area;

    public AreaCuadrado(){
        this.lado=0;
    }
    public AreaCuadrado(double lado){
        this.lado=lado;
    }
    private void leerDatos(){

    }
    private void calcular(){
        area=lado*lado;
    }
    public void mostrar(){
        leerDatos();
        calcular();
        System.out.println("El area del cuadrado es: "+area);
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }

    public double getArea() {
        return area;
    }
}
