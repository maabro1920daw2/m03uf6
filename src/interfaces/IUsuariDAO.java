/*
 * Paquets
 */
package interfaces;
/**
 * Imports
 */
import classes.Usuari;
import java.sql.SQLException;
import javafx.collections.ObservableList;

/**
 * Interficie pels metodes DAO dels usuaris 
 * @author Marcos, Victor
 */
public interface IUsuariDAO {
    /**
     * Declaracio del metode per a registrar usuaris
     * @param nom
     * @param cognoms
     * @param telefon
     * @param user
     * @param pass
     * @param tipus
     * @return
     * @throws SQLException 
     */
    public boolean registrarUsuari(String nom, String cognoms, String telefon, String user, String pass, String tipus) throws SQLException;
    /**
     * Declaracio del metode per a eliminar un usuari
     * @param id
     * @throws SQLException 
     */
    public void borrarUsuari(int id) throws SQLException;
    /**
     * Declaracio del metode per llistar usuaris
     * @return
     * @throws SQLException 
     */
    public ObservableList<Usuari> getUsuaris() throws SQLException;
    /**
     * Declaracio del metode per editar usuaris
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
    public boolean editarUsuari(int id, String nom, String cognoms, String telefon, String user, String pass, String tipus) throws SQLException;
}
