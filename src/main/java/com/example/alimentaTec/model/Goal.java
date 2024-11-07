package com.example.alimentaTec.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idGoal")
    @JsonProperty("idGoal")
    private int idGoal;

    @Column(name = "nameGoal")
    @JsonProperty("nameGoal")
    private String nameGoal;

    @Column(name = "descriptionGoal")
    @JsonProperty("descriptionGoal")
    private String descriptionGoal;

    @Column(name = "startGoal")
    @JsonProperty("startGoal")
    private boolean startGoal;

    @Column(name = "endGoal")
    @JsonProperty("endGoal")
    private boolean endGoal;

    @Column(name = "statusGoal")
    @JsonProperty("statusGoal")
    private String statusGoal;

    // Getters and Setters
    public int getIdGoal() {
        return idGoal;
    }

    public void setIdGoal(int idGoal) {
        this.idGoal = idGoal;
    }

    public String getNameGoal() {
        return nameGoal;
    }

    public void setNameGoal(String nameGoal) {
        this.nameGoal = nameGoal;
    }

    public String getDescriptionGoal() {
        return descriptionGoal;
    }

    public void setDescriptionGoal(String descriptionGoal) {
        this.descriptionGoal = descriptionGoal;
    }

    public boolean getStartGoal() {
        return startGoal;
    }

    public void setStartGoal(boolean startGoal) {
        this.startGoal = startGoal;
    }

    public boolean getEndGoal() {
        return endGoal;
    }

    public void setEndGoal(boolean endGoal) {
        this.endGoal = endGoal;
    }

    public String getStatusGoal() {
        return statusGoal;
    }

    public void setStatusGoal(String statusGoal) {
        this.statusGoal = statusGoal;
    }

}
