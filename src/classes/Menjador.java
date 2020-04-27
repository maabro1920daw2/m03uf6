/*
 * Paquets
 */
package classes;

/**
 * Clase per instanciar menjador
 * @author Marcos, Victor
 */
public class Menjador extends Sala {
    private int taules;
    private int cadires;
    
    public Menjador() {
        super();
    }
    /**
     * Constructor clase menjador
     * @param codi
     * @param superficie
     * @param taules
     * @param cadires 
     */
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
