package com.example.alimentaTec.model;

import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Getter
@Setter
@Entity
@Table(name = "nutritionist")
public class Nutritionist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="idNutritionist")
    @JsonProperty("idNutritionist")
    private Integer idNutritionist;

    @NotBlank(message = "The nutritionist's name is required")
    @Size(max = 100, message = "The nutritionist's name cannot exceed 100 characters")
    @Column(name ="nutritionistName")
    @JsonProperty("nutritionistName")
    private String nutritionistName;

    @NotBlank(message = "The paternal surname is required")
    @Size(max = 100, message = "The paternal surname cannot exceed 100 characters")
    @Column(name ="paternalSurnameN")
    @JsonProperty("paternalSurnameN")
    private String paternalSurnameN;

    @NotBlank(message = "The maternal surname is required")
    @Size(max = 100, message = "The maternal surname cannot exceed 100 characters")
    @Column(name ="maternalSurnameN")
    @JsonProperty("maternalSurnameN")
    private String maternalSurnameN;

    @NotNull(message = "Age is required")
    @Positive(message = "Age must be a positive number")
    @Column(name ="ageN")
    @JsonProperty("ageN")
    private int ageN;

    @NotBlank(message = "Gender is required")
    @Size(max = 10, message = "Gender cannot exceed 10 characters")
    @Column(name ="genderN")
    @JsonProperty("genderN")
    private String genderN;

    @NotBlank(message = "The nutritionist's registration is required")
    @Size(max = 50, message = "The nutritionist's registration cannot exceed 50 characters")
    @Column(name ="nutritionistRegistration")
    @JsonProperty("nutritionistRegistration")
    private String nutritionistRegistration;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="idUser", referencedColumnName="idUser")
    @JsonProperty("idUser")
    private Login login;

    public Nutritionist() {
    }

    public int getIdNutritionist(){return idNutritionist;}
    public void setIdNutritionist(int idNutritionist){this.idNutritionist = idNutritionist;}

    public String getNutritionistName(){return nutritionistName;}
    public void setNutritionistName(String nutritionistName){this.nutritionistName = nutritionistName;}

    public String getPaternalSurnameN(){return paternalSurnameN;}
    public void setPaternalSurnameN(String paternalSurnameN){this.paternalSurnameN = paternalSurnameN;}

    public String getMaternalSurnameN(){return maternalSurnameN;}
    public void setMaternalSurnameN(String maternalSurnameN){this.maternalSurnameN = maternalSurnameN;}
    
    public int getAgeN(){return ageN;}
    public void setAgeN(int ageN){this.ageN = ageN;}
    
    public String getGenderN(){return genderN;}
    public void setGenderN(String genderN){this.genderN = genderN;}

    public String getNutritionistRegistration(){return nutritionistRegistration;}
    public void setNutritionistRegistration(String nutritionistRegistration){this.nutritionistRegistration = nutritionistRegistration;}

    public Login getLogin(){
        return login;
    }

    public Nutritionist(Integer idNutritionist, String nutritionistName, String paternalSurnameN, String maternalSurnameN, int ageN, String genderN, String nutritionistRegistration, Login login) {
        this.idNutritionist = idNutritionist;
        this.nutritionistName = nutritionistName;
        this.paternalSurnameN = paternalSurnameN;
        this.maternalSurnameN = maternalSurnameN;
        this.ageN = ageN;
        this.genderN = genderN;
        this.nutritionistRegistration = nutritionistRegistration;
        this.login = login;
    }
}
