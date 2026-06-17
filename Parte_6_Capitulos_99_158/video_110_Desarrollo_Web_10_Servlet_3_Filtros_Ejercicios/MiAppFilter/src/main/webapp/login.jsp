<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <style>
            .error{
                color:red;
            }
            .container{
                width:300px;
                margin:50px auto;
                padding:20px;
                border:1px solid #ccc;
            }
            input{
                width: 100%;
                padding: 8px;
                margin: 5px 0;
            }
            button{
                width: 100%;
                padding: 10px;
                background-color: #4CAF50;
                color: white;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h2>Login</h2>
            <% if(request.getAttribute("error")!=null){ %>
                <div class="error"><%=request.getAttribute("error")%></div>
            <%}%>
            <form method="post" action="login">
                <div>
                    <label>Usuario:</label>
                    <input type="text" name="usuario" required/>
                </div>
                <div>
                    <label>Password:</label>
                    <input type="password" name="password" required/>
                </div>
                <button type="submit">Ingresar</button>                
            </form>
            <p>Prueba con: admin / 1234</p>
        </div>        
    </body>
</html>
