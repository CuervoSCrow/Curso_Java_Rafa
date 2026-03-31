import java.util.Random;
public class Casino{
    public static void main(String args[]){

        int dado1,dado2;
        boolean ganaJugador,ganaCasino;
        Random numAleatorio = new Random();
        int i=0;
        int nFichas=20;
        int nJug=0;
        int nCas=0;
        while((nFichas>0)&&(nFichas<30)){
            i++;
            dado1 = numAleatorio.nextInt(6)+1;
            dado2 = numAleatorio.nextInt(6)+1;

            System.out.print(i+"- El valor de los dados es: "+dado1+
                    " y "+dado2+". ");


            if((dado1 == 6)&&(dado2==6)){
                ganaJugador=true;
                System.out.println("Gana el jugador.");
                nFichas++;
                nJug++;
            }else{
                ganaJugador=false;
            }
            if(((dado1==1)&&(dado2==2))||((dado1==2)&&(dado2==1))){
                ganaCasino=true;
                System.out.println("Gana el casino.");
                nFichas--;
                nCas++;
            }else{
                ganaCasino=false;
            }
            if(!ganaJugador && !ganaCasino){
                System.out.println("No hay ganador");
            }

        }
        System.out.println("");
        System.out.println("Resultados:");
        System.out.println("*******************************");
        System.out.println("El jugador tiene "+nFichas+" fichas.");
        System.out.println("El jugador jugo "+i+" partidas.");
        System.out.println("El jugador gano "+nJug+" partidas.");
        System.out.println("El jugador perdio "+nCas+" partidas");
    }
}