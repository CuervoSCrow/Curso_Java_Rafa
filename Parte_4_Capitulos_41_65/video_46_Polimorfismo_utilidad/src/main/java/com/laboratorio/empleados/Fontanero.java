package com.laboratorio.empleados;

public class Fontanero extends Empleado{
    private double concepto1,concepto2;

    @Override
    public double salario() {
        concepto1 = 11;
        concepto2 = 8;
        return concepto1+concepto2;
    }
}
