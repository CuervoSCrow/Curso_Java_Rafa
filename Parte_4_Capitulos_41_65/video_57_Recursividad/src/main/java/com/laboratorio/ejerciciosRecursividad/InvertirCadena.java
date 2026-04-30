package com.laboratorio.ejerciciosRecursividad;

public class InvertirCadena {
    Peticiones peticiones=new Peticiones();
    String cadena;
    String resultado;
    public InvertirCadena(){
        cadena =peticiones.dameCadena();
        System.out.println(cadena);
        resultado=invertir(cadena);
        System.out.println(resultado);
    }
    public String invertir(String cadena){
        if(cadena == null || cadena.length()<=1){
            return cadena;
        }
        char ultimoCaracter=cadena.charAt(cadena.length()-1);
        String resto=cadena.substring(0,cadena.length()-1);
        return ultimoCaracter+invertir(resto);
    }
    public String getCadena(){
        return cadena;
    }
    public String getResultado(){
        return resultado;
    }
}
