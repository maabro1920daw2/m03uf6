/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import database.Utilitat;
import java.sql.SQLException;

/**
 * Clase per instancia gertors, extends d'usuari
 * @author Marcos, Victor
 */
public class Gestor extends Usuari {
    public Gestor() {
        super();
    }
    /**
     * Constructor clase gestor
     * @param codiUsuari
     * @param nomUsuari
     * @param cognomsUsuari
     * @param telfUsuari
     * @param loginUsuari
     * @param passUsuari 
     */
    public Gestor(int codiUsuari, String nomUsuari, String cognomsUsuari, String telfUsuari, String loginUsuari, String passUsuari) {
        super(codiUsuari,nomUsuari,cognomsUsuari,telfUsuari,loginUsuari,passUsuari);
      
        }
    
    static public void sugerirLloc(int codiA,int codiE,String dateE,String dateS) throws SQLException {
        Utilitat u =new Utilitat();
        u.suggerirAvi(codiA,codiE,dateE,dateS);
    }
}
