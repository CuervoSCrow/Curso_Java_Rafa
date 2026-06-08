package com.laboratorio.peticion;

import com.laboratorio.api.FrankFurteAPIEnum;
import com.laboratorio.eventos.EventoAPI;
import com.laboratorio.eventos.EventosAPIListener;
import com.laboratorio.eventos.ListaPeticiones;

public class PeticionLatest {
    private final ListaPeticiones peticiones;
    private final EventosAPIListener eventos = new EventosAPIListener(){
        @Override
        public void procesarEventoLatest(EventoAPI evento) {
            System.out.println("[APP-LATEST] Manejo de un evento");
            System.out.println("[APP-LATEST] Respuesta de la petición Id: "+
                    evento.getPeticion().getId()+" : "+
                    evento.getPeticion().getRespuesta()
            );
        }
        @Override
        public void procesarEventoCurrencies(EventoAPI evento) {
            System.out.println("[APP-LATEST] no hacer nada");
        }
    };

    public PeticionLatest(ListaPeticiones peticiones) {
        this.peticiones = peticiones;
        this.peticiones.add(this.eventos);
    }

    public void add(int id){
        PeticionAPI peticion = new PeticionAPI(id, FrankFurteAPIEnum.LATEST);
        peticiones.add(peticion);
    }
}
