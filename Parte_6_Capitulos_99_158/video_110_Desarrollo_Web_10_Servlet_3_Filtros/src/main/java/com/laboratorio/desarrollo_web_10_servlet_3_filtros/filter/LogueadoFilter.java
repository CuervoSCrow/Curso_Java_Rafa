
package com.laboratorio.desarrollo_web_10_servlet_3_filtros.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("*.do")
public class LogueadoFilter implements Filter{
    
    private FilterConfig filterConfig =null;
    
    @Override
    public void init(FilterConfig filterConfig){
        this.filterConfig=filterConfig;
    }

    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
        log("He entrado al filtro LogueadoFilter");
        
        HttpServletRequest request=(HttpServletRequest) sr;
        String usuario = (String)request.getSession().getAttribute("usuario");
        
        log("Valor usuario: "+usuario);
        
        if (usuario != null && !usuario.isEmpty()) {
            fc.doFilter(sr, sr1);
        }else{
            HttpServletResponse response = (HttpServletResponse) sr1;
            response.sendRedirect("index.jsp?error=Debe estar logeado para ver este contenido");
        }
    }
    
    public void log(String msg){
        filterConfig.getServletContext().log(msg);
    }
    
}
