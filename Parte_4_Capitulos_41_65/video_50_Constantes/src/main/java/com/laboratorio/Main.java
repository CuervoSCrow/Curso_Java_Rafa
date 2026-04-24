package com.laboratorio;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Madre1  madre1;
        Hija1 hija1;
        Madre2 madre2;
        Hija2 hija2;

        madre1 = new Madre1("Valor1");
        hija1 = new Hija1("Valor 2");
        madre1.mostrar();
        hija1.mostrar();

        System.out.println("====================================");
        madre2 = new Madre2("Valor 3");
        hija2 = new Hija2("Valor 4","Valor 5");

        madre2.mostrar();
        hija2.mostrar(2);
    }
}