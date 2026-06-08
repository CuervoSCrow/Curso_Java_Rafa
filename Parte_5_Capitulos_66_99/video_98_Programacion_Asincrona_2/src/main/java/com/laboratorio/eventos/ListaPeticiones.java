package com.laboratorio.eventos;

import com.laboratorio.api.FrankFurteAPI;
import com.laboratorio.peticion.PeticionAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListaPeticiones implements Runnable{
    private volatile boolean seguir;
    private final FrankFurteAPI frakFurteAPI;
    private final List<PeticionAPI> peticiones;
    private static ArrayList listeners;

    public ListaPeticiones(){
        this.seguir = true;
        this.frakFurteAPI = new FrankFurteAPI("https://api.frankfurter.dev/v1/");
        this.peticiones = new ArrayList<>();
        this.listeners = new ArrayList<>();
    }

    public synchronized void detener(){
        this.seguir = false;
    }

    public void add(PeticionAPI peticion){
        this.peticiones.add(peticion);
        System.out.println("[HILO] Se ha agregado la petición id: "+
                peticion.getId());
    }

    public int getListSize(){
        return this.peticiones.size();
    }
//    Agregar la lista de eventos a manejar
    public void add(EventosAPIListener listener){
        this.listeners.add(listener);
    }

    private void generarEventoLatest(PeticionAPI peticion){
        ListIterator li = this.listeners.listIterator();
        while(li.hasNext()){
            System.out.println("[HILO] Lanzar el evento LATEST de la peticion Id: "+peticion.getId());
            EventosAPIListener listener = (EventosAPIListener)li.next();
            EventoAPI eventoAPI = new EventoAPI(this,peticion);
            (listener).procesarEventoLatest(eventoAPI);
        }
    }
    private void generarEventoCurrencies(PeticionAPI peticion){
        ListIterator li = this.listeners.listIterator();
        while(li.hasNext()){
            System.out.println("[HILO] Lanzar el evento CURRENCIES de la peticion Id: "+peticion.getId());
            EventosAPIListener listener = (EventosAPIListener)li.next();
            EventoAPI eventoAPI = new EventoAPI(this,peticion);
            (listener).procesarEventoCurrencies(eventoAPI);
        }
    }

    private void procesarPeticionLatest(PeticionAPI peticion){

        String respuesta =frakFurteAPI.ejecutar(peticion.getOperacion());
        if(respuesta==null){
            peticion.setRespuesta(
                    "Error al procesar la peticion LATEST con Id: "+
                            peticion.getId()
            );
        }else{
            peticion.setRespuesta(respuesta);
        }
        this.generarEventoLatest(peticion);
        System.out.println("[HILO] Se ha procesado la peticion LATEST con id: "+
                peticion.getId());
    }

    private void procesarPeticionCurrencies(PeticionAPI peticion){

        String respuesta =frakFurteAPI.ejecutar(peticion.getOperacion());
        if(respuesta==null){
            peticion.setRespuesta(
                    "Error al procesar la peticion CURRENCIES con Id: "+
                            peticion.getId()
            );
        }else{
            peticion.setRespuesta(respuesta);
        }
        this.generarEventoCurrencies(peticion);
        System.out.println("[HILO] Se ha procesado la peticion CURRENCIES con id: "+
                peticion.getId());
    }

    @Override
    public void run() {
        PeticionAPI peticion;
        do{
            if(!peticiones.isEmpty()){
                peticion = peticiones.get(0);
                switch (peticion.getOperacion()){
                    case LATEST:
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
                e.printStackTrace();
            }
        }while(seguir);
    }
}
