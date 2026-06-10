package com.laboratorio.eventos;

import com.laboratorio.peticion.PeticionAPI;

public interface EventosAPIListener {
    public abstract void procesarEventoLatest(EventoAPI evento);
    public abstract void procesarEventoCurrencies(EventoAPI evento);
}
