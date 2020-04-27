 /*
 * Paquets
 */
package classes;

/**
 * Clase per als espais
 * @author Marcos, Victor
 */
public class Espai {
    private String localitzacio;
    private double metresQuadrats;
    private boolean adaptat;
    private int codiEspai, llitsDisponibles, llits;
    private Sala sales;
    
    public Espai() {}
    /**
     * Constructor espais
     * @param codiEspai
     * @param localitzacio
     * @param metresQuadrats
     * @param adaptat
     * @param sales
     * @param llitsDisponibles
     * @param llits 
     */
    public Espai(int codiEspai, String localitzacio, double metresQuadrats, boolean adaptat, Sala sales, int llitsDisponibles, int llits) {
        this.codiEspai = codiEspai;
        this.localitzacio = localitzacio;
        this.metresQuadrats = metresQuadrats;
        this.adaptat = adaptat;
        this.sales = sales;
        this.llitsDisponibles = llitsDisponibles;
        this.llits = llits;
    }
    
    public int obteLlitsDisponibles() {
        return 0;
    }
    
    public int obteLlits() {
        return 0;
    }

    public String getLocalitzacio() {
        return localitzacio;
    }

    public void setLocalitzacio(String localitzacio) {
        this.localitzacio = localitzacio;
    }

    public double getMetresQuadrats() {
        return metresQuadrats;
    }

    public void setMetresQuadrats(double metresQuadrats) {
        this.metresQuadrats = metresQuadrats;
    }

    public boolean isAdaptat() {
        return adaptat;
    }

    public void setAdaptat(boolean adaptat) {
        this.adaptat = adaptat;
    }

    public int getCodiEspai() {
        return codiEspai;
    }

    public void setCodiEspai(int codiEspai) {
        this.codiEspai = codiEspai;
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
