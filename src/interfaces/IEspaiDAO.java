/*
 * Paquets
 */
package interfaces;
/**
 * Imports
 */
import classes.Espai;
import java.sql.SQLException;
import javafx.collections.ObservableList;

/**
 * Interficie metodes DAO 
 * @author Marcos, Victor
 */
public interface IEspaiDAO {
    /**
     * Declaracio del metode per registrar espais
     * @param nom
     * @param cognoms
     * @param telefon
     * @param user
     * @param pass
     * @param tipus
     * @return
     * @throws SQLException 
     */
    public boolean registrarEspai(String nom, String cognoms, String telefon, String user, String pass, String tipus) throws SQLException;
    /**
     * Declaracio del metode per esborrar espais
     * @param id
     * @throws SQLException 
     */
    public void borrarEspai(int id) throws SQLException;
    /**
     * Declaracio del metode per llistar espais
     * @return
     * @throws SQLException 
     */
    public ObservableList<Espai> getAvis() throws SQLException;
    /**
     * Declaracio del metode per editar espais
     * @param id
     * @param nom
     * @param cognoms
     * @param telefon
     * @param user
     * @param pass
     * @param tipus
     * @return
     * @throws SQLException 
     */
    public boolean editarEspai(int id, String nom, String cognoms, String telefon, String user, String pass, String tipus) throws SQLException;    
}
