
package com.laboratorio.miappfilter.filtros;


import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;


public class LoggingFilter implements Filter    {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Logging Filter");
    }

    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
        
        HttpServletRequest httpRequest = (HttpServletRequest) sr;
        
//  Obtener la información de la petición
        String ipAdress = httpRequest.getRemoteAddr();
        String url = httpRequest.getRequestURL().toString();
        String metodo = httpRequest.getMethod();
        Date fecha = new Date();
        
        //Log de Petición
        System.out.println("["+fecha+"]"+metodo+" "+url+
                " - IP: "+ipAdress);
        
        //Continuar con la cadena de filtros
        fc.doFilter(sr,sr1);
        
        //Log despues de procesar la petición
        System.out.println("["+fecha+"] Petición completa");
    }

    @Override
    public void destroy() {
        System.out.println("LoggingFilter destruido ");
    }    
    
}
