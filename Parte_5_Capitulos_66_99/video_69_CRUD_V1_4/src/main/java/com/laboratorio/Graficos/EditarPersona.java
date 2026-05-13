package com.laboratorio.Graficos;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EditarPersona extends JFrame {
    JTextField txtNombre;
    JTextField txtApellido;
    JFormattedTextField txtFechaNac;
    JFormattedTextField txtExperiencia;
    JButton bGuardar;
    JButton bCancelar;

    private boolean prueba=true;
    private ListaPersonas ventana;
    private Connection con;

    public EditarPersona(){

        initComponents();
        MaskFormatter formatoFecha=null;
        MaskFormatter formatoNumero=null;
        try{
            formatoFecha= new MaskFormatter("##/##/####");
            formatoFecha.setPlaceholderCharacter('_');
            formatoNumero= new MaskFormatter("##");
            formatoNumero.setPlaceholderCharacter('_');
        }catch(Exception e){
            return;
        }
        formatoFecha.install((JFormattedTextField) txtFechaNac);
        txtFechaNac.setColumns(10);
        formatoNumero.install((JFormattedTextField) txtExperiencia);
        txtExperiencia.setColumns(2);
        bGuardar.setEnabled(false);

    }
    public void iniciarFormulario(){
        txtNombre.setText("");
        txtApellido.setText("");
        txtFechaNac.setText("");
        txtExperiencia.setText("");
        bGuardar.setEnabled(false);
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
            ventana.desactivarBotones();
            iniciarFormulario();
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

        if(txtExperiencia.getText().isEmpty()){
            return false;
        }
        prueba=true;
        System.out.println(prueba);
        System.out.println("Vamos por verdad");
        return true;
    }
}
