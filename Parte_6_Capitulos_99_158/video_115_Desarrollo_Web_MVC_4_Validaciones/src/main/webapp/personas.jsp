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

        <title>Listado de Personas</title>
    <body>
        <div class="container">
            
            <h1>Listado de Personas</h1>

            <form action="PersonasController">
                
                <input type="hidden" id="accion" name="accion" value="agregar">
                    
                <div class="mb-3">
                    <table class="table">
                        <thead class="table-light">
                            <tr>
                                <th scope="col">Codigo:</th>
                                <th scope="col">Nombre:</th>
                                <th scope="col">Apellidos:</th>
                                <th scope="col">Nacimientos</th>
                                <th scope="col">Experiencia</th>
                                <th scope="col">Opciones</th>
                            </tr>            
                        </thead>
                        <tbody class="table-group-divider">
                            <c:forEach var = "persona" items="${lista_personas}">               
                                <tr>
                                    <th scope="row">${persona.codigo}</th>
                                    <td>${persona.nombre}</td>
                                    <td>${persona.apellidos}</td>
                                    <td>${persona.fechaNacimiento}</td>
                                    <td>${persona.experiencia}</td>
                                    <th scope="col">
                                        <button type="button" class="btn btn-outline-success">Editar</button>                                
                                        <button type="button" class="btn btn-outline-danger">Eliminar</button>
                                    </th>
                                </tr>  
                            </c:forEach>
                        </tbody>
                    </table>
                </div>            
                <div class="col-12">
                    <button type="submit" class="btn btn-primary btn-lg">Crear Persona</button>
                    <button type="submit" class="btn btn-secondary btn-lg" formaction="index.html">Vover el indice</button>
                </div>
            </form>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </body>
</html>
