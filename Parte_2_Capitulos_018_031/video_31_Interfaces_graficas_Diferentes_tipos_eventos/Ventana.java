import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;

public class Ventana extends JFrame implements ActionListener, ListSelectionListener{
    private JList<String> lista1,lista2;
    private JScrollPane panel1,panel2;
    private JButton agregar,quitar;
    private DefaultListModel<String> modelo1,modelo2;

    public Ventana(){
//        Inicializar la ventana
        super("Ejemplo de listas");
        setBounds(0,0,450,180);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

//        Agregar la lista 1
        lista1 = new JList<>();
        lista1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo1 = new DefaultListModel<>();
        modelo1.addElement("Lunes");
        modelo1.addElement("Martes");
        modelo1.addElement("Miercoles");
        modelo1.addElement("Jueves");
        modelo1.addElement("Viernes");
        modelo1.addElement("Sabado");
        modelo1.addElement("Domingo");
        lista1.setModel(modelo1);
        panel1 = new JScrollPane(lista1);
        panel1.setBounds(10,10,150,100);
        add(panel1);
//        Agregar la lista2
        lista2= new JList<>();
        lista2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo2 = new DefaultListModel<>();
        lista2.setModel(modelo2);
        panel2 = new JScrollPane(lista2);
        panel2.setBounds(240,10,150,100);
        add(panel2);
//        Agregar el boton 1
        agregar = new JButton(">>");
        agregar.setBounds(170,30,60,20);
        agregar.setEnabled(false);
        add(agregar);
//        Agregar el boton 2
        quitar=new JButton("<<");
        quitar.setBounds(170,60,60,20);
        quitar.setEnabled(false);
        add(quitar);
//  Agregar los eventos a la ventanaprincial
        lista1.addListSelectionListener(this);
        lista2.addListSelectionListener(this);
        agregar.addActionListener(this);
        quitar.addActionListener(this);
    }
    public void valueChanged(ListSelectionEvent e){
        int sel;
        //        Cambio de seleccion en la lista 1
        if(e.getSource()==lista1){
            sel = lista1.getSelectedIndex();
            if(sel==-1){
                agregar.setEnabled(false);
            }else{
                agregar.setEnabled(true);
            }
        }
//        Cambio de seleccion en la lista 2
        if(e.getSource()==lista2){
            sel=lista2.getSelectedIndex();
            if(sel==-1){
                quitar.setEnabled(false);
            }else{
                quitar.setEnabled(true);
            }
        }
    }
    public void actionPerformed(ActionEvent e){
        int sel;
//        Agregar un elemento a la segunda lista
        if(e.getSource()==agregar){
            sel=lista1.getSelectedIndex();
            modelo2.addElement(modelo1.elementAt(sel));
            lista2.setModel(modelo2);
            modelo1.removeElementAt(sel);
            lista1.setModel(modelo1);
        }
//        Quitar un elemento en la degunda lista
        if(e.getSource()==quitar){
            sel= lista2.getSelectedIndex();
            modelo1.addElement(modelo2.elementAt(sel));
            lista1.setModel(modelo1);
            modelo1.removeElementAt(sel);
            lista2.setModel(modelo2);
        }
    }
    public static void main(String[] args){
        Ventana ventana = new Ventana();
        ventana.setVisible(true);
    }
}