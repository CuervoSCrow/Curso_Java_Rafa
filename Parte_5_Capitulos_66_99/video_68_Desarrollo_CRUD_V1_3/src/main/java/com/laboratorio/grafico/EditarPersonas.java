package com.laboratorio.grafico;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.text.ParseException;

public class EditarPersonas extends JFrame {

    private VentanaPanel ventana;
    private Connection con;
    private int idPersona;

    public EditarPersonas() {
        initComponents();


    }
    public void iniciarVariables(VentanaPanel ventana,Connection con){
        this.ventana = ventana;
        this.con = con;
    }
    private void initComponents(){
        // Configuración de la ventana principal
        setTitle("Edicion de los datos");
        setAlwaysOnTop(true);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        // Panel principal con ancho fijo de 380px
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setPreferredSize(new Dimension(380, 250));
        panelPrincipal.setLayout(new BorderLayout(10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Panel para el formulario (GridBagLayout para mejor organización)
        JPanel panelFormulario = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Creación de los componentes
        // 1. Nombres
        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel lblNombres = new JLabel("Nombres:");
        lblNombres.setFont(new Font("Arial", Font.BOLD, 12));
        panelFormulario.add(lblNombres, gbc);

        gbc.gridx = 1;
        JTextField txtNombres = new JTextField(15);
        panelFormulario.add(txtNombres, gbc);

        // 2. Apellidos
        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel lblApellidos = new JLabel("Apellidos:");
        lblApellidos.setFont(new Font("Arial", Font.BOLD, 12));
        panelFormulario.add(lblApellidos, gbc);

        gbc.gridx = 1;
        JTextField txtApellidos = new JTextField(15);
        panelFormulario.add(txtApellidos, gbc);

        // 3. Fecha de Nacimiento
        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel lblFechaNac = new JLabel("Fecha Nacimiento:");
        lblFechaNac.setFont(new Font("Arial", Font.BOLD, 12));
        panelFormulario.add(lblFechaNac, gbc);

        gbc.gridx = 1;
        JFormattedTextField txtFechaNac = new JFormattedTextField();
        txtFechaNac.setColumns(15);
        txtFechaNac.setToolTipText("Ejemplo: 15/05/1990");
        panelFormulario.add(txtFechaNac, gbc);

        // 4. Años de experiencia
        gbc.gridx = 0;
        gbc.gridy = 3;
        JLabel lblAniosExp = new JLabel("Años de experiencia:");
        lblAniosExp.setFont(new Font("Arial", Font.BOLD, 12));
        panelFormulario.add(lblAniosExp, gbc);

        gbc.gridx = 1;
        JTextField txtAniosExp = new JTextField(15);
        panelFormulario.add(txtAniosExp, gbc);

        // Panel para los botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBackground(new Color(76, 175, 80));
        btnGuardar.setForeground(Color.WHITE);
        btnGuardar.setFont(new Font("Arial", Font.BOLD, 12));
        btnGuardar.setFocusPainted(false);
        btnGuardar.setEnabled(false);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBackground(new Color(244, 67, 54));
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setFont(new Font("Arial", Font.BOLD, 12));
        btnCancelar.setFocusPainted(false);

        // Acciones de los botones
//        Boton Guardar
        btnGuardar.addActionListener((ActionEvent e) -> {
            String nombres = txtNombres.getText();
            String apellidos = txtApellidos.getText();
            String fechaNac = txtFechaNac.getText();
            String aniosExp = txtAniosExp.getText();

            // Validación básica
            if (nombres.isEmpty() || apellidos.isEmpty() || fechaNac.isEmpty() || aniosExp.isEmpty()) {
                JOptionPane.showMessageDialog(panelPrincipal,
                        "Por favor, complete todos los campos",
                        "Campos incompletos",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                String mensaje = String.format("Datos guardados:\nNombres: %s\nApellidos: %s\nFecha Nacimiento: %s\nAños experiencia: %s",
                        nombres, apellidos, fechaNac, aniosExp);
                JOptionPane.showMessageDialog(panelPrincipal, mensaje, "Información guardada", JOptionPane.INFORMATION_MESSAGE);

                // Opcional: limpiar campos después de guardar
                // limpiarCampos(txtNombres, txtApellidos, txtFechaNac, txtAniosExp);
            }
            ventana.activarControles();

        });

//        Boton Cancelar
        btnCancelar.addActionListener((ActionEvent e) -> {
            int confirm = JOptionPane.showConfirmDialog(panelPrincipal,
                    "¿Está seguro de que desea cancelar? Se perderán los datos ingresados.",
                    "Confirmar cancelación",
                    JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                limpiarCampos(txtNombres, txtApellidos, txtFechaNac, txtAniosExp);
                JOptionPane.showMessageDialog(panelPrincipal, "Formulario cancelado y limpiado", "Cancelado", JOptionPane.INFORMATION_MESSAGE);
            }
            ventana.activarControles();
            setVisible(false);
        });

        //        Evento keyTyped para Nombres
        txtNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                btnGuardar.setEnabled(validarDatos());
            }
        });
        txtApellidos.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                btnGuardar.setEnabled(validarDatos());
            }
        });
        txtFechaNac.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                btnGuardar.setEnabled(validarDatos());
            }
        });
        panelBotones.add(btnGuardar);
        panelBotones.add(btnCancelar);

        // Agregar paneles al panel principal
        panelPrincipal.add(panelFormulario, BorderLayout.CENTER);
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);

        // Agregar el panel principal a la ventana
        add(panelPrincipal);

        // Ajustar tamaño de la ventana
        pack();
        setLocationRelativeTo(null); // Centrar en pantalla

        MaskFormatter formatoFecha = null;
        MaskFormatter formatoNumero = null;


        try{
            formatoFecha = new MaskFormatter("##/##/####");
            formatoFecha.setPlaceholderCharacter('_');
            formatoNumero = new MaskFormatter("##");
            formatoNumero.setPlaceholderCharacter(' ');
        }catch(ParseException e){
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null,
                    "Error al iniciar el formulario de personas",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        formatoFecha.install((JFormattedTextField) txtFechaNac);
        txtFechaNac.setColumns(10);
        formatoNumero.install((JFormattedTextField) txtAniosExp);
        txtAniosExp.setColumns(10);

    }

    private void limpiarCampos(JTextField... campos) {
        for (JTextField campo : campos) {
            campo.setText("");
        }
    }
    private boolean validarDatos() {
        return true;
    }
}
