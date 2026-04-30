package com.laboratorio.ejerciciosRecursividad;

public class Potencia {
    Peticiones peticiones=new Peticiones();
    int base;
    int exponente;
    int resultado;

    public Potencia(){
        System.out.println("Ingresa la base. ");
        base=peticiones.dameEnteroPositivo();
        System.out.println("Ingresa el exponente. ");
        exponente=peticiones.dameEnteroPositivo();
        resultado=potencia(exponente,base);
        System.out.println("El resultado es: "+resultado);
    }
    public int potencia(int exponente,int base){
        if(exponente==0){
            return 1;
        }else{
            return base * potencia(exponente-1,base);
        }
    }





}
