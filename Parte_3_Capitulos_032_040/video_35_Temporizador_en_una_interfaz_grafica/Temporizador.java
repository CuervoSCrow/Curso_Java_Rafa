import javax.swing.*;
import java.awt.event.*;

public class Temporizador extends JFrame implements ActionListener{
    private JList<String> lista;
    private JScrollPane panel;
    private DefaultListModel<String> modelo;
    private JButton mensaje;
    private Timer  timer1,timer2;

    public Temporizador(){
//        Inicializar la ventana
        super("Prueba de temporizador");
        setBounds(0,0,450,310);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

//        Agregar la lista
        lista= new JList<>();
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo= new DefaultListModel<>();
        lista.setModel(modelo);
        panel=new JScrollPane(lista);
        panel.setBounds(10,10,410,220);
        add(panel);
//        Agregaremos el boton;
        mensaje= new JButton("Escribir mensaje");
        mensaje.setBounds(130,240,160,20);
        add(mensaje);
        mensaje.addActionListener(this);

//        Creamos los Timer
        timer1 = new Timer(2000,this);
        timer1.setInitialDelay(1000);
        timer1.start();

        timer2 = new Timer(3000,this);
        timer2.setInitialDelay(1000);
        timer2.start();
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == mensaje){
            modelo.addElement("Mensaje desde el boton");
            lista.setModel(modelo);
        }
        if(e.getSource() == timer1){
            modelo.addElement("Mensaje desde el Timer 1");
            lista.setModel(modelo);
        }
        if(e.getSource() == timer2){
            modelo.addElement("Mensaje desde el Timer 2");
            lista.setModel(modelo);
        }
    }

    public static void main(String[] args){
        Temporizador temporizador = new Temporizador();
        temporizador.setVisible(true);
    }
}