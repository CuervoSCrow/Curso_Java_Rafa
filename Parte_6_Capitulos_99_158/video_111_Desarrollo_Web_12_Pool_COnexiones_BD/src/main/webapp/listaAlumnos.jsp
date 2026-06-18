<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de alumnos</title>
    </head>
    <body>
        <h1>lista de Alumnos</h1>
        
    <ul>
    <c:forEach var="alumno" items="${alumnos}">
        <li>
            ${alumno.nombre} ${alumno.apellido} - ${alumno.edad}
        </li>
    </c:forEach>
    </ul>
        
    <%String estadoConexion = (String) request.getAttribute("conexion");%>
    <p>Estado de la conexion a base de datos: <%=estadoConexion%></p>
        
    </body>
</html>
