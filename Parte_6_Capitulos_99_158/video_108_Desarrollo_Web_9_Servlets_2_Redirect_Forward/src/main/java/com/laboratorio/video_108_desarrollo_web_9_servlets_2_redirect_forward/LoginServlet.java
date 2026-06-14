/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.laboratorio.video_108_desarrollo_web_9_servlets_2_redirect_forward;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author canzervero
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
        
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usuario = request.getParameter("usuario");
        if(usuario==null || usuario.isEmpty()){
            response.sendRedirect("index.jsp?error=Debe suministrar un nombre de usuario!");
        }
        String clave= request.getParameter("clave");
        if(clave.equals("1234")){
            request.setAttribute("rol", "Operador");
            RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/sistema.jsp");
            dispatcher.forward(request, response);            
        }else{
            if(clave.equals("12345")){
                request.setAttribute("rol", "Administrador");
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/sistema.jsp");
                dispatcher.forward(request, response);
            }else{
                response.sendRedirect("index.jsp?error=Nombre de usuario o clave incorrecta!");
            }
        }
    }        

}
