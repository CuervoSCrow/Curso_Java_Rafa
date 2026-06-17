
package com.laboratorio.video_110_desarrollo_web_11_modelo_vita_controlador_mvc.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.laboratorio.video_110_desarrollo_web_11_modelo_vita_controlador_mvc.modelo.Alumno;
import com.laboratorio.video_110_desarrollo_web_11_modelo_vita_controlador_mvc.modelo.AlumnoDB;
import jakarta.servlet.RequestDispatcher;
import java.util.List;


@WebServlet(name = "AlumnoController", urlPatterns = {"/alumnos"})
public class AlumnoController extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        AlumnoDB alumnoDB = new AlumnoDB();
        List<Alumno> lista = alumnoDB.obtenerAlumnos();
        
        request.setAttribute("alumnos", lista);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/listaAlumnos.jsp");
        dispatcher.forward(request, response);
        
    }  

}
