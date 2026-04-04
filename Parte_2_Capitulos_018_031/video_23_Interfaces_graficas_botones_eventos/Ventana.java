
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import casino.Dado;

public class Ventana extends JFrame{
    private JButton lanzar;
    private Dado d1,d2;

    public Ventana(){
//        Inicializar la ventana
        super("Ejemplo de botones y eventos");
        setSize(440,180);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(1,3,5,5));
//        Añadimos el boton
        lanzar = new JButton("Lanzar");
        add(lanzar);
//        Asociar eventos al boton
        lanzar.addActionListener(new eventosVentana());

//        Añadir el dado 1
        d1 = new Dado();
        d1.setNumero(1);
        add(d1);

//        Añadir dado 2
        d2 = new Dado();
        d2.setNumero(1);
        add(d2);
    }
    public static void main(String[] args){
        Ventana ventana1;
        ventana1 = new Ventana();

        ventana1.setVisible(true);
    }
    class eventosVentana implements  ActionListener{
        public void actionPerformed(ActionEvent e){
//            lanzar los dados
            d1.lanzar();
            d2.lanzar();
        }
    }
}