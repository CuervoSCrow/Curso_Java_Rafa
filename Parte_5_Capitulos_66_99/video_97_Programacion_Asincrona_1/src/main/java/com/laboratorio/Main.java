package com.laboratorio;

import com.laboratorio.eventos.EventoAPI;
import com.laboratorio.eventos.EventosAPIListener;
import com.laboratorio.peticion.ListaPeticiones;
import com.laboratorio.peticion.PeticionAPI;

public class Main {
    public static EventosAPIListener eventos= new EventosAPIListener() {
        @Override
        public void procesarEventoAPI(EventoAPI evento) {
            System.out.println("[APP] Manejo de un evento ");
            System.out.println("[APP] Respuesta de la petición Id: "+
                    evento.getPeticion().getId()+": "+
                    " : "+
                    evento.getPeticion().getRespuesta()
                    );
        }
    };
    public static void main(String[] args) {
        ListaPeticiones peticiones = new ListaPeticiones();
        peticiones.addEventListener(eventos);
        boolean seguir=true;
        PeticionAPI peticion;

        Thread hilo = new Thread(peticiones);
        hilo.start();

        peticion = new PeticionAPI(1,1);
        peticiones.add(peticion);
        peticion = new PeticionAPI(2,2);
        peticiones.add(peticion);
        peticion = new PeticionAPI(3,1);
        peticiones.add(peticion);
        peticion = new PeticionAPI(4,1);
        peticiones.add(peticion);
        peticion = new PeticionAPI(5,2);


        int ciclos=0;
        do{
            if(peticiones.getListSize() <= 0){
                seguir=false;

            }
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            ciclos++;
            System.out.println("[APP] Ciclo: "+ciclos);
        }while(seguir);
        peticiones.detener();
        try{
            System.out.println("[APP] Esperando finalización del hilo");
            hilo.join();
            System.out.println("[APP] Finalizando programa...");
        }catch(InterruptedException e){
            e.printStackTrace();
        }

    }
}