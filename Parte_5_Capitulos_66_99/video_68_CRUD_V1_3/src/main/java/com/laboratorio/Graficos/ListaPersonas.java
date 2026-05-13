package com.laboratorio.Graficos;

import com.laboratorio.conexionBD.ConexionMysql;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;

public class ListaPersonas extends JFrame {
    private ConexionMysql conMysql;
    private Connection con;
    private JLabel lblMensaje;
    private MyTableModel modelo;
    private JTable tPersonas;
    private JButton bAgregar;
    private JButton bModificar;
    private JButton bEliminar;
    public  ListaPersonas(){
        super("Lista de Personas");
        initComponents();
    }
    public class MyTableModel extends DefaultTableModel {
        @Override
        public boolean isCellEditable(int row, int column){
            return false;
        }
    }
    public void initComponents(){
        setSize(600,400);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10,10));


//        Crea el Panel Tabla
        JPanel panelTabla = new JPanel();
        panelTabla.setLayout(new BorderLayout(10,10));
        panelTabla.setBorder(BorderFactory.createTitledBorder("Panel con Tabla"));

//        Crear modelo
        modelo = new MyTableModel();
        modelo.addColumn("Id");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Fecha Nacimiento");
        modelo.addColumn("Experiencia");

        tPersonas = new JTable(modelo);
        tPersonas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(tPersonas);
        panelTabla.add(scrollPane,BorderLayout.CENTER);

//        Crea el Panel Botones
        JPanel panelBotones = new JPanel(new FlowLayout());
        panelBotones.setBorder(BorderFactory.createTitledBorder("Panel con Botones"));
        bAgregar = new JButton("Agregar");
        bModificar = new JButton("Modificar");
        bEliminar = new JButton("Eliminar");

        panelBotones.add(bAgregar);
        panelBotones.add(bModificar);
        panelBotones.add(bEliminar);

//        Area de mensajes
        lblMensaje =new JLabel("",SwingConstants.CENTER);
        lblMensaje.setBorder(BorderFactory.createEtchedBorder());

//        Agrega los paneles al Frame
        add(panelTabla,BorderLayout.CENTER);
        add(panelBotones,BorderLayout.SOUTH);
        add(lblMensaje,BorderLayout.NORTH);

//        Establecer la conexion con la base de datos
        conMysql= new ConexionMysql();
        con=conMysql.conectarMysql();
        if(con==null){
            JOptionPane.showMessageDialog(this,
                    "No se pudo conectar a la base de datos.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
        System.out.println("Se ha establecido la conexión con la base de datos.");

//        Carga los datos en la tabla
        if(!cargarListapersonas()){
//            Mensaje de error
            JOptionPane.showMessageDialog(null,
                    "Error al intentar cargar las personas",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        desactivarEliminarModificar();
//EVENTOS
        // Registrar el listener
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                cerrarAplicacion();
            }
        });

        tPersonas.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int filaSeleccionada = tPersonas.getSelectedRow();
                if(filaSeleccionada!=-1){
                    System.out.println("Fila Seleccionada: "+filaSeleccionada);

//                    Obtener datos de la fila seleccionada
                    Object id = modelo.getValueAt(filaSeleccionada,0);
                    Object nombre = modelo.getValueAt(filaSeleccionada,1);
                    Object apellidos = modelo.getValueAt(filaSeleccionada,2);
                    Object fechaNacimiento = modelo.getValueAt(filaSeleccionada,3);
                    Object experiencia = modelo.getValueAt(filaSeleccionada,4);

                    System.out.println("Id: "+id);
                    System.out.println("Nombre: "+nombre);
                    System.out.println("Apellidos: "+apellidos);
                    System.out.println("Fecha de Nacimiento: "+fechaNacimiento);
                    System.out.println("Experiencia: "+experiencia);

//                    Activar los botones Modificar y Eliminar
                    activarEliminarModificar();
                }else{
                    System.out.println("Ninguna fila Seleccionada.");
                    desactivarEliminarModificar();
                }

            }
        });

//        Boton Eliminar
        bEliminar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Object[] opciones ={"Sí","No"};
                int resp= JOptionPane.showOptionDialog(null,
                        "¿Esta seguro de eliminar la persona seleccionada?",
                        "Confirmación",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        opciones,
                        opciones[0]
                );
                if(resp!=0){
                    return;
                }
                int row = tPersonas.getSelectedRow();
                int id= (int) modelo.getValueAt(row,0);
                PreparedStatement ps;
                try{
                    ps=con.prepareStatement("DELETE FROM personas WHERE idpersonas = ?");
                    ps.setInt(1,id);
                    ps.executeUpdate();
                }catch(SQLException ex){
                    System.out.println(ex.getMessage());
//                    Mensaje para el usuario
                    lblMensaje.setText("Error al eliminar el producto.");
                    JOptionPane.showMessageDialog(null,
                            "Error al intentar eliminar la persona seleccionada.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                modelo.removeRow(row);
                tPersonas.setModel(modelo);
                lblMensaje.setText("Producto Eliminado: "+id);
            }
        });
    }
    //    Carga los datos de la bd a la tabla
    private boolean cargarListapersonas(){
        Statement statement;
        ResultSet resultSet;
        Object[] fila;
        try{
            statement=con.createStatement();
            resultSet=statement.executeQuery("SELECT idpersonas, nombre, apellidos, " +
                    "fecha_nacimiento, experiencia " +
                    " FROM personas ORDER BY idpersonas");
            while(resultSet.next()){
                fila = new Object[5];
                for(int i=0; i<5;i++){
                    fila[i] = resultSet.getObject(i+1);
                }
                modelo.addRow(fila);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }
    //    Descativa el boton Eliminar y Modificar
    public void desactivarEliminarModificar(){
        bEliminar.setEnabled(false);
        bModificar.setEnabled(false);
    }
    //    Activa los botones Eliminar y Modificar
    public void activarEliminarModificar(){
        bEliminar.setEnabled(true);
        bModificar.setEnabled(true);
    }
    //    Cierrra la aplicación
    private void cerrarAplicacion() {
        if (con != null) {
            conMysql.cerrarConexionMysql(con);
        }
        this.dispose();
        System.exit(0);
    }

}
