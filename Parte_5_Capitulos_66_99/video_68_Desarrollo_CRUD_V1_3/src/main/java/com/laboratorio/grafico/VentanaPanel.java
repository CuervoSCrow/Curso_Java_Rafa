package com.laboratorio.grafico;

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

public class VentanaPanel extends JFrame{
    private Connection con;
    private ConexionMysql conMysql;
    private JTable tPersonas;
    private MyTableModel modelo;
    private JLabel lblMensaje;
    private JButton btnAgregar, btnEliminar, btnActualizar;
    private EditarPersonas editarPersonas;

    public VentanaPanel() {
        super("Lista de Personas");
        initComponentes();
    }
    public void initComponentes() {
        setSize(600,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLayout(new BorderLayout(10,10));
        setResizable(false);

//        Crear Panel con tabla adentro
        JPanel panelTabla = new JPanel();
        panelTabla.setLayout(new BorderLayout(10,10));
        panelTabla.setBorder(BorderFactory.createTitledBorder("Panel con Tabla"));

//        Crear modelo de tabla con columnas
        modelo= new MyTableModel();
        modelo.addColumn("Id");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Fecha nacimiento");
        modelo.addColumn("Experiencia");

        tPersonas = new JTable(modelo);
        JScrollPane scrollPanel = new JScrollPane(tPersonas);
        panelTabla.add(scrollPanel,BorderLayout.CENTER);
        tPersonas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        // Esto permite seleccionar filas pero no columnas
        tPersonas.setRowSelectionAllowed(true);
        tPersonas.setColumnSelectionAllowed(false);

//        Crea panel con 3 botones sur
        JPanel panelBotones = new JPanel(new FlowLayout());
        panelBotones.setBorder(BorderFactory.createTitledBorder("Panel con Botones"));

        btnAgregar = new JButton("Agregar");
        btnEliminar = new JButton("Eliminar");
        btnActualizar = new JButton("Actualizar");

        panelBotones.add(btnAgregar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnActualizar);

//        Area de mensajes
        lblMensaje = new JLabel("",SwingConstants.CENTER);
        lblMensaje.setBorder(BorderFactory.createEtchedBorder());

//        Agregas los paneles al frame
        add(panelTabla,BorderLayout.CENTER);
        add(panelBotones,BorderLayout.SOUTH);
        add(lblMensaje,BorderLayout.NORTH);

//        Establece la conexion a base de datos
        conMysql = new ConexionMysql();
        con = conMysql.conectarMysql();
        if(con==null){
            JOptionPane.showMessageDialog(this, "No se pudo conectar a la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
        System.out.println("Se ha establecido la conexion a la base de datos");

        if(!cargarListaPersonas()){
//
            JOptionPane.showMessageDialog(null,
                    "Error al intentar cargar las personas",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        editarPersonas.iniciarVariables(this,con);
//        Desactiva  botones
        btnEliminar.setEnabled(false);
        btnActualizar.setEnabled(false);

//        Evento de los botones
//        Boton Agregar
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditarPersonas editarPersonas = new EditarPersonas();
                editarPersonas.setVisible(true);
                editarPersonas.iniciarVariables(VentanaPanel.this, con);
                desactivarControles();
                btnEliminar.setEnabled(false);
                btnActualizar.setEnabled(false);
            }
        });
//        Boton Eliminar
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] opciones = {"Sí", "No"};
                int resp = JOptionPane.showOptionDialog(null,
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
                int id = (int) modelo.getValueAt(row, 0);
                PreparedStatement ps;
                try{
                    ps = con.prepareStatement("DELETE FROM personas WHERE idpersonas = ?");
                    ps.setInt(1, id);
                    ps.executeUpdate();

                }catch(SQLException ex){
                    System.out.println(ex.getMessage());
//                    Mensaje para el usuario
                    lblMensaje.setText("Error al eliminar el producto");
                    JOptionPane.showMessageDialog(null,
                            "Error al intentar eliminar la persona seleccionada",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                modelo.removeRow(row);
                tPersonas.setModel(modelo);
                lblMensaje.setText("Producto eliminado");

                btnEliminar.setEnabled(false);
                btnActualizar.setEnabled(false);
            }
        });
//        Boton Actualizar
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelo.setRowCount(0);
                lblMensaje.setText("Tabla limpia");
            }
        });

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
                if(e.getValueIsAdjusting()){//Esto evita eventos duplicados
                    int filaSeleccionada = tPersonas.getSelectedRow();

                    if(filaSeleccionada!=-1){
                        System.out.println("Fila seleccionada: " + filaSeleccionada);

//                        Obtener datos de la fila seleccionada
                        Object id = modelo.getValueAt(filaSeleccionada, 0);
                        Object nombre = modelo.getValueAt(filaSeleccionada, 1);
                        Object apellidos = modelo.getValueAt(filaSeleccionada, 2);
                        Object fechaNacimiento = modelo.getValueAt(filaSeleccionada, 3);
                        Object experiencia = modelo.getValueAt(filaSeleccionada, 4);

                        System.out.println("Id: "+id);
                        System.out.println("Nombre: "+nombre);
                        System.out.println("Apellidos: "+apellidos);
                        System.out.println("Fecha de nacimiento: "+fechaNacimiento);
                        System.out.println("Experiencia: "+experiencia);

//                        Activar los botones Modificar y Eliminar
                        btnEliminar.setEnabled(true);
                        btnActualizar.setEnabled(true);
                    }else{
                        System.out.println("Ninguna fila seleccionada");
                        btnEliminar.setEnabled(false);
                        btnActualizar.setEnabled(false);
                    }

                }
            }
        });
    }
    private void cerrarAplicacion(){
        if(con!=null){
            conMysql.cerrarConexionMysql(con);
        }
        this.dispose();
        System.exit(0);
    }
    private boolean cargarListaPersonas(){
        Statement statement;
        ResultSet resultSet;
        Object[] fila;

        try{
            statement = con.createStatement();
            resultSet = statement.executeQuery(
                    "SELECT idpersonas, nombre, apellidos,fecha_nacimiento,experiencia" +
                            " FROM personas ORDER BY idpersonas");
            while(resultSet.next()){
                fila = new Object[5];
                for(int i=0;i<5;i++){
                    fila[i] = resultSet.getObject(i+1);
                }
                modelo.addRow(fila);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public void desactivarControles(){
        btnAgregar.setEnabled(false);
        tPersonas.setEnabled(false);
    }


   public void  activarControles(){
        btnAgregar.setEnabled(true);
        tPersonas.setEnabled(true);
    }
    public class MyTableModel extends DefaultTableModel {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    }
}
