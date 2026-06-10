package com.laboratorio.eventos;

import com.laboratorio.peticion.PeticionAPI;

import java.util.EventObject;

public class EventoAPI extends EventObject {
    private PeticionAPI peticionAPI;

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public EventoAPI(Object source,PeticionAPI peticionAPI) {
        super(source);
        this.peticionAPI = peticionAPI;
    }

    public PeticionAPI getPeticionAPI() {
        return peticionAPI;
    }
}
