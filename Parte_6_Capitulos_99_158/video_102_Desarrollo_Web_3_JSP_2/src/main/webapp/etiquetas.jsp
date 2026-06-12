
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trabajando con etiquetas</title>
    </head>
    <body>
        <jsp:useBean id="operaciones" class="com.laboratorio.video_102_desarrollo_web_3_jsp_2.Operaciones"/>        
        <%!
            int[] valores1 = {5,7,8,6,14};
            int[] valores2 = {2,4,1,5,3};
            int i=0;
        %>
        <%
            pageContext.setAttribute("val1",valores1);
            pageContext.setAttribute("val2",valores2);            
        %>
        <h1>Demostrando el uso de las etiquetas JSP</h1>
        
        <h2>Tabla usando HTMLz</h2>
        <table>
            <thead>
                <tr>
                    <th>Valor 1</th>
                    <th>Valor 2</th>
                    <th>Suma</th>
                    <th>Resta</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>5</td>
                    <td>2</td>
                    <td>7</td>
                    <td>3</td>
                </tr>
                <tr>
                    <td>7</td>
                    <td>4</td>
                    <td>11</td>
                    <td>3</td>
                </tr>
                <tr>
                    <td>8</td>
                    <td>1</td>
                    <td>9</td>
                    <td>7</td>
                </tr>
            </tbody>
        </table>
        <h2>Usando etiquetas</h2>
        <table>
            <thead>
                <tr>
                    <th>Valor 1</th>
                    <th>Valor 2</th>
                    <th>Suma</th>
                    <th>Resta</th>
                    <th>Suma mayor 10</th>
                    <th>Resta mayor 10</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach begin="1" end="5">
                    <%
                        pageContext.setAttribute("j",i);
                        i++;
                    %>
                    <tr>
                        <td>
                            <c:out value="${val1[j]}"></c:out>
                        </td>
                        <td>
                            <c:out value="${val2[j]}"></c:out>
                        </td>
                        <td>
                            <c:out value="${operaciones.suma(val1[j],val2[j])}"></c:out>
                        </td>
                        <td>
                            <c:out value="${operaciones.resta(val1[j],val2[j])}"></c:out>
                        </td>
                        <td>
                            <c:if test="${operaciones.suma(val1[j],val2[j]) >= 10}">
                                Es Mayor
                            </c:if>
                        </td>
                        <td>
                            <c:choose>
                                <c:when test="${operaciones.resta(val1[j],val2[j]) >= 10}">
                                    Es mayor
                                </c:when>
                                <c:otherwise>
                                    Es menor
                                </c:otherwise>
                            </c:choose>                           
                        </td>
                    </tr>
                    
                </c:forEach>              
            </tbody>
        </table>
    </body>
</html>
