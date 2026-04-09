import javax.swing.*;
import java.awt.event.*;
import java.io.FileReader;
import java.io.BufferedReader;

public class Ventana extends JFrame implements ActionListener{
    private JScrollPane panel;
    private JTextArea texto;
    private JButton cargar;

    public Ventana(){
//        Inicializar Ventana
        super("Lectura de un fichero");
        setBounds(0,0,440,350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

//        Agregar el area de texto
        texto = new JTextArea();
        panel = new JScrollPane(texto);
        panel.setBounds(10,10,400,250);
        add(panel);

//        Agregar el boton
        cargar = new JButton("Cargar");
        cargar.setBounds(160,270,90,20);
        add(cargar);

        cargar.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()== cargar){
            cargarFichero();
        }
    }
    public void cargarFichero(){
        FileReader file = null;
        BufferedReader buffer = null;
        String linea, contenido="",mensajeError="";
        try{
            file = new FileReader("fichero.txt");
            buffer = new BufferedReader(file);

            while((linea = buffer.readLine())!= null){
                contenido+=linea + "\n";
            }

        }catch(Exception e){
            mensajeError="Error al cargar el fichero\n";
            texto.setText(mensajeError);
            return;
        }finally{
            try {
                buffer.close();
                file.close();
            }catch(Exception e){
                mensajeError+="Error al cerrar el fichero";
                texto.setText(mensajeError);
            }
        }
        texto.setText(contenido);
    }
    public static void main(String[] args){
        Ventana ventana = new Ventana();
        ventana.setVisible(true);
    }
}