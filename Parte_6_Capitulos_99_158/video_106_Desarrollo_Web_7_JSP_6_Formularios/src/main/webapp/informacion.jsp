<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema Bienvenida</title>
    </head>
    <body>
        <%
            String usuario=(String) session.getAttribute("usuario");
            String ciudad=(String) session.getAttribute("usuario");
        %>        
        <h1>Información Adicional</h1>
        <p>Información del Navegador: <%= request.getHeader("User-Agent")%></p>
        <p>Información del Idioma: <%= request.getLocale()%> </p>
        <p>Información del Usuario: <% out.println(usuario);%></p>
        <p>Información del lugar de conexion: <%= ciudad %></p>
        <p><a href="index_get.jsp">Volver a la Página Principal</a></p>               
    </body>
</html>
