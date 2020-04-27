/*
 * Paquets
 */
package interfaces;
/**
 * Imports
 */
import classes.Avi;
import java.sql.SQLException;
import javafx.collections.ObservableList;

/**
 * Interficie pels metodes DAO dels avis
 * @author Marcos, Victor
 */
public interface IAviDAO {
    /**
     * Declaracio del metode per registrar avis
     * @param nom
     * @param cognoms
     * @param edat
     * @param numTelefon
     * @param telefonFamiliar
     * @param minusvalia
     * @return
     * @throws SQLException 
     */
    public boolean registrarAvi(String nom, String cognoms, int edat, String numTelefon, String telefonFamiliar, String minusvalia) throws SQLException;
    /**
     * Declaracio del metode per eliminar avis
     * @param id
     * @throws SQLException 
     */
    public void borrarAvi(int id) throws SQLException;
    /**
     * Declaracio del metode per llistar avis
     * @return
     * @throws SQLException 
     */
    public ObservableList<Avi> getAvis() throws SQLException;
    /**
     * Declaracio del metode per editar avis
     * @param codiAvi
     * @param nom
     * @param cognoms
     * @param edat
     * @param numTelefon
     * @param telefonFamiliar
     * @param minusvalia
     * @return
     * @throws SQLException 
     */
    public boolean editarAvi(int codiAvi, String nom, String cognoms, int edat, String numTelefon, String telefonFamiliar, String minusvalia) throws SQLException;
}
