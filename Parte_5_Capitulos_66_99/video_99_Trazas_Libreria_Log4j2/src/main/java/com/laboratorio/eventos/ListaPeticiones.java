package com.laboratorio.eventos;

import com.laboratorio.api.FrankFurteAPI;
import com.laboratorio.peticion.PeticionAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListaPeticiones implements Runnable{
    Logger logger = LogManager.getLogger(ListaPeticiones.class);
    private volatile boolean seguir;
    private final FrankFurteAPI frankFurteAPI;
    private final List<PeticionAPI> peticiones;
    private static ArrayList listeners;

    public ListaPeticiones() {
        this.seguir = true;
        this.frankFurteAPI = new FrankFurteAPI("https://api.frankfurter.dev/v1/");
        this.peticiones = new ArrayList<>();
        this.listeners = new ArrayList<>();
    }

    public synchronized void detener(){
        this.seguir = false;
    }

    public void addPeticion(PeticionAPI peticion){
        this.peticiones.add(peticion);
        logger.info("[HILO] Se ha agregado la peticion id: "+peticion.getId());
    }

    public int getListSize(){
        return this.peticiones.size();
    }

//    Agregar la lista de eventos a manejar
public void addListener(EventosAPIListener listener){
    this.listeners.add(listener);
}


    private void procesarPeticionLatest(PeticionAPI peticion){
        String respuesta = this.frankFurteAPI.ejecutar(peticion.getOperacion());
        if(respuesta==null){
            peticion.setRespuesta(
                    "Error al procesar la petición LATEST con Id: "+
                            peticion.getId()
            );
        }else{
            peticion.setRespuesta(respuesta);
        }
        this.generarEventoLatest(peticion);
        logger.info("[HILO] Se ha procesado la peticion LATEST con id: "+
                peticion.getId());
    }

    private void generarEventoLatest(PeticionAPI peticion){
        ListIterator li = this.listeners.listIterator();
        while(li.hasNext()){
            logger.info("[HILO] Lanzar el evento LATEST de la peticion Id: "+
                    peticion.getId());
            EventosAPIListener listener = (EventosAPIListener)li.next();
            EventoAPI eventoAPI = new EventoAPI(this,peticion);
            (listener).procesarEventoLatest(eventoAPI);
        }
    }
    private void procesarPeticionCurrencies(PeticionAPI peticion){
        String respuesta = frankFurteAPI.ejecutar(peticion.getOperacion());
        if(respuesta==null){
            peticion.setRespuesta(
                    "Error al procesar la petición CURRENCIES con Id: "+
                            peticion.getId()
            );
        }else{
            peticion.setRespuesta(respuesta);
        }
        this.generarEventoCurrencies(peticion);
        logger.info("[HILO] Se ha procesado la petición CURRENCIES con Id: "+
                peticion.getId());
    }

    private void generarEventoCurrencies(PeticionAPI peticion){
        ListIterator li = this.listeners.listIterator();
        while(li.hasNext()){
            logger.info("[HILO] Lanzar el evento CURRENCIES de la peticion Id: "+
                    peticion.getId());
            EventosAPIListener listener = (EventosAPIListener)li.next();
            EventoAPI eventoAPI = new EventoAPI(this,peticion);
            (listener).procesarEventoCurrencies(eventoAPI);
        }
    }
    @Override
    public void run() {
        PeticionAPI peticion;
        do{
            if(!peticiones.isEmpty()){
                peticion = peticiones.get(0);
                switch (peticion.getOperacion()){
                    case LATEST :
                    default:
                        procesarPeticionLatest(peticion);
                        break;
                    case CURRENCIES:
                        procesarPeticionCurrencies(peticion);
                        break;
                }
                peticiones.remove(0);
            }
            try{
                Thread.sleep(5000);
            }catch(InterruptedException e){
                logger.error("Error: ", e.getMessage());
            }
        }while(seguir);
    }
}
