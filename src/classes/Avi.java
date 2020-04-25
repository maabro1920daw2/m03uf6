/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import enumerations.Minusvalia;

/**
 *
 * @author marco
 */
public class Avi {
    private String nom;
    private Espai espai, sugeriment;
    private int codiAvi, edat, numTelefon, telefonFamiliar;
    private Minusvalia minusvalia;
    
    public Avi() {}

    public Avi(String nom, int codiAvi, int edat, int numTelefon, int telefonFamiliar, Minusvalia minusvalia) {
        this.nom = nom;
        this.codiAvi = codiAvi;
        this.edat = edat;
        this.numTelefon = numTelefon;
        this.telefonFamiliar = telefonFamiliar;
        this.minusvalia = minusvalia;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getCodiAvi() {
        return codiAvi;
    }

    public void setCodiAvi(int codiAvi) {
        this.codiAvi = codiAvi;
    }

    public int getEdat() {
        return edat;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }

    public int getNumTelefon() {
        return numTelefon;
    }

    public void setNumTelefon(int numTelefon) {
        this.numTelefon = numTelefon;
    }

    public int getTelefonFamiliar() {
        return telefonFamiliar;
    }

    public void setTelefonFamiliar(int telefonFamiliar) {
        this.telefonFamiliar = telefonFamiliar;
    }

    public Minusvalia getMinusvalia() {
        return minusvalia;
    }

    public void setMinusvalia(Minusvalia minusvalia) {
        this.minusvalia = minusvalia;
    }
    
}
