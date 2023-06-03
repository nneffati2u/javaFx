package com.example.films;

public class Film {
    private int rang;
    private String identifiant;
    private String nom;
    private int année;
    private String  acteurPrincipal;

    public Film() {
    }



    public int getRang() {
        return rang;
    }

    public void setRang(int rang) {
        this.rang = rang;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAnnée() {
        return année;
    }

    public void setAnnée(int année) {
        this.année = année;
    }

    public String getActeurPrincipal() {
        return acteurPrincipal;
    }

    public void setActeurPrincipal(String acteurPrincipal) {
        this.acteurPrincipal = acteurPrincipal;
    }
}
