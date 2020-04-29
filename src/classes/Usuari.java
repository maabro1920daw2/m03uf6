/*
 * Paquets
 */
package classes;

/**
 * Clase abstracte per fer usuaris
 * @author Marcos, Victor
 */
abstract public class Usuari {
    protected int codiUsuari;
    protected String nomUsuari, cognomsUsuari, passUsuari, tipus, loginUsuari, telfUsuari;
   
    public Usuari() {}
    /**
     * Constructor clase Usuari
     * @param codiUsuari
     * @param nomUsuari
     * @param cognomsUsuari
     * @param telfUsuari
     * @param loginUsuari
     * @param passUsuari 
     */
    public Usuari(int codiUsuari, String nomUsuari, String cognomsUsuari, String telfUsuari, String loginUsuari, String passUsuari){
        this.codiUsuari = codiUsuari;
        this.nomUsuari = nomUsuari;
        this.cognomsUsuari = cognomsUsuari;
        this.telfUsuari = telfUsuari;
        this.loginUsuari = loginUsuari;
        this.passUsuari = passUsuari;
        this.tipus = this.getClass().getSimpleName();
    }
    
    public String getTelfUsuari() {
        return telfUsuari;
    }

    public void setTelfUsuari(String telfUsuari) {
        this.telfUsuari = telfUsuari;
    }
    
    public String getCognomsUsuari() {
        return cognomsUsuari;
    }

    public void setCognomsUsuari(String cognomsUsuari) {
        this.cognomsUsuari = cognomsUsuari;
    }

    public String getLoginUsuari() {
        return loginUsuari;
    }

    public void setLoginUsuari(String loginUsuari) {
        this.loginUsuari = loginUsuari;
    }

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
