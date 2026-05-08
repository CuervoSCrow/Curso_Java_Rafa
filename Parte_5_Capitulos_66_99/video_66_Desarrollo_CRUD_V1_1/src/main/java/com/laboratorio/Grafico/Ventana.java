package com.laboratorio.Grafico;

import com.laboratorio.ConexionBD.ConexionMysql;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;

public class Ventana extends JFrame {
    private Connection con;
    private ConexionMysql conexionMysql;

    public Ventana(){
        super("Lista de Personas");
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setSize(560, 490);
        setLocationRelativeTo(null);

//        Crea el Panle Principal
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());

//        Agregar el JScrollPane
        JScrollPane scrollPane = generarTabla();
        panelPrincipal.add(scrollPane,BorderLayout.CENTER);

//       Crea panel para los botones de la parte baja
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));

//        Crea los 3 botones deshabilitados
        JButton btnAgregar = new JButton("Agregar");
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnModificar = new JButton("Modificar");

//        Deshabilita los botones
        btnAgregar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnModificar.setEnabled(false);

//        Agregar los botones al panel
        panelBotones.add(btnAgregar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnModificar);

//        Agregar el panel de los botones a la parte sur(abajo) del panel principal
        panelPrincipal.add(panelBotones,BorderLayout.SOUTH);

//        Agregar el panel principal al frame
        this.add(panelPrincipal);
        this.setVisible(true);

//        Establece la conexion a base de datos
        conexionMysql = new ConexionMysql();
        con = conexionMysql.conectarMysql();
        if(con==null){
            JOptionPane.showMessageDialog(this, "No se pudo conectar a la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
        System.out.println("Se ha establecido la conexion a la base de datos");
        // Registrar el listener
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                cerrarAplicacion();
            }
        });
    }
    private void cerrarAplicacion(){
        if(con!=null){
            conexionMysql.cerrarConexionMysql(con);
        }
        this.dispose();
        System.exit(0);
    }
//    private JFrame generarVentana(){
//        JFrame frame = new JFrame("Puta Tabla");
//        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
//        frame.setSize(560, 490);
//        frame.setVisible(true);
//        setLocationRelativeTo(null);
//
////        Agregar el JScrollPane en lugar de la tabla directamente
//        JScrollPane scrollPane = generarTabla();
//        this.add(scrollPane);
//
//        return frame;
//    }
    private JScrollPane generarTabla(){
//           Crear el modelo de la tabla
        DefaultTableModel modelo = new  DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Municipio");

//        Agregar datos a la tabla
        modelo.addRow(new Object[]{1,"Juan","Perez","Municipio 1"});
        modelo.addRow(new Object[]{2,"Maria","Gomez","Municipio 2"});
        modelo.addRow(new Object[]{3,"Pedro","Garcia","Municipio 3"});

//        Crear la tabla
        JTable tPersonas = new JTable(modelo);

//        Establecer el tamaño preferido
        tPersonas.setPreferredSize(new Dimension(498,450));
        tPersonas.setFillsViewportHeight(true);
//        Ajustar el tamaño de las columnas
        tPersonas.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
//        Crea y retorna el JScrollPane que contiene la tabla
        JScrollPane scroll = new JScrollPane(tPersonas);
        scroll.setPreferredSize(new Dimension(500,450));

        return scroll;

    }
}
