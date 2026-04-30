package com.laboratorio.ejerciciosRecursividad;
public class ContarDigitos {
    private Peticiones peticiones=new Peticiones();
    private int numero;
    private int resultado;
    public ContarDigitos(){
        numero = peticiones.dameEnteroPositivo();
        resultado = contarDigitos(numero);
        mostrarResultado();

    }
    public int  contarDigitos(int numero){
        if(numero<10){
            resultado = 1;
        }else{
            resultado = 1 + contarDigitos(numero/10);
        }
        return resultado;
    }
    public void mostrarResultado(){
        System.out.println("El numero de digitos de " + numero + " es: " + resultado);
    }
    public int getResultado(){
        return resultado;
    }
    public int getNumero(){
        return numero;
    }
    public void setNumero(int numero){
        this.numero = numero;
    }
    public void setResultado(int resultado){
        this.resultado = resultado;
    }
}
