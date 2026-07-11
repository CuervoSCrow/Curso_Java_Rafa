
package com.laboratorio.video_131_cdi_beans_interceptores_decoradores.calificadores;

import jakarta.inject.Qualifier;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.*;

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({FIELD,METHOD,TYPE,PARAMETER})
public @interface HelloServiceQualifier1 {
    
}
