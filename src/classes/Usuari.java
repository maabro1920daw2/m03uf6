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
public class Usuari {
    protected int codiUsuari;
    protected String nomUsuari, passUsuari;
   
    public Usuari() {}
    
    public Usuari(int codiUsuari, String nomUsuari, String passUsuari){
        this.codiUsuari = codiUsuari;
        this.nomUsuari = nomUsuari;
        this.passUsuari = passUsuari;
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
