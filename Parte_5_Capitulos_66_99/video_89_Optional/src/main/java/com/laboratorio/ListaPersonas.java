package com.laboratorio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ListaPersonas {
    private List<Persona> personas;

    public ListaPersonas() {
        personas = new ArrayList<>();
    }

    public void agregar(Persona persona){
        personas.add(persona);
    }

    public Optional<Persona> buscarPorDocumento(String documento){
        for (Persona p : personas){
            if(p.getDocumento().equalsIgnoreCase(documento)){
                return Optional.of(p);
            }
        }
        return Optional.empty();
    }
}
