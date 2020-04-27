/*
 * Paquets
 */
package classes;

/**
 * Clase per instanciar coordinadors, extends d'usuari
 * @author marco
 */
public class Coordinador extends Usuari {
    public Coordinador() {
        super();
    }
    /**
     * Constructor clase coordinador
     * @param codiUsuari
     * @param nomUsuari
     * @param cognomsUsuari
     * @param telfUsuari
     * @param loginUsuari
     * @param passUsuari 
     */
    public Coordinador(int codiUsuari, String nomUsuari, String cognomsUsuari, String telfUsuari, String loginUsuari, String passUsuari) {
        super(codiUsuari,nomUsuari,cognomsUsuari,telfUsuari,loginUsuari,passUsuari);
    }
    
    public void validarAssignacio() {}
    
    public void denegarAssignacio() {}
    
    public void reformularAssignacio() {}
    
    public void afegirUsuari() {}
    
    public void modificarUsuari() {}
    
    public void eliminarUsuari() {}
}
