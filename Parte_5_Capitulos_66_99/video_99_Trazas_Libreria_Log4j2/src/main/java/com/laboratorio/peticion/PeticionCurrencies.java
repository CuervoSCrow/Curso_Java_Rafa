package com.laboratorio.peticion;

import com.laboratorio.api.FrankFurteAPIEnum;
import com.laboratorio.eventos.EventoAPI;
import com.laboratorio.eventos.EventosAPIListener;
import com.laboratorio.eventos.ListaPeticiones;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PeticionCurrencies {
    Logger logger = LogManager.getLogger(PeticionCurrencies.class);
    private final ListaPeticiones peticiones;
    private final EventosAPIListener eventos = new EventosAPIListener() {
        @Override
        public void procesarEventoLatest(EventoAPI evento) {
            logger.info("[APP-CURRENCIES] no hacer nada");
        }

        @Override
        public void procesarEventoCurrencies(EventoAPI evento) {
            logger.info("[APP-CURRENCIES] Manejo de un evento CURRENCIES");
            logger.info("[APP-CURRENCIES] Respuesta de la petición Id: "+
                    evento.getPeticionAPI().getId()+" : "+
                    evento.getPeticionAPI().getRespuesta());
        }
    };

    public PeticionCurrencies(ListaPeticiones peticiones) {
        this.peticiones = peticiones;
        this.peticiones.addListener(this.eventos);
    }

    public void add(int id){
        PeticionAPI peticion = new PeticionAPI(id, FrankFurteAPIEnum.CURRENCIES);
        this.peticiones.addPeticion(peticion);
    }
}
