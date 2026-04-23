package com.laboratorio.banco;

public class WebSite implements ServiciosBanco{
    @Override
    public void consultarSaldo() {
        System.out.println("Consultar saldo desde web site");
    }

    @Override
    public void ultimosMovimientos() {
        System.out.println("Consultar ultimos movimientos desde web site");
    }

    @Override
    public void transferirSaldo() {
        System.out.println("Transferir saldo desde web site");
    }
}
