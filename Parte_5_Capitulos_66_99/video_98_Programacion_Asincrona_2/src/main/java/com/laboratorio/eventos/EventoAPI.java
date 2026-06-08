package com.laboratorio.eventos;

import com.laboratorio.peticion.PeticionAPI;

import java.util.EventObject;

public class EventoAPI extends EventObject {
    private PeticionAPI peticion;
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public EventoAPI(Object source, PeticionAPI peticionAPI) {
        super(source);
        this.peticion = peticionAPI;
    }

    public PeticionAPI getPeticion() {
        return peticion;
    }
}
