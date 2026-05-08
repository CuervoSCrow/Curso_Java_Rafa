package com.laboratorio.ConexionBD;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuracion {
    private String driver;
    private String database;
    private String host;
    private String port;
    private String user;
    private String password;

    public Configuracion() {
    }
    public boolean recuperar(){
        Properties config = new Properties();
        try{
            FileInputStream fis = new FileInputStream("configuracion.properties");
            config.load(fis);
        }catch(IOException e){
            System.out.println(e.getMessage());
            return false;
        }
        driver = config.getProperty("driver","com.mysql.cj.jdbc.Driver");
        database = config.getProperty("database","persistencia");
        host = config.getProperty("host","localhost");
        port = config.getProperty("port","3306");
        user = config.getProperty("user","springboot");
        password = config.getProperty("password","canzervero");
        return true;
    }

    public String getDriver() {
        return driver;
    }

    public String getDatabase() {
        return database;
    }

    public String getHost() {
        return host;
    }

    public String getPort() {
        return port;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}
