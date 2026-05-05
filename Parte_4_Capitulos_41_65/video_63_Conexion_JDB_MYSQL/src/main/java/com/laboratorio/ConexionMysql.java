package com.laboratorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMysql {
    private final String driver = "com.mysql.cj.jdbc.Driver";
//    Nombre de la base de datos
    private final String database = "persistencia";
    private final String hostname = "localhost";
    private final String port = "3306";
    private final String userName = "springboot";
    private final String password = "canzervero";

    public Connection conectarMySQL() {
        String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database+"?useSSL=false";
        Connection con = null;
        try {
               Class.forName(driver);
               con = DriverManager.getConnection(url,userName,password);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return con;
    }
    public void cerrarConexionMySQL(Connection con){
        try{
            con.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("Cerrando la conexion.......");
    }
}
