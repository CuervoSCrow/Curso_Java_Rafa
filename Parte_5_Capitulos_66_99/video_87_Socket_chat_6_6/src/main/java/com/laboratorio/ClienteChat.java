package com.laboratorio;

import com.laboratorio.cliente.Cliente;
import com.laboratorio.cliente.Contacto;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

public class ClienteChat extends JFrame {
    private JTextField tNombre;
    private JButton bConectar;
    private JTextArea tEventos;
    private JList<String> lParticipantes;
    private DefaultListModel<String> modelo;

    private Cliente cliente;
    public ClienteChat(){
        initComponents();
        this.cliente=null;
        this.modelo = new DefaultListModel<>();
    }

    public void initComponents(){        // Declaración de componentes

        JTextField tMensaje;
        JButton bEnviar;
        JButton bCerrar;

        // Configuración del JFrame
        setTitle("Ventana de Participantes");
        setSize(600, 500);
        setResizable(false); // No redimensionable
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar en pantalla

        // Crear el panel principal con BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // ========== PANEL SUPERIOR ==========
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));

        JLabel lblNombre = new JLabel("Nombre:");
        tNombre = new JTextField(15);
        bConectar = new JButton("Conectar");
        bConectar.setEnabled(false); // Deshabilitado inicialmente

        topPanel.add(lblNombre);
        topPanel.add(tNombre);
        topPanel.add(bConectar);

        // ========== PANEL CENTRAL ==========
        JPanel centerPanel = new JPanel(new GridLayout(1, 2, 10, 10));

        // Panel izquierdo (Participantes)
        JPanel leftPanel = new JPanel(new BorderLayout(5, 5));
        JLabel lblParticipantes = new JLabel("Participantes:");
        lParticipantes = new JList<>();
        lParticipantes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lParticipantes.setModel(new DefaultListModel<>()); // Sin contenido inicial
        JScrollPane scrollParticipantes = new JScrollPane(lParticipantes);

        leftPanel.add(lblParticipantes, BorderLayout.NORTH);
        leftPanel.add(scrollParticipantes, BorderLayout.CENTER);

        // Panel derecho (Eventos)
        JPanel rightPanel = new JPanel(new BorderLayout(5, 5));
        JLabel lblEventos = new JLabel("Eventos:");
        tEventos = new JTextArea(10, 20);
        tEventos.setEnabled(false); // Deshabilitado
        tEventos.setLineWrap(true);
        tEventos.setWrapStyleWord(true);
        JScrollPane scrollEventos = new JScrollPane(tEventos);

        rightPanel.add(lblEventos, BorderLayout.NORTH);
        rightPanel.add(scrollEventos, BorderLayout.CENTER);

        centerPanel.add(leftPanel);
        centerPanel.add(rightPanel);

        // ========== PANEL INFERIOR (Mensaje) ==========
        JPanel messagePanel = new JPanel(new BorderLayout(10, 5));
        messagePanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        JPanel messageInputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        JLabel lblMensaje = new JLabel("Mensaje:");
        tMensaje = new JTextField(30);
        tMensaje.setEnabled(false); // Deshabilitado inicialmente
        bEnviar = new JButton("Enviar");
        bEnviar.setEnabled(false); // Deshabilitado inicialmente

        messageInputPanel.add(lblMensaje);
        messageInputPanel.add(tMensaje);
        messageInputPanel.add(bEnviar);

        messagePanel.add(messageInputPanel, BorderLayout.CENTER);

        // ========== PANEL DE BOTONES INFERIOR ==========
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        bCerrar = new JButton("Cerrar");
        bottomPanel.add(bCerrar);

        // ========== ENSAMBLAJE FINAL ==========
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(messagePanel, BorderLayout.SOUTH);

        // Agregar todo al frame
        add(mainPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        // ========== EVENTOS VACÍOS (sin implementación) ==========

//        Evento boton conectar
        bConectar.addActionListener(e -> {
            tNombre.setEnabled(false);
            bConectar.setEnabled(false);
//            Activar los demás controles
            try{
                cliente = new Cliente(this,"127.0.0.1",2486,tNombre.getText());
                cliente.start();
                System.out.println("usuario nuevo");
            }catch(Exception ex){
                JOptionPane.showMessageDialog(ClienteChat.this,
                        "Error al establecer al conexión con el servidor: " + ex.getMessage(),
                        "Error de conexión",
                        JOptionPane.ERROR_MESSAGE);
                System.exit(1);
                return;
            }
            agregarEvento("Se ha establecido la conexión");
            lParticipantes.setEnabled(true);
        });

        bEnviar.addActionListener(e -> {
            // Evento vacío del botón Enviar
        });

        bCerrar.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(ClienteChat.this,
                    "¿Estás seguro que deseas salir?", "Confirmar salida",
                    JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                if(this.cliente!=null){
                    cliente.desconectar();
                }
                System.exit(0);
            }
        });
//        Evento letras en tNombre
        tNombre.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if(tNombre.getText().length()>2){
                    bConectar.setEnabled(true);
                }else{
                    bConectar.setEnabled(false);
                }
            }
        });

//        Evento de seleccion de participante
        lParticipantes.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int sel=lParticipantes.getSelectedIndex();
                if(sel==-1){
                    tMensaje.setEnabled(false);
                }else{
                    tMensaje.setEnabled(true);
                }
            }
        });
//          EVENTO CUANDO SE TECLEA EL MENSAJE A ENVIAR
        tMensaje.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String str = tMensaje.getText().trim();
                if(str.length()>0){
                    bEnviar.setEnabled(true);
                }else{
                    bEnviar.setEnabled(false);
                }
            }
        } );
//        BOTON ENVIAR
        bEnviar.addActionListener(e -> {
            int sel = lParticipantes.getSelectedIndex();
            if(sel==-1){
                return;
            }
            String str= tMensaje.getText().trim();
            if(str.length()==0){
                return;
            }
            cliente.enviarMensaje(sel,str);

        });
    }

    public void agregarEvento(String mensaje){
        String texto=tEventos.getText();
        texto += mensaje+'\n';
        tEventos.setText(texto);
    }

    public void actualizarLista(){
        List<Contacto> contactos = this.cliente.getContactos();
        modelo.clear();
        for (Contacto c: contactos){
            modelo.addElement(c.getNombre());
        }

        lParticipantes.setModel(modelo);
    }

    public void mensajeError(String mensaje){
        JOptionPane.showMessageDialog();
    }

    public void cerrarVentana(int modo){
        if(modo!=0){
            JOptionPane.showMessageDialog(
                    null,
                    "Ha ocurrido un error inesperado, se cerrara la aplicación",
                    "Error de conexión",
                    JOptionPane.ERROR_MESSAGE);
        }
        System.exit(modo);

    }

    public static void main(String[] args) {
        ClienteChat clienteChat = new ClienteChat();
        clienteChat.setVisible(true);
    }
}
