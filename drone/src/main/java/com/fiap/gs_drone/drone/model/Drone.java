package com.fiap.gs_drone.drone.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Drone {
    @Id
    @GeneratedValue
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

}
