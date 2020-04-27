/*
 * Paquets
 */
package classes;

/**
 * Clase per instancia l'usuari corrent, extends d'usuari
 * @author Marcos, Victor
 */
public class Corrent extends Usuari {
    public Corrent() {
        super();
    }
    
    public Corrent(int codiUsuari, String nomUsuari, String cognomsUsuari, String telfUsuari, String loginUsuari, String passUsuari) {
        super(codiUsuari,nomUsuari,cognomsUsuari,telfUsuari,loginUsuari,passUsuari);
    }    
}
