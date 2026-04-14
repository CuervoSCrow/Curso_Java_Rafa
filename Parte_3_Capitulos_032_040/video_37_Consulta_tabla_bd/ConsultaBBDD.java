import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class ConsultaBBDD extends JFrame {
    private static DefaultTableModel modelo;
    private JTable tabla;
    private JScrollPane panel;
    private static Connection con;

    public ConsultaBBDD() {
//        Inicializar la ventana
        super("Consulta tabla a la base de datos");
        setBounds(0, 0, 600, 310);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

//        Inicializando el modelo de la tabla
        String[] etiquetas;

        modelo = new DefaultTableModel();
        modelo.addColumn("Id");
        modelo.addColumn("Nombre");
        modelo.addColumn("Nota");
        modelo.addColumn("Email");
        modelo.addColumn("Fecha Nacimiento");

        etiquetas = new String[5];
        etiquetas[0] = "Id";
        etiquetas[1] = "Nombre";
        etiquetas[2] = "Nota";
        etiquetas[3] = "Email";
        etiquetas[4] = "Fecha Nacimiento";

        modelo.setColumnIdentifiers(etiquetas);

//        Inicializamos la tabla
        tabla = new JTable(modelo);
        panel = new JScrollPane(tabla);
        panel.setBounds(10, 10, 560, 250);
        add(panel);
    }


    public static void main(String[] args){
        ConsultaBBDD ventana ;
        Statement statement;
        ResultSet rs;
        Object[] fila;
        int i;

        ventana = new ConsultaBBDD();
        ventana.setVisible(true);

        if(!conectarBD()){
            System.exit(0);
            return;
        }
        try{
//            Crea la consulta y ejecutala
            statement = con.createStatement();
            rs = statement.executeQuery("SELECT id, nombre, nota_alumno,email_alumno, fecha_nacimiento FROM alumnos");
//            Recorrer los resultados de la consulta
            while(rs.next()){
                fila = new Object[5];
                for(i=0;i<5;i++){
                    fila[i] = rs.getObject(i+1);
                }
                modelo.addRow(fila);
            }
            con.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static boolean conectarBD(){
//        Registrar el driver de postgresql
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException e){
            System.out.println("Error al registrar el driver PostgreSQL");
            return false;
        }
//        Establecer la conexion
        try{
            boolean conValida;
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/laboratorio",
                    "springboot",
                    "cuervo");
            conValida=con.isValid(10);
            if(!conValida){
                System.out.println("No se ha podido extablecer la conexion con la base de datos");
                return false;
            }

        }catch(Exception e){
            System.out.println("Error al establecer la conexion con la case de datos");
            System.out.println(e.getMessage());
            return false;
        }
        return true;

    }

}