/*
 * Paquets
 */
package classes;

/**
 * Clase per instancia una habitacio
 * @author Marcos, Victor
 */
public class Habitacio extends Sala {
    private int llitsDisponibles, llits;
    
    public Habitacio() {
        super();
    }
    /**
     * Constructor clase habitacio
     * @param codi
     * @param superficie
     * @param llitsDisponibles
     * @param llits 
     */
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
