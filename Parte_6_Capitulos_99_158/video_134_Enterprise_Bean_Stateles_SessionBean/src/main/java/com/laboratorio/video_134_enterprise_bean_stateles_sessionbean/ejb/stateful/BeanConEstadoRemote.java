
package com.laboratorio.video_134_enterprise_bean_stateles_sessionbean.ejb.stateful;

import jakarta.ejb.Remote;
import java.util.List;

@Remote
public interface BeanConEstadoRemote {
    String agregar(Integer valor);
    
    public List<Integer> getValores();
}
