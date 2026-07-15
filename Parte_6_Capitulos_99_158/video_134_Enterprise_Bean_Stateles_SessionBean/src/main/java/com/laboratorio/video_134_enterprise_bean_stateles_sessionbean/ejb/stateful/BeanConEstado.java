
package com.laboratorio.video_134_enterprise_bean_stateles_sessionbean.ejb.stateful;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ejb.Stateful;
import jakarta.ejb.LocalBean;
import java.util.ArrayList;
import java.util.List;

@Stateful
@LocalBean
public class BeanConEstado implements BeanConEstadoRemote{
    private List<Integer> valores;
    
    
    @PostConstruct
    public void inicializar(){
        System.out.println("inicializando el bean con estado: "+this.toString());
        
        this.valores = new ArrayList<>();
    }
    
    @Override
    public String agregar(Integer valor){
        this.valores.add(valor);
        return "Agregado el valor: "+valor;
    }
    
    @Override
    public List<Integer> getValores(){
        return this.valores;
    }
    
    @PreDestroy
    public void finalizar(){
        System.out.println("Finalizando el bean con estado: "+this.toString());
    }
}
