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

public class DashboardServlet extends HttpServlet {

        
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false);
        String ususario = (String) session.getAttribute("usuario");
        
        request.setAttribute("usuario",ususario);
        request.getRequestDispatcher("/dashboard.jsp").forward(request, response);
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        Cerrar  session
        HttpSession session = request.getSession(false);
        if(session!=null){
            session.invalidate();
        }
        response.sendRedirect(request.getContextPath()+"/login");
    }    
}
