package com.laboratorio;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionMysql {
    private Configuracion configuracion;
    private boolean isConfigurado;

    public ConexionMysql() {
        this.configuracion = new Configuracion();
        isConfigurado=configuracion.recuperar();
    }

    public Connection conectarMysql() {
        if(!isConfigurado){
            System.out.println("Hoy un problema de configuracion de la base de datos");
            return null;
        }
          String url="jdbc:mysql://"+configuracion.getHost()+":"+configuracion.getPort()+"/"+configuracion.getDatabase()+"?useSSL=false";
          Connection con=null;
          try {
              Class.forName(configuracion.getDriver());
              con= DriverManager.getConnection(url,configuracion.getUser(), configuracion.getPassword());
          } catch (Exception e) {
              System.out.println(e.getMessage());
          }
          return con;
    }
    public void cerrarConexionMysql(Connection con){
        try{
            con.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("Cerrando la conexion..!!!!");
    }
}
