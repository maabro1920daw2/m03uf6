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
public class Menjador extends Sala {
    private int taules;
    private int cadires;
    
    public Menjador() {
        super();
    }
    
    public Menjador(int codi, double superficie, int taules, int cadires) {
        super(codi,superficie);
        this.taules = taules;
        this.cadires = cadires;
    }

    public int getTaules() {
        return taules;
    }

    public void setTaules(int taules) {
        this.taules = taules;
    }

    public int getCadires() {
        return cadires;
    }

    public void setCadires(int cadires) {
        this.cadires = cadires;
    }
    
}
