
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import casino.Dado;

public class Ventana2 extends JFrame implements ActionListener{
    private JButton lanzarD1,lanzarD2,lanzarD3;
    private Dado d1,d2,d3;


    public Ventana2(){
//        Inicializar la ventana
        super("Ejemplo de botones y eventos");
        setSize(440,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(2,3,5,5));

//        Añadimos el boton
        lanzarD1 = new JButton("Lanzar dado 1");
        add(lanzarD1);
//       Asociar eventos al boton
        lanzarD1.addActionListener(this);


//        Añadimos el boton 1
        lanzarD2 = new JButton("Lanzar dado 2");
        add(lanzarD2);
//        Asociar eventos al boton 2
        lanzarD2.addActionListener(this);

//        Añadimos el boton
        lanzarD3 = new JButton("Lanzar dado 3");
        add(lanzarD3);
//        Asociar eventos al boton
        lanzarD3.addActionListener(this);

//        Añadir el dado 1
        d1 = new Dado();
        d1.setNumero(1);
        add(d1);

//        Añadir dado 2
        d2 = new Dado();
        d2.setNumero(1);
        add(d2);

//        Añadir el dado 3
        d3 = new Dado();
        d3.setNumero(1);
        add(d3);
    }
    public void actionPerformed(ActionEvent e){
//            lanzar los dados
        if(e.getSource()==lanzarD1) {
            d1.lanzar();
        }
        if(e.getSource()==lanzarD2) {
            d2.lanzar();
        }
        if(e.getSource()==lanzarD3){
            d3.lanzar();
        }
    }
    public static void main(String[] args){
        Ventana2 ventana1;
        ventana1 = new Ventana2();

        ventana1.setVisible(true);
    }
}