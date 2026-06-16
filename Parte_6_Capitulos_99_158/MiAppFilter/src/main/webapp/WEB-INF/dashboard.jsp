<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dashboard</title>
        <style>
            .container {
                width: 600px;
                margin: 50px auto;
                padding: 20px;
                border: 1px solid #ccc;
            }
            .logout {
                background-color: #f44336;
                color: white;
                padding: 10px;
                text-decoration: none;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h2>Bienvenido, ${usuario} !</h2>
            <p> Este es tu dashboard protegido por el filtro de autenticación.</p>
            <p>Solo usuarios logueados pueden ver esta pagina.</p>
            
            <form method="post" action="dashboard">
                <button type="submit" class="logout">Cerrar Sessión</button>                
            </form>            
        </div>
        
    </body>
</html>
