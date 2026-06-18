/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.laboratorio.video_112_desarrollo_web_crud_1_controlador.controlador;

import com.laboratorio.video_112_desarrollo_web_crud_1_controlador.modelo.Persona;
import com.laboratorio.video_112_desarrollo_web_crud_1_controlador.modelo.PersonaDB;
import com.laboratorio.video_112_desarrollo_web_crud_1_controlador.persistencia.ConnectionPoolManager;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author canzervero
 */
@WebServlet(name = "PersonasController", urlPatterns = {"/PersonasController"})
public class PersonasController extends HttpServlet {

    private static final Logger log = Logger.getLogger(PersonasController.class.getName());
    private Connection connection=null;
    private PersonaDB personaDB;
    
    @Override
    public void init(){
        log.log(Level.INFO,"Obteniendo conexion a la base de datos");
        try{
            connection=ConnectionPoolManager.getConnection();          
        }catch(SQLException ex){
            log.log(Level.SEVERE,"Error Obteniendo conexion a base de datos!");
            connection = null;
            return;
        }
        log.log(Level.INFO,"Conexion realizada");
        
        personaDB = new PersonaDB(connection);
    }
    
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PersonasController</title>");
            out.println("</head>");
            out.println("<body>");
            
            try{
                List<Persona> personas = personaDB.getPersonas();
                out.println("<h2>Lista de Personas</h2>");
                out.println("<ul>");
                for(Persona persona : personas){
                    out.println("<li>");
                    out.println(persona.getNombre());
                    out.println(" ");
                    out.println(persona.getApellidos());
                    out.println("</li>");
                }
                out.println("</ul>");
                
            }catch(Exception e){
               out.println("<h2>Error al obtener la lista de personas</h2>");
            }
            out.println("<h1>Servlet PersonasController at " + request.getContextPath() + "</h1>");
            
            
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
