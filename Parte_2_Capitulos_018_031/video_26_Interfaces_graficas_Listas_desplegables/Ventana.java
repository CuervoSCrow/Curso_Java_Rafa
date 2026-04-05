import javax.swing.*;
import java.awt.event.*;

public class Ventana extends JFrame implements ItemListener{
    private JComboBox<String> combo;
    private JLabel label1,label2;

    public Ventana(){
//        Inicializar la ventana
        super("Lista desplegable");
        setBounds(0,0,350,180);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

//        Agregar el combobox
        combo = new JComboBox<>();
        combo.setBounds(10,10,150,30);
        add(combo);

//        Agregar los elementos del combo
        combo.addItem("Lápiz");
        combo.addItem("Boligrafo");
        combo.addItem("Pincel");
        combo.addItem("Pluma");
        combo.addItem("Crayón");

//        Agregar los eventos de la ventana principal
        combo.addItemListener(this);

//        Agregar la etiqueta 1
        label1 = new JLabel("Seleccion: Lapiz");
        label1.setBounds(10,50,200,30);
        add(label1);

//        Agregar la etiqueta 2
        label2 = new JLabel("Posición Seleccionada: 1");
        label2.setBounds(10,90,200,30);
        add(label2);
    }
    public void itemStateChanged(ItemEvent e){
        if(e.getSource() == combo){
            String seleccion, posicion;
            int sel;

            seleccion = combo.getSelectedItem().toString();
            label1.setText("Selección: "+seleccion);

            sel = combo.getSelectedIndex()+1;
            posicion = "Posición Seleccionada: "+sel;
            label2.setText(posicion);
        }
    }
    public static void main(String Args[]){
        Ventana ventana1;
        ventana1=new Ventana();
        ventana1.setVisible(true);
    }
}