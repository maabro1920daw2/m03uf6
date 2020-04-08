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
public class Habitacio extends Sala {
    private int llitsDisponibles, llits;
    
    public Habitacio() {
        super();
    }
    
    public Habitacio(int codi, double superficie, int llitsDisponibles, int llits) {
        super(codi,superficie);
        this.llitsDisponibles = llitsDisponibles;
        this.llits = llits;
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
