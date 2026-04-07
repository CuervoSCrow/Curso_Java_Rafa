import javax.swing.*;
import javax.swing.event.*;
import java.util.List;

public class Ventana extends JFrame implements ListSelectionListener{
    private JList<String> lista;
    private JScrollPane panel;
    private JLabel label1, label2;

    public Ventana(){
//        Inicializar la ventana
        super("Ejemplo de lista");
        setBounds(0,0,450,230);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

//        Agregar la lista
        String dias[]={"Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo"};
        lista = new JList<>(dias);
        lista.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        panel = new JScrollPane(lista);
        panel.setBounds(10,10,150,100);
        add(panel);

//        Agregar etiqueta 1
        label1 = new JLabel("Posición: ");
        label1.setBounds(10,120,420,30);
        add(label1);
        //        Agregar etiqueta 2
        label2 = new JLabel("Posición Seleccionada: ");
        label2.setBounds(10,160,420,30);
        add(label2);

//  Agregar los eventos de la ventana principal
        lista.addListSelectionListener(this);
    }

    public void valueChanged(ListSelectionEvent e){
        if(e.getSource()== lista){
            List seleccion;
            int i,sel[];
            String etiqueta1, etiqueta2;

//            Construcción de la etiqueta 1
            seleccion = lista.getSelectedValuesList();
            etiqueta1 = "Seleccion: ";
            for(i=0; i<seleccion.size();i++){
                etiqueta1 +=seleccion.get(i).toString();
                if(i+1<seleccion.size()){
                    etiqueta1+=", ";
                }
            }
            label1.setText(etiqueta1);
//            Construcción de la etiqueta2
            sel = lista.getSelectedIndices();
            etiqueta2 ="Posición Seleccionada: ";
            for(i=0;i<sel.length;i++)   {
                etiqueta2 += Integer.toString(sel[i]+1);
                if(i+1<sel.length){
                    etiqueta2 += ", ";
                }
            }
            label2.setText(etiqueta2);

        }
    }
    public static void main(String[] args){
        Ventana  ventana= new Ventana();
        ventana.setVisible(true);
    }
}