<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema Bienvenida</title>
    </head>
    <body>
        <%
            String usuario= (String) session.getAttribute("usuario");
            String ciudad = (String) session.getAttribute("ciudad");
        %>
        <h1>Informacion adicional</h1>
        <p>Información del navegador: <%= request.getHeader("User-Agent") %></p>
        <p>Información del idioma: <%= request.getLocale() %></p>
        <p>Información del usuario: <% out.println(usuario); %></p>
        <p>Información del lugar de conexión: <%= ciudad %></p>
    </body>
</html>
