package com.example.alimentaTec.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Saucer")
public class Saucer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSaucer")
    @JsonProperty("idSaucer")
    private int idSaucer;

    
    @Size(min = 1, max = 255, message = "The name of contact most 255 characters")
    @Column(name = "nameSaucer")
    @JsonProperty("nameSaucer")
    private String nameSaucer;

    @Size(min = 1, max = 255, message = "The name of contact most 255 characters")
    @Column(name = "category")
    @JsonProperty("category")
    private String category;

    @Size(min = 1, max = 255, message = "The name of contact most 255 characters")
    @Column(name = "preparation")
    @JsonProperty("preparation")
    private String preparation;

    public Saucer() {
    }

    public Saucer(int idSaucer, String nameSaucer, String category, String preparation) {
        this.idSaucer = idSaucer;
        this.nameSaucer = nameSaucer;
        this.category = category;
        this.preparation = preparation;
    }
    public int getIdSaucer() {
        return idSaucer;
    }

    public void setIdSaucer(int idSaucer) {
        this.idSaucer = idSaucer;
    }

    public String getNameSaucer() {
        return nameSaucer;
    }

    public void setNameSaucer(String nameSaucer) {
        this.nameSaucer = nameSaucer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPreparation() {
        return preparation;
    }

    public void setPreparation(String preparation) {
        this.preparation = preparation;
    }

}