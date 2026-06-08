package com.laboratorio.peticion;

import com.laboratorio.eventos.EventoAPI;
import com.laboratorio.eventos.EventosAPIListener;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListaPeticiones implements Runnable{
    private volatile boolean seguir;
    private final List<PeticionAPI> peticiones;
    private static ArrayList listeners;

    public ListaPeticiones() {
        seguir=true;
        peticiones=new ArrayList<>();
        listeners=new ArrayList<>();
    }

    public synchronized void detener(){
        seguir=false;
    }

    public void add(PeticionAPI peticion){
        peticiones.add(peticion);
        System.out.println("[HILO] Se ha agregado la petición id: "+
                peticion.getId());
    }

    public int getListSize(){
        return peticiones.size();
    }

//    Agregar la lista de eventos a manejar
    public void addEventListener(EventosAPIListener listener){
        listeners.add(listener);
    }

    private void generarEvento(PeticionAPI peticion){
        ListIterator li = listeners.listIterator();
        while(li.hasNext()){
            System.out.println("[HILO] lanzar el evento de la peticion Id: "+peticion.getId());
            EventosAPIListener listener = (EventosAPIListener) li.next();
            EventoAPI eventoAPI = new EventoAPI(this,peticion);
            (listener).procesarEventoAPI(eventoAPI);
        }
    }

    private void procesarPeticion(PeticionAPI peticion){

        String respuesta = "Respuesta del API para "+
                "la petición Id: "+peticion.getId();
        peticion.setRespuesta(respuesta);
        generarEvento(peticion);
        System.out.println("[HILO] Se ha procesado la petición id: "+
                peticion.getId());
    }

    @Override
    public void run() {
        PeticionAPI peticion;
        do{
            if(!peticiones.isEmpty()){
                peticion=peticiones.get(0);
                procesarPeticion(peticion);
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
