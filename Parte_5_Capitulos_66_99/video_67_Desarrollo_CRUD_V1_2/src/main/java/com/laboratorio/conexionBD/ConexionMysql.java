package com.laboratorio.conexionBD;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionMysql {
    private Configuracion config;
    private boolean isConfigured;

    public ConexionMysql(){
        config = new Configuracion();
        isConfigured = config.recuperar();
    }

    public Connection conectarMysql(){
        if(!isConfigured){
            System.out.println("No se ha configurado la base de datos");
            return null;
        }
        String url="jdbc:mysql://"+config.getHost()+":"+config.getPort()+"/"+config.getDatabase()+"?useSSL=false";
        Connection con = null;
        try{
            Class.forName(config.getDriver());
            con = DriverManager.getConnection(url, config.getUser(), config.getPassword());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return con;
    }
    public void cerrarConexionMysql(Connection con){
        try{
            if(con != null && !con.isClosed()){
                con.close();
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

}
