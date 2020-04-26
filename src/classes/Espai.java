/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author marco
 */
public class Espai {
    private String localitzacio,nomEspai;
    private double metresQuadrats;
    private boolean adaptat;
    private int codiEspai, sales, llitsDisponibles, llits;
    
    public Espai() {}
    
    public Espai(int codiEspai, String localitzacio,String nomEspai, double metresQuadrats, boolean adaptat, int sales, int llitsDisponibles, int llits) {
        this.codiEspai = codiEspai;
        this.nomEspai = nomEspai;
        this.localitzacio = localitzacio;
        this.metresQuadrats = metresQuadrats;
        this.adaptat = adaptat;
        this.sales = sales;
        this.llitsDisponibles = llitsDisponibles;
        this.llits = llits;
    }
    
    public int obteLlitsDisponibles() {
        return 0;
    }
    
    public int obteLlits() {
        return 0;
    }

    public String getLocalitzacio() {
        return localitzacio;
    }

    public void setLocalitzacio(String localitzacio) {
        this.localitzacio = localitzacio;
    }

    public double getMetresQuadrats() {
        return metresQuadrats;
    }

    public void setMetresQuadrats(double metresQuadrats) {
        this.metresQuadrats = metresQuadrats;
    }

    public boolean isAdaptat() {
        return adaptat;
    }

    public void setAdaptat(boolean adaptat) {
        this.adaptat = adaptat;
    }

    public int getCodiEspai() {
        return codiEspai;
    }

    public void setCodiEspai(int codiEspai) {
        this.codiEspai = codiEspai;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public int getLlitsDisponibles() {
        return llitsDisponibles;
    }

    public void setLlitsDisponibles(int llitsDisponibles) {
        this.llitsDisponibles = llitsDisponibles;
    }

    public int getLlits() {
        return llits;
    }

    public void setLlits(int llits) {
        this.llits = llits;
    }
    
}
