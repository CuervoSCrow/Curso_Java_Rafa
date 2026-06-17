/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.laboratorio.miappfilter.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



public class LoginServlet extends HttpServlet {

       
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        Mostrar la pagina del login
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        
//        Validació simple(en producción usar base de datos)
        if("admin".equals(usuario) && "1234".equals(password)){
//            Crea session
            HttpSession session = (HttpSession) request.getSession();
            session.setAttribute("usuario", usuario);
            session.setMaxInactiveInterval(30*60);// 30 minutos
            
//            Redirigir al dashboard
            response.sendRedirect(request.getContextPath()+"/dashboard");
        }else{
//            Error en la autenticación
            request.setAttribute("error", "Usuario o contraseña incorrectos");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }


}
