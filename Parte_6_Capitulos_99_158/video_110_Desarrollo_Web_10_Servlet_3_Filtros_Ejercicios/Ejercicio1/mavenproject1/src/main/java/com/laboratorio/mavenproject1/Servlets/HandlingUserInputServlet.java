/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.laboratorio.mavenproject1.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 *
 * @author canzervero
 */
@WebServlet(name = "HandlingUserInputServlet", urlPatterns = {"/HandlingUserInputServlet"})
public class HandlingUserInputServlet extends HttpServlet {

    private static final long serialVersionUID=1L;
        
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Map<String, String[]> params = request.getParameterMap();
        
        System.out.println("Print GET parameters.");
        
        for(String key : params.keySet()){
            System.out.println(key+" => "+String.join(", ",params.get(key)));
        }   
    }    
    
    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException{
        Map<String,String[]> params = request.getParameterMap();
        
        System.out.println("Print POST parametes.");
        
        for(String key : params.keySet()){
            System.out.println(key+" => "+String.join(", ", params.get(key)));
        }
    }
}
