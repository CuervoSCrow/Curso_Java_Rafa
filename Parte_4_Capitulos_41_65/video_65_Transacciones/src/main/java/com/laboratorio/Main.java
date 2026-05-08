package com.laboratorio;

import java.sql.*;

public class Main {

        public static void mostrarMunicipios(Connection con){
            Statement statement;
            ResultSet resultSet;
            int i=0;
            try{
                statement= con.createStatement();
                resultSet= statement.executeQuery("SELECT * FROM municipios");
                if(resultSet==null){
                    System.out.println("No hay empleados");
                }
                while(resultSet.next()){
                    i++;
                    System.out.println(i+".- Municipio: "+resultSet.getString("Municipio"));
                }
                System.out.println("Total de empleados: "+i);
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    public static void insertarMunicipio(Connection con,
                                         int claveInegi,
                                         String municipio,
                                         String cabecera,
                                         int poblacion,
                                         double superficie,
                                         double fundacionAprox,
                                         int claveInegi2,
                                         String municipio2,
                                         String cabecera2,
                                         int poblacion2,
                                         double superficie2,
                                         double fundacionAprox2
                                        ){
        PreparedStatement ps;
        try{
//            Iniciar la transaccion
            con.setAutoCommit(false);
            ps = con.prepareStatement("INSERT INTO municipios " +
                    "(Clave_INEGI,Municipio,Cabecera_Municipal,Poblacion_2020,Superficie_km2,Fundacion_Aprox) " +
                    "VALUES (?,?,?,?,?,?)");
            ps.setString(1, String.valueOf(claveInegi));
            ps.setString(2,municipio);
            ps.setString(3,cabecera);
            ps.setString(4, String.valueOf(poblacion));
            ps.setString(5, String.valueOf(superficie));
            ps.setString(6, String.valueOf(fundacionAprox));
            ps.execute();
            ps = con.prepareStatement("INSERT INTO municipios2 " +
                    "(Clave_INEGI,Municipio,Cabecera_Municipal,Poblacion_2020,Superficie_km2,Fundacion_Aprox) " +
                    "VALUES (?,?,?,?,?,?)");
            ps.setString(1, String.valueOf(claveInegi2));
            ps.setString(2,municipio2);
            ps.setString(3,cabecera2);
            ps.setString(4, String.valueOf(poblacion2));
            ps.setString(5, String.valueOf(superficie2));
            ps.setString(6, String.valueOf(fundacionAprox2));
            ps.execute();
//          Confirma la transaccion
            con.commit();
        }catch(Exception e){
//            Revertir la transaccion
            try {
                con.rollback();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {
        ConexionMysql conexionMysql=new ConexionMysql();
        Connection con=conexionMysql.conectarMysql();
        if(con!=null){
            System.out.println("La conexion de MySQL se establecio correctamente");
//            insertarMunicipio(con,
//                    15001,"Acambay","Acambay de Ruíz Castañeda",67872,465.70,1824,
//                    15002,"Acolman","Acolman de Nezahualcóyotl",171507,83.95,1826);
            insertarMunicipio(con,
                    15003,"Aculco","Aculco de Espinoza",49266,453.26,1825,
                    15004,"Almoloya de Alquisiras","Almoloya de Alquisiras",15333,182.65,1825);
            mostrarMunicipios(con);
            conexionMysql.cerrarConexionMysql(con);
        }else{
            System.out.println("No se pudo establecer la conexion");
        }

    }
}