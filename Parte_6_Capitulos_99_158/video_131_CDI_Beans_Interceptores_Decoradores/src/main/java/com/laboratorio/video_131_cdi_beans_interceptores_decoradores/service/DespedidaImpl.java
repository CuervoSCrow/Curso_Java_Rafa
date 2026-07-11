
package com.laboratorio.video_131_cdi_beans_interceptores_decoradores.service;

import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class DespedidaImpl implements Despedida{

    @Override
    public String despedirse() {
        return "Adios Amigos";
    }
    
}
