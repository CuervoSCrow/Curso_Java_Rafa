<%-- 
    Document   : index
    Created on : 10 jun 2026, 1:26:28 p.m.
    Author     : canzervero
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <h2>Ejemplos de expresiones</h2>
        <p>Hoy es <%= new java.util.Date() %></p>
        
        <p>3 al cuadrado es: <%= java.lang.Math.pow(3,2) %> </p>
        
        <h2>Ejemplo de scriplet</h2>
        <ul>
            
            <%
                int i;
                for(i=0;i<=5;i++){
                   out.println("<li>Elemento "+i+"</li>");
                }
            %>
        </ul>
        
        <h2>Segundo ejemplo de scripler</h2>
        <ul>
            <%
                for(i=0;i<=5;i++){
            %>
            <li>
            <%
                out.println("elemento "+i);
            %>
            </li>
            <%
                }
            %>
            
                }
        </ul>
        
    </body>
</html>
