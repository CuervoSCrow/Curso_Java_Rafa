import java.sql.*;

public class ConexionBBDD{
    public static void main(String[] args){
//        Registra el driver PostgreSQL
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException e){
            System.out.println("Error al registrar el driver postgresql");
            e.printStackTrace();
            return;
        }
//        Establecer la conexion con la base de datos
        try{
            Connection con;
            boolean conValida;
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/laboratorio",
                                            "springboot",
                                            "cuervo");
            conValida=con.isValid(10);
            if(conValida){
                System.out.println("Se ha establecido la conexion con la base de datos");
            }else {
                System.out.println("No se ha podido establecer con la base de datos");
                return;
            }
            con.close();
        }catch(Exception e){
            System.out.println("Error al establecer la conexion de la base de datos");
            System.out.println(e.getMessage());
        }
    }
}