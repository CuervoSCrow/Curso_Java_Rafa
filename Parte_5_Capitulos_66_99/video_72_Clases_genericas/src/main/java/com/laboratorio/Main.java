package com.laboratorio;

public class Main {
    public static void main(String[] args) {
        ListaGenerica<String> lista = new ListaGenerica<>(10);

        int i;

        for(i=0;i<15;i++){
            lista.agregar("elemento"+(i+1));
        }

        System.out.println("Tamaño de la lista: " + lista.nElementosLista());

        String elem0 = lista.obtener(-1);
        String elem1 = lista.obtener(0);
        String elem3 = lista.obtener(2);
        String elem5 = lista.obtener(4);
        String elem10 = lista.obtener(10);

        if(elem0!=null){
            System.out.println("Elemento 0: "+elem0);
        }
        System.out.println("Elemento 1: "+elem1);
        System.out.println("Elemento 3: "+elem3);
        System.out.println("Elemento 5: "+elem5);
        if(elem10!=null){
            System.out.println("Elemento 10: "+elem10);
        }


    }
}