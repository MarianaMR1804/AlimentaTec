package com.example.alimentaTec.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "journal")
public class Journal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idJournal")
    @JsonProperty("idJournal")
    private Integer idJournal;

    @NotNull(message = "Saucer cannot be null")
    @ManyToOne
    @JoinColumn(name = "idSaucer")
    @JsonProperty("saucer")
    private Saucer saucer;

    @NotNull(message = "Physical activity cannot be null")
    @ManyToOne
    @JoinColumn(name = "idActivity")
    @JsonProperty("physicalActivity")
    private PhysicalActivity physicalActivity;

    @NotNull(message = "Goal cannot be null")
    @ManyToOne
    @JoinColumn(name = "idGoal")
    @JsonProperty("goal")
    private Goal goal;

    @NotNull(message = "User cannot be null")
    @ManyToOne
    @JoinColumn(name = "idUser")
    @JsonProperty("login")
    private Login login;
}
