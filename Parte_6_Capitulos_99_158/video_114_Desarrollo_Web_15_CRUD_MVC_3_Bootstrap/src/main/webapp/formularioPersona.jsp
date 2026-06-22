<%@page import="com.laboratorio.video_114_desarrollo_web_15_crud_mvc_3_bootstrap.modelo.Persona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
            Persona persona = (Persona) request.getAttribute("persona");
        %>
        <div class="container">

            <h1>Datos de la Persona:</h1>

            <form class="row g-3">  
                
                <input type="hidden" id="accion" name="accion" value="agregar">
                
                <div class="col-md-6">
                    <label for="codigo" class="form-label">Codigo</label>
                    <input type="number" class="form-control" id="codigo" 
                           disabled="true" value="<%=persona.getCodigo()%>">
                </div>
                
                <div class="col-12">
                    <label for="nombre" class="form-label">Nombre</label>
                    <input type="text" class="form-control" id="nombre>
                </div>
                <div class="col-12">
                    <label for="apellidos" class="form-label">Apellidos</label>
                    <input type="text" class="form-control" id="apellidos">
                </div>
                <div class="col-md-6">
                    <label for="fechaNac" class="form-label">Fecha de Nacimiento</label>
                    <input type="date" class="form-control" id="fechaNac">
                </div>
                <div class="col-md-6">
                    <label for="experiencia" class="form-label">Años de experiencia</label>
                    <input type="number" class="form-control" id="experiencia">
                </div>
                
                <div class="col-12">
                    <button type="submit" class="btn btn-primary btn-lg">Guardar</button>
                    <button type="submit" class="btn btn-secondary btn-lg" formaction="PersonasController">Regresar</button>
                </div>
               
            </form>

        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </body>
</html>
