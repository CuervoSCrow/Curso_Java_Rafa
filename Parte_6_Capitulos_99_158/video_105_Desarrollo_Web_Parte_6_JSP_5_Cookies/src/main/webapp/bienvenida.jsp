<%-- 
    Document   : bienvenida
    Created on : 12 jun 2026, 12:50:56 p.m.
    Author     : canzervero
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema de Bienvenida</title>
    </head>
    <body>
        <%
            String nombre = request.getParameter("nombre");
            String ciudad = request.getParameter("ciudad");
            String preferencia = request.getParameter("preferencia");
            if(preferencia==null){
                preferencia="No";
            }
            session.setAttribute("usuario",nombre);
            session.setAttribute("ciudad",ciudad);
            
            Cookie  nombreUsuario = new Cookie("bienvenida.nombre",nombre);
            nombreUsuario.setMaxAge(7*24*60*60);
            response.addCookie(nombreUsuario);
            
            Cookie ciudadUsuario = new Cookie("bienvenida.ciudad",ciudad);
            ciudadUsuario.setMaxAge(7*24*60*60);
            response.addCookie(ciudadUsuario);
            
            Cookie preferenciaUsuario = new Cookie("bienvenida.preferencia",preferencia);
            preferenciaUsuario.setMaxAge(7*24*60*60);
            response.addCookie(preferenciaUsuario);
        %>
        <h1>Hello World!</h1>
        <p>Se ha conectado <%= nombre %>  de la ciudad <%=ciudad%></p>
        <p>El usuario quiere recordar la informacion: <%=preferencia%></p>
        <p><a href="informacion.jsp">Informacion Adicional</a></p>
        <p><a href="index.jsp">Volver al página principal</a></p>
            
    </body>
</html>
