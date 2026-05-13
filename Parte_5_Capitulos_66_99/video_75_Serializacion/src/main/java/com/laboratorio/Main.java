package com.laboratorio;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona("Pedro","Perez",20,5);
        System.out.println(persona1.toString());
        System.out.println("Dato: "+persona1.getDato());
//
        boolean result = serializarPersona(persona1);
//        boolean result=true;
        if(result){
            Persona persona2= deserializarPersona();
            if(persona2!=null){
                System.out.println(persona2.toString());
                System.out.println(persona2.getDato());
            }
        }
    }
    public static boolean serializarPersona(Persona persona){
        try{
            FileOutputStream file= new FileOutputStream("persona.dat");
            ObjectOutputStream objectOut = new ObjectOutputStream(file);
            objectOut.writeObject(persona);
            objectOut.close();
            file.close();
        }catch(IOException e){
            System.out.println("Se ha presentado un error al serializar una persona");
            return false;
        }
        return true;
    }

    public static Persona deserializarPersona(){
        Persona persona=null;
        try{
            FileInputStream file = new FileInputStream("persona.dat");
            ObjectInputStream objectIn = new ObjectInputStream(file);
            persona = (Persona) objectIn.readObject();
            objectIn.close();
            file.close();
        }catch(IOException | ClassNotFoundException e){
            System.out.println("Se ha presentado un error al deserializar una persona");
            return null;
        }
        return persona;
    }
}