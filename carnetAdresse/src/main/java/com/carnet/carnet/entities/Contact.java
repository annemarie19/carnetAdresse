package com.carnet.carnet.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Contact implements Serializable {
    @Id @GeneratedValue
    private Long id;
    private String nom;
    private String prenom;
    private String adressemail;
    private String adressepostal;
    private int codepostal;
    private String ville;
    private int telephone;

    public  Contact() {
        super();
    }

    public Contact(String nom, String prenom, String adressemail, String adressepostal, int codepostal, String ville, int telephone){

        //Initialisation des attributs
        this.nom = nom;
        this.prenom = prenom;
        this.adressemail = adressemail;
        this.adressepostal = adressepostal;
        this.codepostal = codepostal;
        this.ville = ville;
        this.telephone = telephone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getCodepostal() {
        return codepostal;
    }

    public void setCodepostal(int codepostal) {
        this.codepostal = codepostal;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getAdressemail() {
        return adressemail;
    }

    public void setAdressemail(String adressemail) {
        this.adressemail = adressemail;
    }

    public String getAdressepostal() {
        return adressepostal;
    }

    public void setAdressepostal(String adressepostal) {
        this.adressepostal = adressepostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

}
