package com.laboratorio;

import com.laboratorio.servidor.Servidor;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ServidorChat extends JFrame {
    public ServidorChat() {
        initComponents();

        try{
            Servidor servidor = new Servidor(2468);
            servidor.startServer();
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
            System.exit(1);
        }
    }
    public void agregarEvento(String evento){
       
        String texto = eventosTextArea.getText();
        eventosTextArea.setText(texto + evento + "\n");
    }
    public void initComponents(){
        // Configuración del JFrame
        setTitle("Chat Colectivo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null); // Centrar ventana

        // Crear el panel principal con BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // ===== PANEL SUPERIOR (con "Participantes" en la parte superior derecha) =====
        JPanel topPanel = new JPanel(new BorderLayout());

        // Label "Participantes" alineado a la derecha
        JLabel participantesLabel = new JLabel("Participantes");
        participantesLabel.setFont(new Font("Arial", Font.BOLD, 14));
        participantesLabel.setHorizontalAlignment(SwingConstants.CENTER);
        topPanel.add(participantesLabel, BorderLayout.CENTER);

        mainPanel.add(topPanel, BorderLayout.NORTH);

        // ===== PANEL CENTRAL CON DIVISIÓN 50% - 50% =====
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setDividerLocation(0.5); // 50% para cada panel
        splitPane.setResizeWeight(0.5); // Ambos paneles se redimensionan proporcionalmente
        splitPane.setContinuousLayout(true);
        splitPane.setBorder(null);

        // ===== PANEL IZQUIERDO (Participantes) - 50% =====
        // Datos de ejemplo para participantes
        String[] participantes = {"Juan Pérez", "María García", "Carlos López",
                "Ana Martínez", "Luis Rodríguez", "Elena Sánchez",
                "Roberto Díaz", "Laura Torres", "Javier Moreno"};

        JList<String> participantesList = new JList<>(participantes);
        participantesList.setFont(new Font("Arial", Font.PLAIN, 12));
        participantesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane participantesScroll = new JScrollPane(participantesList);
        participantesScroll.setBorder(BorderFactory.createTitledBorder("Lista de participantes"));

        // ===== PANEL DERECHO (Eventos) - 50% =====
        JPanel rightPanel = new JPanel(new BorderLayout(5, 5));

        // Label "Eventos" en la parte superior del panel derecho
        JLabel eventosLabel = new JLabel("Eventos");
        eventosLabel.setFont(new Font("Arial", Font.BOLD, 14));
        eventosLabel.setHorizontalAlignment(SwingConstants.CENTER);
        rightPanel.add(eventosLabel, BorderLayout.NORTH);

        // JList para eventos (con scroll y deshabilitado)
        String[] eventos = {"Usuario Juan se ha conectado",
                "Nuevo mensaje en el chat",
                "María ha salido del chat",
                "Archivo compartido",
                "Carlos se ha unido a la conversación",
                "Ana ha enviado una imagen",
                "El servidor se ha reiniciado"};

        JList<String> eventosList = new JList<>(eventos);
        eventosList.setFont(new Font("Arial", Font.PLAIN, 12));
        eventosList.setEnabled(false); // DESHABILITADO
        eventosList.setBackground(new Color(240, 240, 240)); // Fondo gris claro para indicar deshabilitado

        JScrollPane eventosScroll = new JScrollPane(eventosList);
        eventosScroll.setBorder(BorderFactory.createTitledBorder("Historial de eventos"));

        rightPanel.add(eventosScroll, BorderLayout.CENTER);

        // Configurar el JSplitPane con ambos paneles
        splitPane.setLeftComponent(participantesScroll);
        splitPane.setRightComponent(rightPanel);

        mainPanel.add(splitPane, BorderLayout.CENTER);

        // ===== PANEL INFERIOR (Botón Salir) =====
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JButton salirButton = new JButton("Salir");
        salirButton.setFont(new Font("Arial", Font.BOLD, 12));
        salirButton.setBackground(new Color(220, 70, 70));
        salirButton.setForeground(Color.WHITE);
        salirButton.setFocusPainted(false);
        salirButton.setPreferredSize(new Dimension(100, 35));

        // Acción del botón salir
        salirButton.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(ServidorChat.this,
                    "¿Estás seguro que deseas salir?", "Confirmar salida",
                    JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });

        bottomPanel.add(salirButton);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        // Agregar el panel principal al frame
        add(mainPanel);
    }

    public static void main(String[] args) {
        // Ejecutar en el EDT (Event Dispatch Thread)
        SwingUtilities.invokeLater(() -> {
            ServidorChat ventana = new ServidorChat();
            ventana.setVisible(true);
        });
    }
}