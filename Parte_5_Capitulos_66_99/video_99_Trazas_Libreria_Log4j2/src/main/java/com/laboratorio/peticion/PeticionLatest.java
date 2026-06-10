package com.laboratorio.peticion;

import com.laboratorio.api.FrankFurteAPIEnum;
import com.laboratorio.eventos.EventoAPI;
import com.laboratorio.eventos.EventosAPIListener;
import com.laboratorio.eventos.ListaPeticiones;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class PeticionLatest {
    Logger logger = LogManager.getLogger(PeticionLatest.class);
    private final ListaPeticiones peticiones;
    private final EventosAPIListener eventos = new EventosAPIListener() {
        @Override
        public void procesarEventoLatest(EventoAPI evento) {
            logger.info("[APP-LATEST] Manejo de un evento LATEST");
            logger.info("[APP-LATEST] Respuesta de la petición Id: "+
                    evento.getPeticionAPI().getId()+" : "+
                    evento.getPeticionAPI().getRespuesta());
        }

        @Override
        public void procesarEventoCurrencies(EventoAPI evento) {
            logger.info("[APP-LATEST] no hacer nada");
        }
    };

    public PeticionLatest(ListaPeticiones peticiones) {
        this.peticiones = peticiones;
        this.peticiones.addListener(this.eventos);
    }

    public void add(int id){
        PeticionAPI peticion = new PeticionAPI(id, FrankFurteAPIEnum.LATEST);
        this.peticiones.addPeticion(peticion);
    }
}
