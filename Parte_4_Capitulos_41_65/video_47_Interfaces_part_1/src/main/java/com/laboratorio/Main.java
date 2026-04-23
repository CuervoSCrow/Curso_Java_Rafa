package com.laboratorio;

import com.laboratorio.banco.AtencionTelefonica;
import com.laboratorio.banco.CajeroAutomatico;
import com.laboratorio.banco.WebSite;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        CajeroAutomatico cajero = new CajeroAutomatico();
        cajero.consultarSaldo();
        cajero.ultimosMovimientos();
        cajero.transferirSaldo();

        AtencionTelefonica telefono = new AtencionTelefonica();
        telefono.consultarSaldo();
        telefono.ultimosMovimientos();
        telefono.transferirSaldo();

        WebSite webSite = new WebSite();
        webSite.consultarSaldo();
        webSite.ultimosMovimientos();
        webSite.transferirSaldo();
    }
}