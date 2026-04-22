package com.laboratorio.empleados;

public class Mecanico extends Empleado {

    private double concepto1,concepto2,concepto3;

    @Override
    public double salario() {
        concepto1 =3;
        concepto2 =5;
        concepto3 =7;
        return concepto1+concepto2+concepto3;
    }
}
