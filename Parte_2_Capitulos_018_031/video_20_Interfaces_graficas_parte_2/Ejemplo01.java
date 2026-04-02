import javax.swing.*;
import java.awt.*;

public class Ejemplo01 extends JFrame{
    public Ejemplo01(){
//        Inicializar la ventana
        super("Ejemplo usuando FlowLayout");
       izquierda();
//       derecha();

    }
    public void izquierda(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,200);
        setLocationRelativeTo(null);

//        Configurar el layout
        setLayout(new FlowLayout(FlowLayout.LEFT,10,20));

//        Agregar los 4 botones
        int i;
        String str;
        for(i=1;i<=4;i++){

            str= "Boton "+i;
            add(new JButton(str));

        }
    }

    public void derecha(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,200);
        setLocationRelativeTo(null);

//        Configurar el layout
        setLayout(new FlowLayout(FlowLayout.RIGHT,10,20));

//        Agregar los 4 botones
        int i;
        String str;
        for(i=1;i<=4;i++){

            str= "Boton "+i;
            add(new JButton(str));

        }
    }

    public static void main(String args[]){
        Ejemplo01 ventana = new Ejemplo01();
        ventana.setVisible(true);
    }
}