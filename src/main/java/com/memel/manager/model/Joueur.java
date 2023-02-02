package com.memel.manager.model;

import javax.persistence.*;

import java.io.Serializable;

@Entity
public class Joueur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private long id;
    private String nom;
    private String prenom;
    private Integer note;
    @Column(nullable = false, updatable = false)
    private String num_licence;

    private String imageURL;

    public Joueur() {}
    public Joueur(long id, String nom, String prenom, Integer note, String num_licence, String imageURL) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.note = note;
        this.num_licence = num_licence;
        this.imageURL = imageURL;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }

    public String getNum_licence() {
        return num_licence;
    }

    public void setNum_licence(String num_licence) {
        this.num_licence = num_licence;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}

