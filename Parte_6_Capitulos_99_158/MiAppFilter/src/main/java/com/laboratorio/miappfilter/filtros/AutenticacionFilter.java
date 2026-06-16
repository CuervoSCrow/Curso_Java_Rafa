package com.laboratorio.miappfilter.filtros;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;


public class AutenticacionFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("AutenticaciónFilter Iniciado");
    }

    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, jakarta.servlet.ServletException {
        
        HttpServletRequest httpRequest = (HttpServletRequest) sr;
        HttpServletResponse httpResponse = (HttpServletResponse) sr1;
        
        String uri =httpRequest.getRequestURI();
//        Permiti r acceso sin autenticación a
//          - Pagina de Login
//          -Servlet login
//          -Recursos estáticos (CSS,JS, imágenes
//          -Pagina Bienvenida (login.jsp)
        if(uri.contains("/login")||
           uri.endsWith(".jsp")||
           uri.endsWith(".css")||
           uri.endsWith(".js")||
           uri.equals("/MiAppFilter-1.0-SNAPSHOT/")){// Permitir raíz
            fc.doFilter(sr, sr1);
            return;            
        }
        
        //        Verificar si el usuario está autenticado
        HttpSession session = (HttpSession) httpRequest.getSession(false);
        boolean isLoggedIn=(session!=null && session.getAttribute("usuario")!=null);
        
//        Obtener la URL solicitada
        String loginURI = httpRequest.getContextPath()+"/login";
        String requestURI = httpRequest.getRequestURI();
        
        if(isLoggedIn || requestURI.equals(loginURI)||requestURI.contains("/login.jsp")){
            fc.doFilter(sr, sr1);
        }else{
//            No autenticado redirijir al Login
            httpResponse.sendRedirect(loginURI);
        }
    }

    @Override
    public void destroy() {
        System.out.println("AutenticacionFilter Destruido");
    }    
    
}
