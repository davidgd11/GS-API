package com.fiap.gs_drone.drone.dto;

public class DroneRequestCreate {

    private String codigoDrone;
    private String status;
    private String observacao;

    public String getCodigoDrone() {
        return codigoDrone;
    }
    public void setCodigoDrone(String codigoDrone) {
        this.codigoDrone = codigoDrone;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getObservacao() {
        return observacao;
    }
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

}
