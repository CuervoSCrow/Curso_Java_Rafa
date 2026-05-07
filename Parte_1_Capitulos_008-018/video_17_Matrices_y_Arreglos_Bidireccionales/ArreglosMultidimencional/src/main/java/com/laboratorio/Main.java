package com.laboratorio;

public class Main {
    public static void main(String[] args) {

    }
    public static void arreglosMultidimencionales() {
        int[] values={12,8,15,3,9,21};
        int sum=0;
        int max=values[0];
        int min=values[0];

//        Calcula suma, max , min
        for (int value:values){
            sum+=value;
            if(value>max) max=value;
            if(value<min) min=value;
        }

    }
}