/*
 * Paquets
 */
package classes;

import database.Utilitat;
import java.sql.SQLException;

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
    
    static public void validarAssignacio(Avi a) throws SQLException {
        Utilitat u =new Utilitat();
        u.validarAvi(a.getCodiAvi());
    }
    
    static public void denegarAssignacio(Avi a) throws SQLException {
        Utilitat u =new Utilitat();
        u.denegarAvi(a.getCodiAvi());
        
    }
    
    static public void reformularAssignacio(Avi a,int e) throws SQLException {
    Utilitat u =new Utilitat();
        u.reformularAvi(a.getCodiAvi(),e);
    }
    
    public void afegirUsuari() {}
    
    public void modificarUsuari() {}
    
    public void eliminarUsuari() {}
}
