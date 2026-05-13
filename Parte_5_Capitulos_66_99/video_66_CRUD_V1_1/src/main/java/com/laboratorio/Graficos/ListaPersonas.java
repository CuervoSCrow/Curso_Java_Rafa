package com.laboratorio.Graficos;

import com.laboratorio.conexionBD.ConexionMysql;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;

public class ListaPersonas extends JFrame {
    private ConexionMysql conexionMysql;
    private Connection con;

    public ListaPersonas() {
        initComponents();

//        Establecer conexio a BD
        conexionMysql=new ConexionMysql();
        con = conexionMysql.conectarMysql();
        if(con == null){
            System.out.println("No se ha podido establecer conexion con la Base de datos");
            System.exit(1);
        }else{
            System.out.println("Se ha establecido la conexion con la base de datos");
        }
    }
    private void initComponents(){
        this.setTitle("Lista de Personas");
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setSize(560,490);
        setLocationRelativeTo(null);

//        Crea el panel principal
        JPanel panelPrincipal= new JPanel();
        panelPrincipal.setLayout(new BorderLayout());

//        Agrega el JScrollPane
        JScrollPane jScrollPane = generarTabla();
        panelPrincipal.add(jScrollPane,BorderLayout.CENTER);

//        Crea el panel de la parte de abajo
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));

//        Crea los 3 botones
        JButton bAgregar = new javax.swing.JButton("Agregar");
        JButton bModificar = new javax.swing.JButton("Modificar");
        JButton bEliminar = new javax.swing.JButton("Eliminar");

//        Deshabilita los botones
        bAgregar.setEnabled(false);
        bEliminar.setEnabled(false);
        bModificar.setEnabled(false);

//        Agrega los botones al panel
        panelBotones.add(bAgregar);
        panelBotones.add(bEliminar);
        panelBotones.add(bModificar);

//        Agrega el panel de los botones ala parte sut(abajo) del panel principal
        panelPrincipal.add(panelBotones,BorderLayout.SOUTH);

//        Agrega el panel principal al frame
        this.add(panelPrincipal);
        this.setVisible(true);
//        JTable tPersonas = new javax.swing.JTable();


        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
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

    private JScrollPane generarTabla(){
//        Crear el modelo de la tabla
        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Fecha nacimiento");
        modelo.addColumn("Experiencia");

//        Agregar datos a la tabla
        modelo.addRow(new Object[]{1,"Juan","Perez","18-11-83",9});
        modelo.addRow(new Object[]{2,"Doroteo","Rodriguez","18-11-82",3});
        modelo.addRow(new Object[]{2,"Manuel","Mares","18-11-20",9});

//        Crear la tabla
        JTable tPersonas = new JTable(modelo);

//        Establecer el tamaño preferido
        tPersonas.setPreferredSize(new Dimension(500,450));
        tPersonas.setFillsViewportHeight(true);

//        Ajusta el tamaño de las columnas
        tPersonas.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

//        Crea y retorna el JScrollPane que contiene la tabla
        JScrollPane scroll = new JScrollPane(tPersonas);
        scroll.setPreferredSize(new Dimension(500,450));

        return scroll;
    }


}

