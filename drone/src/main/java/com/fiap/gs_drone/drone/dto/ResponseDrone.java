package com.fiap.gs_drone.drone.dto;
import com.fiap.gs_drone.drone.model.*;

public class ResponseDrone {

    private long id;
    private String codigoDrone;
    private String status;
    private String observacao;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
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
    

    

    public ResponseDrone toDto(Drone drone) {
        this.setId(drone.getId());
        this.setCodigoDrone(drone.getCodigoDrone());
        this.setStatus(drone.getStatus());
        this.setObservacao(drone.getObservacao());
        return this;
    }
}
