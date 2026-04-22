package com.laboratorio.empleados;

public class Electricista extends Empleado{
    private  double concepto1,concepto2,concepto3,concepto4;

    @Override
    public double salario() {
        concepto1 = 2;
        concepto2 = 3;
        concepto3 = 8;
        concepto4 = 5;
        return concepto1+concepto2+concepto3+concepto4;
    }
}
