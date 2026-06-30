
package com.laboratorio.video120_desarrollo_web_21_webservices_2_soap.ws;

public class Resultado {
    private int codigo;
    private String mensaje;

    public Resultado() {
    }

    public Resultado(int codigo, String mensaje) {
        this.codigo = codigo;
        this.mensaje = mensaje;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
}
