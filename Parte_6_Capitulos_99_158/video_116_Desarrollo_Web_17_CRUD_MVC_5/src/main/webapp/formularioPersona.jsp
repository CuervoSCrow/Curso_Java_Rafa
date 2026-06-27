
<%@page import="com.laboratorio.video_116_desarrollo_web_17_crud_mvc_5.modelo.PersonaRequest"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>

        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

        <title>Formulario de las  Personas</title>
    <body>
        <%
            PersonaRequest persona = (PersonaRequest) request.getAttribute("persona");
            String errores = (String) request.getAttribute("errores");
        %>
        <div class="container">

            <h1>Datos de la Persona:</h1>
            
            <c:if test="${errores != null}">
                <div class="alert alert-danger" role=""alert>
                    <%= errores %>
                </div>
            </c:if>
                

            <form class="row g-3">  
                
                <input type="hidden" id="accion" name="accion" value="guardar">
                
                <div class="col-md-6">
                    <label for="codigo" class="form-label">Codigo</label>
                    <input type="number" class="form-control" id="codigo" 
                           readonly="true" name="codigo" value="<%=persona.getCodigo()%>">
                </div>
                
                <div class="col-12">
                    <label for="nombre" class="form-label">Nombre</label>
                    <input type="text" class="form-control" id="nombre" name="nombre"
                           value="<%=persona.getNombre()%>">
                </div>
                <div class="col-12">
                    <label for="apellidos" class="form-label">Apellidos</label>
                    <input type="text" class="form-control" id="apellidos" name="apellidos"
                           value="<%=persona.getApellidos()%>">
                </div>
                <div class="col-md-6">
                    <label for="fechaNac" class="form-label">Fecha de Nacimiento</label>
                    <input type="date" class="form-control" id="fechaNac" name="fechaNac"
                           value="<%=persona.getFechaNac()%>">
                </div>
                <div class="col-md-6">
                    <label for="experiencia" class="form-label">Años de experiencia</label>
                    <input type="number" class="form-control" id="experiencia" name="experiencia"
                           value="<%=persona.getExperiencia()%>">
                </div>
                
                <div class="col-12">
                    <button type="submit" class="btn btn-primary">Guardar</button>
                    <a href="PersonasController" class="btn btn-secondary">
                        <span class="bi bi-arrow-left"></span>Regresar                            
                    </a>
                    
                </div>
               
            </form>

        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </body>
</html>
