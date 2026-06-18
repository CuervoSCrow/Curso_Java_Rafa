
package com.laboratorio.video_111_desarrollo_web_12_pool_conexiones_bd.controlador;

import com.laboratorio.video_111_desarrollo_web_12_pool_conexiones_bd.modelo.Alumno;
import com.laboratorio.video_111_desarrollo_web_12_pool_conexiones_bd.modelo.AlumnoDB;
import com.laboratorio.video_111_desarrollo_web_12_pool_conexiones_bd.persistencia.ConnectionPoolManager;
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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "AlumnoController", urlPatterns = {"/alumnos"})
public class AlumnoController extends HttpServlet {  
    private static final Logger log = Logger.getLogger(AlumnoController.class.getName());
   
    private Connection connection = null;
    
    public void init(){
         log.log(Level.INFO,"Iniciando pool de conexiones");
        try{
            connection=ConnectionPoolManager.getConnection();
        }catch(SQLException e){
            log.log(Level.SEVERE,"Error Obteniendo conexion a la base de datos !");
            connection = null;
            return;
        }
        
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        AlumnoDB alumnoDB = new AlumnoDB();
        List<Alumno> lista = alumnoDB.obtenerAlumnos();
        
        request.setAttribute("alumnos", lista);
        
        if(connection!=null){
            request.setAttribute("conexion", "Conexion establecida");
        }else{
            request.setAttribute("conexion", "Error de conexion de base de datos");
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/listaAlumnos.jsp");
        dispatcher.forward(request, response);
    
    }

}
