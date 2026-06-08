package com.laboratorio.eventos;

public interface EventosAPIListener {
    public abstract void procesarEventoLatest(EventoAPI evento);
    public abstract void procesarEventoCurrencies(EventoAPI evento);
}
