import javax.swing.*;
import java.awt.*;

class Ventana extends JFrame{
    private JPanel p1,p2,p3;

    public Ventana(){
//        Inicializar la ventana
        super("Ejemplo usando Paneles");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,600);
        setLocationRelativeTo(null);

//        Configuramos el layout de la ventana principal
        setLayout(new GridLayout(3,1,10,10));

        int i;
        String str;

//        Crear panel 1 con sus componentes
        p1 = new JPanel();
        p1.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
        for(i=1;i<=4;i++){
            str="Boton "+i;
            p1.add(new JButton(str));
        }
//        Crear Panel 2 con sus componentes
        p2 = new JPanel();
        p2.setLayout(new BorderLayout(5,5));
        p2.add(new JButton("Este"),BorderLayout.EAST);
        p2.add(new JButton("Oeste"),BorderLayout.WEST);
        p2.add(new JButton("Norte"),BorderLayout.NORTH);
        p2.add(new JButton("Sur"),BorderLayout.SOUTH);
        p2.add(new JButton("Centro"),BorderLayout.CENTER);

//        CRear Panle 3 y sus componentes
        p3 = new JPanel();
        p3.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
        for(i=5;i<=8;i++){
            str="Boton "+i;
            p3.add(new JButton(str));
        }
//        Agregar paneles a la ventana princial
        add(p1);
        add(p2);
        add(p3);
    }
    public static void main(String args[]){
        Ventana ventana1;

        ventana1= new Ventana();
        ventana1.setVisible(true);
    }
}