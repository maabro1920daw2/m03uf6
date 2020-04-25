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
abstract public class Usuari {
    protected int codiUsuari;
    protected String nomUsuari, passUsuari, tipus;
   
    public Usuari() {}
    
    public Usuari(int codiUsuari, String nomUsuari, String passUsuari){
        this.codiUsuari = codiUsuari;
        this.nomUsuari = nomUsuari;
        this.passUsuari = passUsuari;
        this.tipus = this.getClass().getSimpleName();
    }
    
    public void afegirAvi() {}
    
    public void modificarAvi() {}
    
    public void eliminarAvi() {}
    
    public void afegirEspai() {}
    
    public void modificarEspai() {}
    
    public void eliminarEspai() {}

    public int getCodiUsuari() {
        return codiUsuari;
    }

    public void setCodiUsuari(int codiUsuari) {
        this.codiUsuari = codiUsuari;
    }

    public String getNomUsuari() {
        return nomUsuari;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public void setNomUsuari(String nomUsuari) {
        this.nomUsuari = nomUsuari;
    }

    public String getPassUsuari() {
        return passUsuari;
    }

    public void setPassUsuari(String passUsuari) {
        this.passUsuari = passUsuari;
    }
   
}
