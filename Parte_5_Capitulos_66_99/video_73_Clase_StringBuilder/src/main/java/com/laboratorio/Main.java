package com.laboratorio;
public class Main {
    public static void main(String[] args) {
        String str;

        str ="Hola ";
        str+="desde "+"el ";
        str+="Laboratorio " +"de Cuervo";
        System.out.println(str);

        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("Hola ")
                .append("desde ");
        strBuilder.append("el ")
                .append("laboratorio ")
                .append("de ")
                .append("cuervo");
        System.out.println(strBuilder.toString());

        int i;
        long inicio= System.nanoTime();
        StringBuilder stringBuilder2 = new StringBuilder();
        for(i=0;i<1000;i++){
            stringBuilder2.append(i);
        }
        long fin=System.nanoTime();
        double dif1=fin-inicio;
        System.out.println("Tiempo con StringBuilder: "+(fin-inicio));

        inicio = System.nanoTime();
        String str2="";
        for(i=0;i<1000;i++){
            str+=i;
        }
        fin=System.nanoTime();
        double dif2 = fin-inicio;
        System.out.println("Tiempo con String: "+(fin-inicio));

        System.out.println("Proporcion: "+(dif2/dif1));

    }


}