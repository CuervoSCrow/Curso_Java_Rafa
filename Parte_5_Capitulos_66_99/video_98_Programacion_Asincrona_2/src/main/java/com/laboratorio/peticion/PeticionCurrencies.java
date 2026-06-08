package com.laboratorio.peticion;

import com.laboratorio.api.FrankFurteAPIEnum;
import com.laboratorio.eventos.EventoAPI;
import com.laboratorio.eventos.EventosAPIListener;
import com.laboratorio.eventos.ListaPeticiones;

public class PeticionCurrencies {
    private final ListaPeticiones peticiones;
    private final EventosAPIListener eventos = new EventosAPIListener() {
        @Override
        public void procesarEventoLatest(EventoAPI evento) {
            System.out.println("[APP-CURRENCIES] no hacer nada");
        }

        @Override
        public void procesarEventoCurrencies(EventoAPI evento) {
            System.out.println("[APP-CURRENCIES] Manejo de un evento");
            System.out.println("[APP-CURRENCIES] Respuesta de la petición Id: " +
                    evento.getPeticion().getId() + " : " +
                    evento.getPeticion().getRespuesta()
            );
        }
    };

    public PeticionCurrencies(ListaPeticiones peticiones) {
        this.peticiones = peticiones;
        this.peticiones.add(this.eventos);
    }

    public void add(int id){
        PeticionAPI peticion = new PeticionAPI(id, FrankFurteAPIEnum.CURRENCIES);
        peticiones.add(peticion);
    }
}
