package com.laboratorio;

import com.laboratorio.ConexionBD.ConexionMysql;
import com.laboratorio.Grafico.Ventana;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void mostrarMunicipios(Connection con){
        Statement statement;
        ResultSet resultSet;
        int i=0;
        try{
            statement= con.createStatement();
            resultSet= statement.executeQuery("SELECT * FROM municipios");
            if(resultSet==null){
                System.out.println("No hay municipios");
            }
            while(resultSet.next()){
                i++;
                System.out.println(i+".- Municipio: "+resultSet.getString("Municipio"));
            }
            System.out.println("Total de Municipios: "+i);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {
//        ConexionMysql conexionMysql = new ConexionMysql();
//        Connection con = conexionMysql.conectarMysql();
//        if(con!=null){
//            System.out.println("Conectado a la base de datos");
//            mostrarMunicipios(con);
//            conexionMysql.cerrarConexionMysql(con);
//        }else{
//            System.out.println("No se pudo conectar a la base de datos");
//        }
        Ventana ventana = new Ventana();
    }
}