package com.laboratorio.peticion;

import com.laboratorio.api.FrankFurteAPIEnum;

public class PeticionAPI {
    private int id;
    private FrankFurteAPIEnum operacion;
    private String respuesta;

    public PeticionAPI(int id, FrankFurteAPIEnum operacion) {
        this.id = id;
        this.operacion = operacion;
        this.respuesta = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FrankFurteAPIEnum getOperacion() {
        return operacion;
    }

    public void setOperacion(FrankFurteAPIEnum operacion) {
        this.operacion = operacion;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
}
