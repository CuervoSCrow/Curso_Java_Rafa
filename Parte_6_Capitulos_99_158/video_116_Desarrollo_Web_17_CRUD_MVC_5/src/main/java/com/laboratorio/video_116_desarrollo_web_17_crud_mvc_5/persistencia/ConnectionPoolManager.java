
package com.laboratorio.video_116_desarrollo_web_17_crud_mvc_5.persistencia;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.Duration;
import org.apache.commons.dbcp2.BasicDataSource;

public class ConnectionPoolManager {
    private static final BasicDataSource dataSource;
    static{
        dataSource = new BasicDataSource();
         dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/CRUD");
        dataSource.setUsername("springboot");
        dataSource.setPassword("canzervero");
        dataSource.setMaxIdle(3);
        dataSource.setMaxWait(Duration.ofSeconds(5)); 
    }
    public static Connection getConnection() throws SQLException{
        return dataSource.getConnection();
    }
    
    
}
