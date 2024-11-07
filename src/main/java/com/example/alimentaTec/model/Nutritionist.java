package com.example.alimentaTec.model;

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

@Entity
@Table(name = "nutritionist")
public class Nutritionist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="idNutritionist")
    @JsonProperty("idNutritionist")
    private Integer idNutritionist;

    @Column(name ="nutritionistName")
    @JsonProperty("nutritionistName")
    private String nutritionistName;

    @Column(name ="paternalSurnameN")
    @JsonProperty("paternalSurnameN")
    private String paternalSurnameN;

    @Column(name ="maternalSurnameN")
    @JsonProperty("maternalSurnameN")
    private String maternalSurnameN;

    @Column(name ="ageN")
    @JsonProperty("ageN")
    private int ageN;

    @Column(name ="genderN")
    @JsonProperty("genderN")
    private String genderN;

    @Column(name ="nutritionistRegistration")
    @JsonProperty("nutritionistRegistration")
    private String nutritionistRegistration;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name =" idUser", referencedColumnName=" idUser")
    @JsonProperty(" idUser")
    private Login login;

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

    public void setLogin(Login login){
        this.login = login;
    }

}
