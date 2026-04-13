import java.util.Timer;
import java.util.TimerTask;

public class Temporizador{
    private static Timer timer;
    public static void main(String args[]){
        Tarea tarea;
        int repeticion=0;
        try{
            timer = new Timer();
            tarea = new Tarea();
            timer.schedule(tarea,100,2000);
            do{
                repeticion++;
                System.out.println("Mensaje desde el programa principal "+repeticion);
                Thread.sleep(1000);
            }while(tarea.getContador()<5);
            timer.cancel();
        }catch(Exception e){
            System.out.println("Se ha producido un error al ejecutar la ventana");
        }
        System.out.println("Se ha finalizado el programa principal");
    }
    static class Tarea extends TimerTask{
        private int contador;
        public Tarea(){
            contador=0;
        }
        public void run(){
            contador ++;
            System.out.println("Mensaje desde el temporizador "+contador);
        }
        public int getContador(){
            return contador;
        }
    }
}