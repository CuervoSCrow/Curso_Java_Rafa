package com.laboratorio.calculos;

public class AreaRectangulo {
    private double base;
    private double altura;
    private double area;

    public AreaRectangulo() {
        this.base=0;
        this.altura=0;
    }

    public AreaRectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public void mostrar(){
        calcular();
        System.out.println("El area del rectangulo es: "+area);
    }
    private void calcular(){
        area=base*altura;
    }
    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getArea() {
        return area;
    }

}
