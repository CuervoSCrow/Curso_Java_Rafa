
package com.laboratorio.mavenproject1.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(name = "SimpleServlet", urlPatterns = {"/SimpleServlet"})
public class SimpleServlet extends HttpServlet {

    private static final long serialVersionUID=1L;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       response.getWriter().append("Hola en SimpleServlet");
    }

    

}
