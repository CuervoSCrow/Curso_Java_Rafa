<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login con Servlets</title>
    </head>
    <body>
        <%
            String usuario = request.getParameter("usuario");
            String rol = (String) request.getAttribute("rol");
        %>
        <h1>Menu del Sistema</h1>
        <p>Usuario: <%=usuario%></p>
        <p>Rol: <%=rol%></p>
        <br>
        <p><a href="PrivateServlet.do">Información</a></p>
        <br>
        <p><a href="LogoutServlet">Salir</a></p>
    </body>
</html>
