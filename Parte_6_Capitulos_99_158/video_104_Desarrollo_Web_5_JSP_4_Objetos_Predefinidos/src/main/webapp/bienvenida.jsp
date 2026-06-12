<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema de bienvenida</title>
    </head>
    <body>
        <%
            String nombre = request.getParameter("nombre");
            String ciudad = request.getParameter("ciudad");
            session.setAttribute("usuario",nombre);
            session.setAttribute("ciudad",ciudad);
        %>
        <h1>Bienvenida</h1>
        <p>Se ha conectado <%= nombre%> de la ciudad <%= ciudad %></p>
        <p><a href="informacion.jsp">Informacion adicional</a>
    </body>
</html>
