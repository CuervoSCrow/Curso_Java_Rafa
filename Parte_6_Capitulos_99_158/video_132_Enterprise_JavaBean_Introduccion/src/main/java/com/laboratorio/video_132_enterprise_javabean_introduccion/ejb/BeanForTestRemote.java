
package com.laboratorio.video_132_enterprise_javabean_introduccion.ejb;

import jakarta.ejb.Remote;

@Remote
public interface BeanForTestRemote {
    String remoteFunction();
    
}
