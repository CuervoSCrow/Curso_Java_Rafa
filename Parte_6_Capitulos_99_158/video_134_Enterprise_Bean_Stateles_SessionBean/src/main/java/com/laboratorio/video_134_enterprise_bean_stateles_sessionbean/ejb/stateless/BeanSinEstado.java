
package com.laboratorio.video_134_enterprise_bean_stateles_sessionbean.ejb.stateless;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ejb.Stateless;
import jakarta.ejb.LocalBean;

@Stateless
@LocalBean
public class BeanSinEstado {
    private int valor;
    
    @PostConstruct
    public void inicializacion(){
        this.valor = 0;
        System.out.println("Se ha creado bean sin estado: " +this.toString());
    }
    
    public String incrementar()throws Exception{
        this.valor++;
        String str ="Mi valor actual es: "+this.valor;
        Thread.sleep(2000);
        return str;               
    }
    
    @PreDestroy
    public void liberacion(){
        System.out.println("Se ha destruido el bean sin estado: "+this.toString());
    }
}
