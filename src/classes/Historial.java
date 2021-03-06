/*
 * Paquets
 */
package classes;

/**
 * Clase per instanciar l'historial
 * @author marco
 */
public class Historial {
    private String diaEntrada, diaSortida;
    private Avi avi;
    private Espai espai;
    
    public Historial() {}
    /**
     * Constructor de la clase Historial
     * @param diaEntrada
     * @param diaSortida
     * @param avi
     * @param espai 
     */
    public Historial(String diaEntrada, String diaSortida, Avi avi, Espai espai) {
        this.diaEntrada = diaEntrada;
        this.diaSortida = diaSortida;
        this.avi = avi;
        this.espai = espai;
    }

    public String getDiaEntrada() {
        return diaEntrada;
    }

    public void setDiaEntrada(String diaEntrada) {
        this.diaEntrada = diaEntrada;
    }

    public String getDiaSortida() {
        return diaSortida;
    }

    public void setDiaSortida(String diaSortida) {
        this.diaSortida = diaSortida;
    }

    public Avi getAvi() {
        return avi;
    }

    public void setAvi(Avi avi) {
        this.avi = avi;
    }

    public Espai getEspai() {
        return espai;
    }

    public void setEspai(Espai espai) {
        this.espai = espai;
    }
    
}
