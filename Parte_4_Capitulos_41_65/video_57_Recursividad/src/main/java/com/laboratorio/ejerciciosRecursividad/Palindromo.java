package com.laboratorio.ejerciciosRecursividad;

public class Palindromo {
    private String cadena;
    private String cadenaInvertida;
    private Peticiones peticiones;
    private InvertirCadena invertirCadena;

    public Palindromo() {
        peticiones = new Peticiones();
        invertirCadena = new InvertirCadena();
        cadena = invertirCadena.getCadena();
        cadenaInvertida = invertirCadena.getResultado();

        String cadenaLimpia = cadena
                .toLowerCase()
                .replaceAll("\\s+", "");
        String cadenaInvertidaLimpia = cadenaInvertida
                .toLowerCase()
                .replaceAll("\\s+", "");

        if(cadenaLimpia.equals(cadenaInvertidaLimpia)){
            System.out.println("La cadena es un palíndromo");
        }else{
            System.out.println("La cadena no es un palíndromo");
        }



    }
}
