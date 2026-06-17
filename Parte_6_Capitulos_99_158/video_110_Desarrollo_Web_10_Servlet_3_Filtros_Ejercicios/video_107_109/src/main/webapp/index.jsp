<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Login con Servlets</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <%
            String error=request.getParameter("error");
            pageContext.setAttribute("error", error);
        %>
        <h1>Entrada al Sistema</h1>
        
        <c:if test="${error != null}">
            <br>
            <h3><%=error%></h3>
            <br>
        </c:if>
        
        <form method="POST" action="LoginServlet">
            <p>Usuario: <input name="usuario"/></p>
            <p>Clave: <input type="password" name="clave"/></p>
            <button type="submit">Ingresar</button>
        </form>
        <br>
        <p><a href="PrimerServlet">Acceso al primer Servlet</a></p>
    </body>
</html>
