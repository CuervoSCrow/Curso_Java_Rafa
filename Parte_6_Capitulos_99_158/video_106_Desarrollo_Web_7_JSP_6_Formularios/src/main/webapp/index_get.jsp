
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Sistema de Bienvenida</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <%
            session.invalidate();
            String nombre="";
            String ciudad="";
            String preferencia="";
            
            Cookie[] cookies = request.getCookies();
            
            if(cookies != null){                
                int i=1;
                for(Cookie cookie:cookies){
                    out.println("<p>Cookie "+i+":"+cookie.getName()+
                            " - "+cookie.getValue()+"</p>");
                    i++;
                    switch(cookie.getName()){
                        case "bienvenida.nombre":
                            nombre = cookie.getValue();
                            break;
                        case "bienvenida.ciudad":
                            ciudad = cookie.getValue();
                            break;
                        case "bienvenida.preferencia":
                            preferencia = cookie.getValue();
                            break;
                    }
                    if(preferencia.equalsIgnoreCase("No")){
                        nombre="";
                        ciudad="";
                    }
                }
            }
        %>
        <h1>Entrada al sistema</h1>
        
        <form action="bienvenida.jsp">
            <p>Nombre: <input name="nombre" value="<%=nombre%>"/></p>
            <p>Ciudad: <input name="ciudad" value="<%=ciudad%>"/></p>
            <p>
                <input type="checkbox" id="checkbox1" name="preferencia" value="Si"/>
                <label>¿Recordar Información?:</label>
            </p>
            <button type="submit">Saludar</button>
                
                    
        </form>
    </body>
</html>
