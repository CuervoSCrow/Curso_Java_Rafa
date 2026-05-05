package com.laboratorio;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void mostrarEmpleados(Connection con){
        Statement statement;
        ResultSet resultSet;
        int i=0;
        try {
            statement = con.createStatement();
            resultSet=statement.executeQuery("SELECT * FROM Empleado");
            if(resultSet==null){
                System.out.println("No hay empleados");
            }
            while (resultSet.next()) {
                i++;
                System.out.println(i+"-  Nombre: "+resultSet.getString("nombre"));
            }
            System.out.println("Total de empleados: " + i);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            // TODO: handle exception
        }
    }
    public static void main(String[] args) {
        ConexionMysql conexionMysql = new ConexionMysql();
        Connection con;
        con =conexionMysql.conectarMySQL();
        if(con!= null){
            System.out.println("La conexion de MySQL se ha realizado correctamente");

            mostrarEmpleados(con);

            conexionMysql.cerrarConexionMySQL(con);

        }else {
            System.out.println("La conexion de MySQL no se ha realizado correctamente");
        }
    }
}