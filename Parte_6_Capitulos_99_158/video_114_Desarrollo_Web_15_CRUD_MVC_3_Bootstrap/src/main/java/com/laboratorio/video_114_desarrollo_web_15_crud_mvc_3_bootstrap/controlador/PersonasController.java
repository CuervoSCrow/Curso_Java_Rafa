
package com.laboratorio.video_114_desarrollo_web_15_crud_mvc_3_bootstrap.controlador;

import com.laboratorio.video_114_desarrollo_web_15_crud_mvc_3_bootstrap.modelo.Persona;
import com.laboratorio.video_114_desarrollo_web_15_crud_mvc_3_bootstrap.modelo.PersonaDB;
import com.laboratorio.video_114_desarrollo_web_15_crud_mvc_3_bootstrap.persistencia.ConnectionPoolManager;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


@WebServlet(name = "PersonasController", urlPatterns = {"/PersonasController"})
public class PersonasController extends HttpServlet {
    
    private static final Logger log = Logger.getLogger(PersonasController.class.getName());
    private Connection connection= null;
    private PersonaDB personaDB;
    
    @Override
    public void init(){
        log.log(Level.INFO,"Obteniendo conexion a la base de datos...");
        try{
            connection= ConnectionPoolManager.getConnection();
        }catch(SQLException e){
            log.log(Level.SEVERE,"Error Obteniendo conexion a la base de datos.");
            connection = null;
            return;
        }
        log.log(Level.INFO,"Conexion realizada");
        personaDB=new PersonaDB(connection);
    }
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String accion = request.getParameter("accion");
        
        if(accion==null){
            accion="N/A";
        }
        log.log(Level.INFO,"Se esta ejecutando el Servlet. Accion: "+accion);
        
        switch(accion){
            case "agregar":
                crearPersona(request,response);
                break;
            case "listar":
            default:
                listarPersonas(request,response);  
                break;
                            
        }
        
        
    }
    
    private void listarPersonas(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        
        List<Persona> personas;

        try {
            personas = personaDB.getPersonas();
        } catch (SQLException e) {
            log.log(Level.SEVERE, "Error recuperando la lista de personas.");
            personas = new ArrayList<>();
        }

        request.setAttribute("lista_personas", personas);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/personas.jsp");
        dispatcher.forward(request, response);
    }
    
     private void crearPersona(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        
         Persona persona = new Persona();
         
         request.setAttribute("persona", persona);
          
        RequestDispatcher dispatcher = request.getRequestDispatcher("/formularioPersona.jsp");
        dispatcher.forward(request, response);
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
