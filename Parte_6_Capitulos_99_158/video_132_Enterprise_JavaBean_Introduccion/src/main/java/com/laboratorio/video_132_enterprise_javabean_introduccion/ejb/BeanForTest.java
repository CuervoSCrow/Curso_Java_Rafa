
package com.laboratorio.video_132_enterprise_javabean_introduccion.ejb;

import jakarta.ejb.Stateless;

@Stateless
public class BeanForTest implements BeanForTestLocal,BeanForTestRemote{

    @Override
    public String localFunction() {
        return "Texto que proviene de la función local.";
    }

    @Override
    public String remoteFunction() {
        return "Texto que proviene de la función Remota.";
    }
    
    
}
