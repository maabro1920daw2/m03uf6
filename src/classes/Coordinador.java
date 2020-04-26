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
public class Coordinador extends Usuari {
    public Coordinador() {
        super();
    }
    
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
