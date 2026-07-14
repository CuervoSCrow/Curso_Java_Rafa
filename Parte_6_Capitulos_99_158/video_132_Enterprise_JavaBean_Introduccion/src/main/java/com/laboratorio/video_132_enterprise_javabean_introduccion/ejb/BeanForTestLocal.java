
package com.laboratorio.video_132_enterprise_javabean_introduccion.ejb;

import jakarta.ejb.Local;

@Local
public interface BeanForTestLocal {
    String localFunction();
}
