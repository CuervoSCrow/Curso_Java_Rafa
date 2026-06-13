
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formularios</title>
    </head>
    <body>
        <h1>Entrada al sistema</h1>
        
        <form method="GET" action="bienvenida.jsp">
            <p>Nombre: <input name="nombre" /></p>
            <p>Ciudad: <input name="ciudad" /></p>
            <p>Password: <input type="password" name="clave"/></p> 
            <p>
                <input type="checkbox" id="checkbox1" name="preferencia" value="Si"/>
                <label>¿Recordar Información?:</label>
            </p>
            <button type="submit">Saludar</button>                
                    
        </form>
    </body>
</html>
