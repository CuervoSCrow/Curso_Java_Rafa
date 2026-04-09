import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ventana extends JFrame implements ActionListener{
    private JMenuBar menuBar;
    private JMenu menu1,menu2,menu3, submenu;
    private JMenuItem opcion1_1, opcion1_2, opcion1_3;
    private JMenuItem opcion2_1, opcion2_2;
    private JMenuItem opcion3_1, opcion3_2,opcion3_3;
    private JLabel label;

    public Ventana(){
//        Inicializar la ventana
        super("Ejemplo de menu de opciones");
        setBounds(0,0,400,200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

//        Crear la barra de Menu
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

//        Creamos el primer menu
        menu1 = new JMenu("Menu 1");
        menuBar.add(menu1);
//        Agregar las opciones del menu1
        opcion1_1 = new JMenuItem("Opcion 1.1");
        menu1.add(opcion1_1);
        opcion1_2 = new JMenuItem("Opcion 1.2");
        menu1.add(opcion1_2);
        opcion1_3 = new JMenuItem("Opcion 1.3");
        menu1.add(opcion1_3);

//        Creamos el Segundo menu
        menu2 = new JMenu("Menu 2");
        menuBar.add(menu2);
//        Agrega las opciones del menu2
        opcion2_1 = new JMenuItem("Opcion 2.1");
        menu2.add(opcion2_1);
        opcion2_2 = new JMenuItem("Opcion 2.2");
        menu2.add(opcion2_2);
        //    Creamos el tercer menu
        menu3 = new JMenu("Menu 3");
        menuBar.add(menu3);
//    Agrega las opciones del menu3
        opcion3_1= new JMenuItem("Opcion 3.1");
        menu3.add(opcion3_1);
//        Creamos un submenu
        submenu = new JMenu("Submenu");
        menu3.add(submenu);
        opcion3_2= new JMenuItem("Opcion 3.2");
        submenu.add(opcion3_2);
        opcion3_3= new JMenuItem("Opcion 3.3");
        submenu.add(opcion3_3);

//        CRear la etiqueta
        label = new JLabel("Opcion Seleccionada: ");
        label.setBounds(20,50,400,30);
        add(label);

//        Asignar los eventos de la ventana principal
        opcion1_1.addActionListener(this);
        opcion1_2.addActionListener(this);
        opcion1_3.addActionListener(this);
        opcion2_1.addActionListener(this);
        opcion2_2.addActionListener(this);
        opcion3_1.addActionListener(this);
        opcion3_2.addActionListener(this);
        opcion3_3.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==opcion1_1){
            label.setText("Opcion 1.1");
        }
        if(e.getSource()==opcion1_2){
            label.setText("Opcion 1.2");
        }
        if(e.getSource()==opcion1_3){
            label.setText("Opcion 1.3");
        }
        if(e.getSource()==opcion2_1){
            label.setText("Opcion 2.1");
        }
        if(e.getSource()==opcion2_2){
            label.setText("Opcion 2.2");
        }
        if(e.getSource()==opcion3_1){
            label.setText("Opcion 3.1");
        }if(e.getSource()==opcion3_2){
            label.setText("Opcion 3.2");
        }if(e.getSource()==opcion3_3){
            label.setText("Opcion 3.3");
        }

    }


    public static void main(String args[]){
        Ventana ventana = new Ventana();
        ventana.setVisible(true);
    }
}
