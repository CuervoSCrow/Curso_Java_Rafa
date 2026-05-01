package com.laboratorio.ejerciciosRecursividad;

public class TorresDeHanoi {

    public TorresDeHanoi() {
        int n = 3;
        System.out.println("=== Torres de Hanói con "+n+" discos ===");
        System.out.println("Movimientos a realizar: ");
        resolverHanoi(n, "A", "B", "C");
        System.out.println("Numero minimo de movimientos: "+contarMovimientos(n));
        System.out.println("Fórmula: 2^" + n + " - 1 = " + (Math.pow(2, n) - 1));
    }
    public void resolverHanoi(int n, String origen, String aux, String destino) {
//        Caso base si solo hay uno
        if(n==1){
            System.out.println("Mover disco 1 desde "+origen+" a "+destino);
            return ;
        }
//        Paso 1 mover n-1 discos de A a B(usando C como auxiliar)
        resolverHanoi(n-1, origen, destino, aux);

//        Paso 2 mover el disco n de A a C
        System.out.println("Mover disco "+n+" desde "+origen+" a "+destino);

//        Paso 3 mover n-1 discos de B a C(usando A como auxiliar)
        resolverHanoi(n-1, aux, origen, destino);
    }

//    Metodo para contar el numero minimo de movimientos
    public int contarMovimientos(int n) {
        if(n == 1){
            return 1;
        }
        return 2 * contarMovimientos(n - 1) + 1;
    }

}
