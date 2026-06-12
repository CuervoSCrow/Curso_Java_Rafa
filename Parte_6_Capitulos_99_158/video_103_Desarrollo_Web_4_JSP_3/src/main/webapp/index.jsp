<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/mitabla.tld" prefix="d"%>

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
        </ul>
        
        <h2>Ejemplos de declaraciones</h2>
        <%!
            int suma(int n1,int n2){
                int resultado = n1+n2;
                return resultado;
            }
            int resta(int n1,int n2){
                int resultado=n1-n2;
                return resultado;
            }
        %>
        <p>5+3 es igual <%=suma(5,3)%></p>
        <p>7-2 es igual <%=resta(7,2)%></p>
        
        <h2>Etiqueta personalizada</h2>
        
        <%!
            int[] valores1 = {7,12,16,23,32,43};
            int[] valores2 = {4,6,11,15,7,21};
            
            com.laboratorio.video_103_desarrollo_web_4_jsp_3.Columna columna1 =
            new com.laboratorio.video_103_desarrollo_web_4_jsp_3.Columna(valores1);
            com.laboratorio.video_103_desarrollo_web_4_jsp_3.Columna columna2 =
            new com.laboratorio.video_103_desarrollo_web_4_jsp_3.Columna(valores2);
        %>
        <%            
            pageContext.setAttribute("col1",columna1);
            pageContext.setAttribute("col2",columna2);
        %>
        
        <d:MiTabla columna1="${col1}" columna2="${col2}" />
        
        <p><a href="etiquetas.jsp">Uso de las etiquetas</a></p>
    </body>
</html>
