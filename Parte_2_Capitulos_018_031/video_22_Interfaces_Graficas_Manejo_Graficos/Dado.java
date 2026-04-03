package casino;

import javax.swing.*;
import java.awt.*;

public class Dado extends JPanel{
    private int numero;
    public void setNumero(int num){
        numero = num;
    }
    public void paintComponent(Graphics g){
        String str;
//        Crear Rectangulo blanco
        g.setColor(Color.white);
        g.fillRoundRect(5,5,120,120,5,5);

//        Crear un rectangulo negro con el borde negro y contenido blanco
        g.setColor(Color.black);
        g.drawRoundRect(5,5,120,120,5,5);

//    Dibujar el contenido del dado
    switch(numero){
        case 1:
            g.fillOval(55,55,20,20);
            break;
        case 2:
            g.fillOval(20,20,20,20);
            g.fillOval(90,90,20,20);
            break;
        case 3:
            g.fillOval(20,20,20,20);
            g.fillOval(55,55,20,20);
            g.fillOval(90,90,20,20);
            break;
        case 4:
            g.fillOval(20,20,20,20);
            g.fillOval(90,20,20,20);
            g.fillOval(20,90,20,20);
            g.fillOval(90,90,20,20);
            break;
        case 5:
            g.fillOval(20,20,20,20);
            g.fillOval(90,20,20,20);
            g.fillOval(55,55,20,20);
            g.fillOval(20,90,20,20);
            g.fillOval(90,90,20,20);
            break;
        case 6:
            g.fillOval(20,20,20,20);
            g.fillOval(20,55,20,20);
            g.fillOval(90,20,20,20);
            g.fillOval(20,90,20,20);
            g.fillOval(90,55,20,20);
            g.fillOval(90,90,20,20);
            break;
        default:
            str = Integer.toString(numero);
            g.drawString(str,60,60);
            break;
    }}

}
