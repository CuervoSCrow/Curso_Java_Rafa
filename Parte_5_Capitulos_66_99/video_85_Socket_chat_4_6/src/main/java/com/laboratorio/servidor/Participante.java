package com.laboratorio.servidor;

public class Participante {
    private final int id;
    private final String nombre;
    private final AtencionCliente atencionCliente;

    public Participante(
            int id,
            String nombre,
            AtencionCliente atencionCliente) {
        this.id = id;
        this.nombre = nombre;
        this.atencionCliente = atencionCliente;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public AtencionCliente getAtencionCliente() {
        return atencionCliente;
    }
}
