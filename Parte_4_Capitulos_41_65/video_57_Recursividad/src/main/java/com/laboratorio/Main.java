package com.laboratorio;


import java.util.Scanner;

public class Main {

    public static int factorial(int n){
        if(n==1|| n ==0){
            return 1;
        }
        else{
            return n * factorial(n-1);
        }

    }
    public static int  dameEnteroPositivo(){
        Scanner entrada = new Scanner(System.in);
        int numero;
        try {
            System.out.print("Dime un numero entero: ");
            numero = entrada.nextInt();
        }catch(Exception ex){
            System.out.println("");
            System.out.println("El numero debe ser entero");
            return -1;
        }
        if(numero<0){
            System.out.println("El numero debe ser >= 0");
            return -1;
        }
        return numero;
    }
    public static int fibonacci(int n){
        if(n==0||n==1){
            return n;
        }else{
            return fibonacci(n-1)+fibonacci(n-2);
        }

    }
    public static void main(String[] args) {
        int numero,resultado,i;

        System.out.println("Calculo del factorial");
        do{
            numero = dameEnteroPositivo();

        }while(numero==-1);

        resultado= factorial(numero);
        System.out.println("Resultado = "+resultado);
        System.out.println();
        System.out.println();
        System.out.println("Serie Fibonacci, indique el numero de elementos dela serie: ");

        do{
            numero =dameEnteroPositivo();

        }while(numero==-1);
        System.out.println();
        for(i=0;i<=numero;i++){
            resultado = fibonacci(i);
            System.out.print(resultado);
            if(i<numero){
                System.out.print(", ");
            }
        }
    }
}