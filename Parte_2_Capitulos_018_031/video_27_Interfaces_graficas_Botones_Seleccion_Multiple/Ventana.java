import javax.swing.*;
import javax.swing.event.*;

public class Ventana extends JFrame implements ChangeListener {
    private JCheckBox check1,check2,check3,check4;
    private JLabel label1,label2;

    public Ventana(){
//        Inicializar la ventana
        super("Ejemplo de botones de selección múltiple");
        setBounds(0,0,450,220);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

//        Agregar el check 1
        check1 = new JCheckBox("Regla");
        check1.setBounds(10,10,150,30);
        add(check1);

//        Agregar el check 2
        check2 = new JCheckBox("Compas");
        check2.setBounds(10,50,150,30);
        add(check2);

//        Agregar el check 3
        check3 = new JCheckBox("Escalimetro");
        check3.setBounds(10,90,150,30);
        add(check3);

//        Agregar el check 4
        check4 = new JCheckBox("Sacapuntas");
        check4.setBounds(10,130,150,30);
        add(check4);

//        Agregar la etiqueta 1
        label1 = new JLabel("Materiales a usar");
        label1.setBounds(180,10,250,30);
        add(label1);

//        Agregar la etiqueta 2
        label2 = new JLabel("");
        label2.setBounds(180,50,250,30);
        add(label2);

//        Agregar los eventos de la ventana principal
        check1.addChangeListener(this);
        check2.addChangeListener(this);
        check3.addChangeListener(this);
        check4.addChangeListener(this);
    }
    public void stateChanged(ChangeEvent e){
        String str = "";

        if(check1.isSelected()){
            str = "Regla";
        }
        if(check2.isSelected()){
            if(str.length()>0){
                str += ", ";
            }
            str += "Compas";
        }
        if(check3.isSelected()){
            if(str.length()>0){
                str += ", ";
            }
            str += "Escalimetro";
        }
        if(check4.isSelected()){
            if(str.length()>0){
                str += ", ";
            }
            str += "Sacapuntas";
        }
        label2.setText(str);
    }
    public static void main(String args[]){
        Ventana ventana;
        ventana = new Ventana();
        ventana.setVisible(true);
    }
}