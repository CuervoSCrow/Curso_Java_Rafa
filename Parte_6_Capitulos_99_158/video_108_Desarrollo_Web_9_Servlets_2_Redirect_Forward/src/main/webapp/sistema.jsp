<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login con Servlets</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <%
            String usuario = request.getParameter("usuario");
            String rol = (String) request.getAttribute("rol");
        %>
        <h1>Menu del sistema</h1>
        <p>Usuario: <%=usuario%></p>
        <p>Rol: <%=rol%></p>
        <br>
        <p><a href="index.jsp">Salir</a></p>
    </body>
</html>
