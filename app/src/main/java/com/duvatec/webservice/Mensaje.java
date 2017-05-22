package com.duvatec.webservice;

import com.google.gson.annotations.SerializedName;

/**
 * Created by DaveGam on 21/05/17.
 */

public class Mensaje {

    @SerializedName("Mensaje")
    private String mensaje;

    @SerializedName("CodMensaje")
    private String codMensaje;

    @SerializedName("Metodo")
    private String metodo;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getCodMensaje() {
        return codMensaje;
    }

    public void setCodMensaje(String codMensaje) {
        this.codMensaje = codMensaje;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }
}
