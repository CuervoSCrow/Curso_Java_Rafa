package com.laboratorio.banco;

public class CajeroAutomatico implements ServiciosBanco{

    @Override
    public void consultarSaldo() {
        System.out.println("Consultar saldo desde cajero automatico");
    }

    @Override
    public void ultimosMovimientos() {
        System.out.println("Consultar ultimos movimientos desde cajero automatico");
    }

    @Override
    public void transferirSaldo() {
        System.out.println("Transferir saldo desde cajero automatico");
    }
}
