package com.laboratorio.banco;

public class AtencionTelefonica implements ServiciosBanco{
    @Override
    public void consultarSaldo() {
        System.out.println("Consultar saldo desde atencion telefonica");
    }

    @Override
    public void ultimosMovimientos() {
        System.out.println("Consultar ultimos movimientos desde atencion telefonica");
    }

    @Override
    public void transferirSaldo() {
        System.out.println("Transferir saldo desde atencion telefonica");
    }
}
