
package com.laboratorio.video_138_enterprise_javabean_uniendo_componentes_jse_jee_1.productor;

import jakarta.ejb.Remote;

@Remote
public interface ProductorJMSBeanRemote {
    void enviarPersona(String personaJson);
}
