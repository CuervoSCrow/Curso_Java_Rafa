package com.laboratorio;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void mostrarEmpleados(Connection con){
        Statement statement;
        ResultSet resultSet;
        int i=0;
        try{
            statement= con.createStatement();
            resultSet= statement.executeQuery("SELECT * FROM Empleado");
            if(resultSet==null){
                System.out.println("No hay empleados");
            }
            while(resultSet.next()){
                i++;
                System.out.println(i+".- Nombre: "+resultSet.getString("nombre"));
            }
            System.out.println("Total de empleados: "+i);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {
        ConexionMysql conexionMysql=new ConexionMysql();
        Connection con=conexionMysql.conectarMysql();
       if(con!=null){
           System.out.println("La conexion de MySQL se establecio correctamente");
           mostrarEmpleados(con);
           conexionMysql.cerrarConexionMysql(con);
       }else{
           System.out.println("No se pudo establecer la conexion");
       }

    }
}