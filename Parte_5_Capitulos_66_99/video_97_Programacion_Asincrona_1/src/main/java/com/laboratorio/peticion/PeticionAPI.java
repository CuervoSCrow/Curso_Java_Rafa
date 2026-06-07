package com.laboratorio.peticion;

public class PeticionAPI {
    private int id;
    private int operacion;
    private String respuesta;

    public PeticionAPI(int id, int operacion) {
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

    public int getOperacion() {
        return operacion;
    }

    public void setOperacion(int operacion) {
        this.operacion = operacion;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
}
