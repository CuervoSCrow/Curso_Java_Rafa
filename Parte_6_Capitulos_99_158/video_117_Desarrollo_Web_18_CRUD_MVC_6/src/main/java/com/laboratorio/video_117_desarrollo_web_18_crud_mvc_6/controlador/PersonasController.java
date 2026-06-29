
package com.laboratorio.video_117_desarrollo_web_18_crud_mvc_6.controlador;



import com.laboratorio.video_117_desarrollo_web_18_crud_mvc_6.modelo.Persona;
import com.laboratorio.video_117_desarrollo_web_18_crud_mvc_6.modelo.PersonaDB;
import com.laboratorio.video_117_desarrollo_web_18_crud_mvc_6.modelo.PersonaRequest;
import com.laboratorio.video_117_desarrollo_web_18_crud_mvc_6.persistencia.ConnectionPoolManager;
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
    private Connection connection = null;
    private PersonaDB personaDB;
    
    @Override
    public void init(){
        log.log(Level.INFO,"Obteniendo conexion a la base de datos...");
        try{
            connection= ConnectionPoolManager.getConnection();
        }catch(SQLException e){
            log.log(Level.SEVERE,"Error obtenieno conexion a la base de datos");
            connection = null;
            return;
        }
        log.log(Level.INFO,"Conexion realizada");
        personaDB = new PersonaDB(connection);
    }
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String accion = request.getParameter("accion");
        if(accion==null){
            accion="N/A";
        }
        log.log(Level.INFO,"Se esta ejecutando el Servlet. Accion: "+accion);
        
        String resultado;
        String mensaje;
        
        switch(accion){
            case "agregar":
                crearPersona(request,response);
                break;
            case "guardar":
                resultado = validarPersona(request);
                if(resultado.isEmpty()){
                    log.log(Level.INFO,"Se procede a guardar la persona!");
                    if(guardarPersona(request,response)){
                        mensaje = "Se han guardado los datos de la persona correctamente";
                    }else{
                        mensaje = "se ha presentado un error al guardarlos datos de la persona";
                    }
                    listarPersona(mensaje,request,response);
                }else{
                    mostrarErrores(resultado,request,response);
                }
                break;
            case "editar":                
                if(!editarPersona(request,response)){
                    mensaje=" Se ha presentado un error al resuperar los datos de la persona";
                    listarPersona(mensaje,request,response);
                }
                break;
            case "listar":
            default:
                listarPersona(null,request,response);
                break;
            
        }       
    }
    
    private void crearPersona(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        PersonaRequest persona =  new PersonaRequest();
        
        request.setAttribute("persona", persona);
        request.setAttribute("errores",null);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/formularioPersona.jsp");
        dispatcher.forward(request, response);
    }
    
    private void listarPersona(
            String mensaje,
            HttpServletRequest request, 
            HttpServletResponse response)
            throws ServletException, IOException{
        
        List<Persona> personas;
        try{
            personas = personaDB.getPersonas();
        }catch(SQLException e){
            log.log(Level.SEVERE,"Error recuperando la lista de personas");
            personas = new ArrayList<>();
        }
        
        request.setAttribute("lista_personas", personas);
        request.setAttribute("mensaje", mensaje);
        log.log(Level.INFO,"chao putito "+mensaje);
        RequestDispatcher dispatcher = request.getRequestDispatcher("personas.jsp");
        dispatcher.forward(request, response);
    }
    
    private String validarPersona(HttpServletRequest request){
        String nombre= request.getParameter("nombre");
        String apellidos=request.getParameter("apellidos");
        String fechaNac= request.getParameter("fechaNac");
        String experiencia = request.getParameter("experiencia");
        
        return personaDB.validar(nombre,apellidos,fechaNac,experiencia);
    }
    
    private void mostrarErrores(
            String errores,
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        String nombre= request.getParameter("nombre");
        String apellidos=request.getParameter("apellidos");
        String fechaNac= request.getParameter("fechaNac");
        String experiencia = request.getParameter("experiencia");
        
        
        PersonaRequest persona = new PersonaRequest(codigo,nombre,
                                    apellidos,fechaNac,experiencia);
        
        request.setAttribute("persona", persona);
        request.setAttribute("errores", errores);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("formularioPersona.jsp");
        dispatcher.forward(request, response);
        
    }
    
    private boolean guardarPersona(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String fechaNac = request.getParameter("fechaNac");
        log.log(Level.INFO,"Fecha {0}",fechaNac);
        String experiencia = request.getParameter("experiencia");
        
        if(codigo==0){
            try{
                return personaDB.insertar(nombre,apellidos,fechaNac,experiencia);
            }catch(Exception e){
                log.log(Level.SEVERE,"Error guardando los datos de la persona.");
                return false;
            }
        }
        
        return true;
    }
    
    private boolean editarPersona(
                HttpServletRequest request,
                HttpServletResponse response)
                throws ServletException, IOException{
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        log.log(Level.INFO,"Codigo: {0}",codigo);
        Persona persona;
        try{
            persona = personaDB.buscar(codigo);
            if(persona==null){
                return false;
            }
            
        }catch(Exception e){
            log.log(Level.SEVERE,"Error recuperando los datos de la persona");
            return false;
        }
        PersonaRequest personaRequest = new PersonaRequest(persona);
        
        request.setAttribute("persona", personaRequest);
        request.setAttribute("errores", null);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/formularioPersona.jsp");
        dispatcher.forward(request, response);
        return true;
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
