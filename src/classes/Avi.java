/*
 * Paquets
 */
package classes;
/**
 * Imports
 */
import enumerations.Minusvalia;

/**
 * Clase per instaciar avis
 * @author Marcos, Victor
 */
public class Avi {

    private String nom, cognoms, numTelefon, telefonFamiliar;
    private Espai espai;
    private int codiAvi, edat;
    private Minusvalia minusvalia;
    private boolean sugerit, aprovat;

    public Avi() {
    }
    /**
     * Constructor clase avi
     * @param codiAvi
     * @param nom
     * @param cognoms
     * @param edat
     * @param numTelefon
     * @param telefonFamiliar
     * @param minusvalia 
     */
    public Avi(int codiAvi, String nom, String cognoms, int edat, String numTelefon, String telefonFamiliar, Minusvalia minusvalia) {
        this.nom = nom;
        this.cognoms = cognoms;
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

    public String getCognoms() {
        return cognoms;
    }

    public void setCognoms(String cognoms) {
        this.cognoms = cognoms;
    }

    public Espai getEspai() {
        return espai;
    }

    public void setEspai(Espai espai) {
        this.espai = espai;
    }

    public boolean isSugerit() {
        return sugerit;
    }

    public void setSugerit(boolean sugerit) {
        this.sugerit = sugerit;
    }

    public boolean isAprovat() {
        return aprovat;
    }

    public void setAprovat(boolean aprovat) {
        this.aprovat = aprovat;
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

    public String getNumTelefon() {
        return numTelefon;
    }

    public void setNumTelefon(String numTelefon) {
        this.numTelefon = numTelefon;
    }

    public String getTelefonFamiliar() {
        return telefonFamiliar;
    }

    public void setTelefonFamiliar(String telefonFamiliar) {
        this.telefonFamiliar = telefonFamiliar;
    }

    public Minusvalia getMinusvalia() {
        return minusvalia;
    }

    public void setMinusvalia(Minusvalia minusvalia) {
        this.minusvalia = minusvalia;
    }
}
