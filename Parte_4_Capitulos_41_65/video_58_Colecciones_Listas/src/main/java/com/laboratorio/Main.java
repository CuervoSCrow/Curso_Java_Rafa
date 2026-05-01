package com.laboratorio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void insertar_masivo(List lista, int elem){
        int i =0;
        Persona persona;
        String nombre, apellido, dni;
        long tiempo1, tiempo2;
        tiempo1 = System.currentTimeMillis();
        for(i=0;i<elem;i++){
            nombre = "nombre "+(i+1);
            apellido = "apellido "+(i+1);
            dni = "dni "+(i+1);
            persona=new Persona(nombre, apellido, dni);
            lista.add(persona);
        }
        tiempo2 = System.currentTimeMillis();
        System.out.println("Tiempo de insercion: "+(tiempo2-tiempo1));
    }
    public static void consulta(List lista, int nElem){
        long t1,t2,diferencia;
        t1=System.currentTimeMillis();
        Persona persona = (Persona)lista.get(nElem);
        persona.escribir();
        t2 = System.currentTimeMillis();
        diferencia=t2-t1;
        System.out.println("Tiempo de consulta: "+diferencia);
    }
    public static void insertar(List lista, int nElem,Persona persona){
        long t1,t2,diferencia;
        t1=System.currentTimeMillis();
        lista.add(nElem, persona);
        t2 = System.currentTimeMillis();
        diferencia=t2-t1;
        System.out.println("Tiempo de insercion: "+diferencia);
    }
    public static void eliminar(List lista, int nElem){
        long t1,t2,diferencia;
        t1=System.currentTimeMillis();
        lista.remove(nElem);
        t2 = System.currentTimeMillis();
        diferencia=t2-t1;
        System.out.println("Tiempo de eliminacion: "+diferencia);
    }
    public static void listado1(List lista){
        Persona persona;
        for(int i=0;i<lista.size();i++){
            persona = (Persona)lista.get(i);
            persona.escribir();
        }
    }
    public static void listado2(List<Persona> lista){
        for(Persona persona : lista){
            persona.escribir();
        }
    }
    public static void listado3(List<Persona> lista){
        Persona persona;
        Iterator<Persona> iterator = lista.iterator();
        while(iterator.hasNext()){
            persona = iterator.next();
            persona.escribir();
        }
    }
    public static void main(String[] args) {
        System.out.println("Insercion con ArrayList");
        List<Persona> lista1 = new ArrayList<>(10);
        insertar_masivo(lista1, 10);
//        System.out.println("Inserccion con ArrayList definida: ");
//        List<Persona> l1 = new ArrayList<>(1000000);
//        insertar_masivo(l1, 1000000);
//        System.out.println("Inserccion con LinkedList: ");
//        List<Persona> l2 = new LinkedList<>();
//        insertar_masivo(l2, 1000000);
//
//        System.out.println("Consultas");
//
//        consulta(lista1,500000);
//        consulta(l1,500000);
//        consulta(l2,500000);
//
//        System.out.println("Inserccion");
//
//        Persona p1 = new Persona("n1","a1","i1");
//        insertar(lista1,500000,p1);
//        insertar(l1,500000,p1);
//        insertar(l2,500000,p1);
//
//        System.out.println("Eliminacion");
//        eliminar(lista1,500000);
//        eliminar(l1,500000);
//        eliminar(l2,500000);

        System.out.println("Listado 1");
        listado1(lista1);
        System.out.println("Listado 2");
        listado2(lista1);
        System.out.println("Listado 3");
        listado3(lista1);
    }
}