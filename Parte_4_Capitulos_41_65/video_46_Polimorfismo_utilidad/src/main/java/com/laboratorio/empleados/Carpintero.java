package com.laboratorio.empleados;

public class Carpintero extends  Empleado{
    private double concepto1,concepto2,concepto3,concepto4,concepto5;

    @Override
    public double salario() {
        concepto1 = 4;
        concepto2 = 2;
        concepto3 = 8;
        concepto4 = 5;
        concepto5 = 3;
        return concepto1+concepto2+concepto3+concepto4+concepto5;
    }
}
