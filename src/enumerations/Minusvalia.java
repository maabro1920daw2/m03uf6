/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enumerations;

/**
 *  Enumeration amb les diferents minusvalies
 * @author marco
 */
public enum Minusvalia {
    FISICA("Minusvalia fisica"), PSIQUICA("Minusvalia psiquica"), CAP("No te cap minusvalia");
    
    private String nombreMin;
    
    private Minusvalia(String nombreMin){
        this.nombreMin = nombreMin;
    }
    
    public String getNombreMin() {
        return nombreMin;
    }

}
