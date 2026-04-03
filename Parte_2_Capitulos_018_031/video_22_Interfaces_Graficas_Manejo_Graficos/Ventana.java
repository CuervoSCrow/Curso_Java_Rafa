import casino.Dado;
import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame{
    private Dado d1,d2,d3,d4,d5,d6;

    public Ventana(){
//        Inicicaliza Ventana
        super("Ejemplo con Graphics");
        setSize(820,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(1,6,5,5));

//        Agregar el dado1
        d1 = new Dado();
        d1.setNumero(1);
        add(d1);

//        Agregar el dado 2
        d2 = new Dado();
        d2.setNumero(2);
        add(d2);

//        Agregar el dado 3
        d3 = new Dado();
        d3.setNumero(3);
        add(d3);

//        Agregar el dado 4
        d4 = new Dado();
        d4.setNumero(4);
        add(d4);

//        Agregar el dado 5
        d5=new Dado();
        d5.setNumero(5);
        add(d5);

//        Agregar el dado 6
        d6 = new Dado();
        d6.setNumero(6);
        add(d6);
    }
    public static void main(String args[]){
        Ventana ventana;
        ventana = new Ventana();
        ventana.setVisible(true);
    }
}