package com.laboratorio.ejerciciosRecursividad;

public class Fibonacci {
    Peticiones peticiones= new Peticiones();
    private int numero, i, resultado;
    public Fibonacci(){
        System.out.println("Serie Fibonacci, " +
                "indique el numero de elementos dela serie: ");
        numero = peticiones.dameEnteroPositivo();
        resultado=fibo(numero);
        mostrarFibo();
    }
    private int fibo(int n){
        if(n==0||n==1){
            return n;
        }else{
            return fibo(n-1)+fibo(n-2);
        }
    }
    public void mostrarFibo(){
        for(i=0;i<numero;i++){
            System.out.print(fibo(i)+", ");
        }
        System.out.println();
    }
    public int getResultado(){
        return resultado;
    }
}
