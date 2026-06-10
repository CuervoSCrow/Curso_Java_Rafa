package com.laboratorio;

import com.laboratorio.eventos.ListaPeticiones;
import com.laboratorio.peticion.PeticionCurrencies;
import com.laboratorio.peticion.PeticionLatest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    public static void main(String[] args) {
        Logger logger = LogManager.getLogger(Main.class);
        ListaPeticiones peticiones = new ListaPeticiones();
        boolean seguir = true;

        PeticionLatest pl = new PeticionLatest(peticiones);
        PeticionCurrencies pc = new PeticionCurrencies(peticiones);

        Thread hilo = new Thread(peticiones);
        hilo.start();

        pl.add(1);
        pc.add(2);
        pl.add(3);
        pl.add(4);
        pc.add(5);
        pc.add(6);

        int ciclos=0;
        do{
            if(peticiones.getListSize()<=0){
                seguir=false;
            }
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                logger.error("Error: ", e);
            }
            ciclos++;
            logger.info("[APP] Ciclo: "+ciclos);
        }while(seguir);
        peticiones.detener();
        try{
            logger.info("[APP] Esperando finalizacion del hilo");
            hilo.join();
            logger.info("[APP] finalizando el programa ...");
        }catch(InterruptedException e){
            logger.error("Error: ", e);
        }
    }
}