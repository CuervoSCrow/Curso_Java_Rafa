
package com.laboratorio.video_134_enterprise_bean_stateles_sessionbean.ejb;

import jakarta.ejb.Remote;

@Remote
public interface BeanForTestRemote {
    String remoteFunction();
}
