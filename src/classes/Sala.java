/*
 * Paquets
 */
package classes;

/**
 * Clase Sala 
 * @author Marcos, Victor
 */
public class Sala {
    protected int codi;
    protected double superficie;
    
    public Sala() {}
    
    public Sala (int codi, double superficie) {
        this.codi = codi;
        this.superficie = superficie;
    }

    public int getCodi() {
        return codi;
    }

    public void setCodi(int codi) {
        this.codi = codi;
    }

    public double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }
    
}
