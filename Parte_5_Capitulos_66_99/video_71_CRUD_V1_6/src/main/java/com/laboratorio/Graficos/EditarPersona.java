package com.laboratorio.Graficos;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.text.ParseException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EditarPersona extends JFrame{
    JTextField txtNombre;
    JTextField txtApellido;
    JFormattedTextField txtFechaNac;
    JFormattedTextField txtExperiencia;
    JButton bGuardar;
    JButton bCancelar;

    private boolean prueba=true;
    private ListaPersonas ventana;
    private Connection con;
    private int idPersona; //0= Insercción, otro valor = Modificación

    public EditarPersona(){

        initComponents();

        MaskFormatter formatoFecha=null;
        MaskFormatter formatoNumero=null;

        try{
            formatoFecha= new MaskFormatter("##/##/####");
            formatoFecha.setPlaceholderCharacter('_');
            formatoNumero= new MaskFormatter("##");
            formatoNumero.setPlaceholderCharacter(' ');
        }catch(ParseException e){
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null,
                    "Error al intentar inicicar el formulario de Personas.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        formatoFecha.install((JFormattedTextField) txtFechaNac);
        txtFechaNac.setColumns(10);
        formatoNumero.install((JFormattedTextField) txtExperiencia);
        txtExperiencia.setColumns(2);
        bGuardar.setEnabled(false);

    }

    private boolean cargarDatosPersona(){
        Statement statement;
        ResultSet resultSet;
        String str;
        Date fechaTemp;
        DateTimeFormatter formatoFecha= DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try{
            statement=con.createStatement();
            str="SELECT idpersonas,nombre,apellidos,fecha_nacimiento,experiencia " +
                    "FROM personas WHERE idpersonas = "+idPersona;
            resultSet= statement.executeQuery(str);
            if(resultSet.next()){
                txtNombre.setText(resultSet.getString("nombre"));
                txtApellido.setText(resultSet.getString("apellidos"));
                fechaTemp = resultSet.getDate("fecha_nacimiento");
                LocalDate fechaNac = fechaTemp.toLocalDate();
                str = fechaNac.format(formatoFecha);
                txtFechaNac.setText(str);
                str = Integer.toString(resultSet.getInt("experiencia"));
                txtExperiencia.setText(str);
            }else{
                System.out.println("Error Persona no encontrada");
                return false;
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());

            return false;
        }
        return true;
    }

    public void iniciarFormulario(int idPersona){
        this.idPersona=idPersona;
        if(idPersona==0) {
            txtNombre.setText("");
            txtApellido.setText("");
            txtFechaNac.setText("");
            txtExperiencia.setText("");
            bGuardar.setEnabled(false);
        }else{
            if(!cargarDatosPersona()){
                JOptionPane.showMessageDialog(
                        null,
                        "Error al cargar los datos de la persona",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }

    public void iniciarVariables(ListaPersonas ventana, Connection con){
        this.ventana=ventana;
        this.con=con;
    }


    public void initComponents(){
        setTitle("Registro de una Persona");
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);
        setAlwaysOnTop(true);


//        JPanel
        JPanel panelPrincipal = new JPanel(new GridBagLayout());
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        GridBagConstraints gbcP = new GridBagConstraints();
        gbcP.insets = new Insets(6, 6, 6, 6);
        gbcP.fill = GridBagConstraints.HORIZONTAL;
        gbcP.anchor = GridBagConstraints.NORTHWEST;

//        Panel del formulario
        JPanel panelFormulario = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets =new Insets(6,6,6,6);
        gbc.anchor=GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

//        Labels y Campos de Texto
//        Nombre
        gbc.gridx=0; gbc.gridy=0;
        panelFormulario.add(new JLabel("Nombre: "),gbc);
        txtNombre = new JTextField(15);
        gbc.gridx=1;
        panelFormulario.add(txtNombre,gbc);
//        Apellidos
        gbc.gridx=0; gbc.gridy=1;
        panelFormulario.add(new JLabel("Apellidos: "),gbc);
        txtApellido = new JTextField(12);
        gbc.gridx=1;
        panelFormulario.add(txtApellido,gbc);
//        Fecha de Nacimiento
        gbc.gridx=0; gbc.gridy=2;
        panelFormulario.add(new JLabel("Fecha Nacimiento"),gbc);
        txtFechaNac = new JFormattedTextField();
        txtFechaNac.setToolTipText("Ejemplo: 15/05/1990");
        gbc.gridx=1;
        panelFormulario.add(txtFechaNac,gbc);
//        Experiencia
        gbc.gridx=0; gbc.gridy=3;
        panelFormulario.add(new JLabel("Experiencia: "),gbc);
        txtExperiencia = new JFormattedTextField();
        gbc.gridx=1;
        panelFormulario.add(txtExperiencia,gbc);

//        Panel para los botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER,20,10));
//        Boton Guardar
        bGuardar = new JButton("Guardar");
        bGuardar.setBackground(new Color(76,175,80));
        bGuardar.setForeground(Color.WHITE);
        bGuardar.setFont(new Font("Arial",Font.BOLD,12));
        bGuardar.setFocusPainted(false);
        bGuardar.setEnabled(false);
//Boton Cancelar
        bCancelar = new JButton("Cancelar");
        bCancelar.setBackground(new Color(244,67,54));
        bCancelar.setForeground(Color.WHITE);
        bCancelar.setFont(new Font("Arial",Font.BOLD,12));
        bCancelar.setFocusPainted(false);

        panelBotones.add(bGuardar);
        panelBotones.add(bCancelar);

//        Agrega los paneles al panel Principal
        gbcP.gridx=0; gbcP.gridy=0; gbcP.weighty=1.0;
        panelPrincipal.add(panelFormulario,gbcP);

        gbcP.gridx=0; gbcP.gridy=1; gbcP.weighty=0;
        panelPrincipal.add(panelBotones,gbcP);

//        agrega el panel principal al Frame
        add(panelPrincipal);
//        Ajustar el tamaño a la ventana
        pack();

//        Eventos
//        Listener
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void  windowClosing(WindowEvent e){
                System.exit(0);
            }
        });

        bCancelar.addActionListener((ActionEvent e)->{
            setVisible(false);
            ventana.desactivarBotones();
        });

        bGuardar.addActionListener((ActionEvent e)->{
            String nombres,apellido,str;
            LocalDate fechaNac;
            int experiencia;
            DateTimeFormatter formatoFecha=
                    DateTimeFormatter.ofPattern("dd/MM/yyyy");

//            Obtiene los datos del formulario
            nombres = txtNombre.getText();
            apellido = txtApellido.getText();
            str = txtFechaNac.getText();
            try{
                fechaNac = LocalDate.parse(str,formatoFecha);
            }catch(DateTimeException ex){
                System.out.println(ex.getMessage());
                JOptionPane.showMessageDialog(null,
                        "Fecha invalida. Favor de introducir una fecha valida antes de guardar",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                System.out.println(ex.getMessage());
                fechaNac = null;
                return ;
            }
            str=txtExperiencia.getText().trim();
            experiencia =str.isEmpty()?0:Integer.parseInt(str);

            if(idPersona==0) {

                if (!crearPersona(nombres, apellido, fechaNac, experiencia)) {
                    JOptionPane.showMessageDialog(this,
                            "Error al crear la persona",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }else{
                if(!editarPersona(nombres,apellido,fechaNac,experiencia)){
                    JOptionPane.showMessageDialog(this,
                            "Error al editar la persona",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

            }
            ventana.desactivarBotones();
            ventana.actualizarTabla();
            iniciarFormulario(idPersona);
            setVisible(false);
        });

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                bGuardar.setEnabled(validarDatos());
            }
        });
        txtApellido.addKeyListener( new java.awt.event.KeyAdapter(){
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt){
                bGuardar.setEnabled(validarDatos());
            }
        });
        txtFechaNac.addKeyListener(new java.awt.event.KeyAdapter(){
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt){
                bGuardar.setEnabled(validarDatos());
            }
        });
        txtExperiencia.addKeyListener(new java.awt.event.KeyAdapter(){
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt){
                bGuardar.setEnabled(validarDatos());
            }
        });
    }

    private boolean crearPersona(String nombre,
                                 String apellido,
                                 LocalDate fechaNac,
                                 int experiencia){
        PreparedStatement preparedStatement;
        try{
//            Iniciar la transaccion
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement("INSERT INTO personas " +
                    "(nombre, apellidos, fecha_nacimiento, experiencia) " +
                    "VALUES (?, ?, ?, ?)");
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, apellido);
            preparedStatement.setDate(3, Date.valueOf(fechaNac));
            preparedStatement.setInt(4, experiencia);
            preparedStatement.execute();

//            confirmar la transaccion
            con.commit();


        }catch(Exception e){
            System.out.println(e.getMessage());
            try{
                con.rollback();
            }catch(Exception e2){
                System.out.println(e2.getMessage());
            }
            return false;
        }

        return true;

    }

    private boolean editarPersona(String nombre,
                                  String apellidos,
                                  LocalDate fechaNac,
                                  int experiencia){
        PreparedStatement preparedStatement;
        try{
//            Iniciar la transacción
            con.setAutoCommit(false);
            preparedStatement=con.prepareStatement(
                    "UPDATE personas set " +
                            "nombre=?, " +
                            "apellidos=?, " +
                            "fecha_nacimiento=?, " +
                            "experiencia=? " +
                            "where idpersonas=? ");
            System.out.println("Este es el idPersona "+idPersona);
            preparedStatement.setString(1,nombre);
            preparedStatement.setString(2,apellidos);
            preparedStatement.setDate(3,Date.valueOf(fechaNac));
            preparedStatement.setInt(4,experiencia);
            preparedStatement.setInt(5, idPersona);
            preparedStatement.execute();
//            Confirmar la transacción
            con.commit();
            idPersona=0;
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
//            Revertir la transacción
            try{
                con.rollback();
            }catch(SQLException ex2){
                System.out.println(ex2.getMessage());
            }
            return false;
        }
        return true;
    }

    private boolean validarDatos(){

        if(txtNombre.getText().isEmpty()){
            return false;
        }
        if(txtApellido.getText().isEmpty()){
            return false;
        }
        String str=txtFechaNac.getText();

        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try{
            LocalDate fechaNac = LocalDate.parse(str,formatoFecha);
        }catch(Exception e){
            return false;
        }
        System.out.println(txtExperiencia.getText().trim());
        if(txtExperiencia.getText().isEmpty()){
            System.out.println("Experiencia no puede estar vacia");
            return false;
        }
        prueba=true;
        System.out.println(prueba);

        return true;
    }
}
