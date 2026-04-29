package com.laboratorio.ejerciciosRecursividad;

public class Factorial {
    Peticiones peticiones=new Peticiones();
    private int numero, resultado;
    public Factorial(){
        System.out.println("Calculo del factorial");
        numero = peticiones.dameEnteroPositivo();
        resultado = factorial(numero);
        mostrarFactorial();
    }
    public int factorial(int n){
        if(n==1 || n==0){
            return 1;
        }else{
            return n*factorial(n-1);
        }
    }
    public void mostrarFactorial(){
        System.out.println("El factorial de " + numero + " es: " + resultado);
    }
    public int getResultado(){
        return resultado;
    }
}
