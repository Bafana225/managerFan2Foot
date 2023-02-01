package com.julien.manager.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Equipe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private long id;
    private String nom;
    private Integer note;

    public Equipe(long id, String nom, Integer note) {
        this.id = id;
        this.nom = nom;
        this.note = note;
    }

    public Equipe() {

    }


    public long getId_equipe() {
        return id;
    }

    public void setId_equipe(long id_equipe) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }
}
