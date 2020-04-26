/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import classes.Usuari;
import java.sql.SQLException;
import javafx.collections.ObservableList;

/**
 *
 * @author Marcos
 */
public interface IUsuariDAO {
    public boolean registrarUsuari(String nom, String cognoms, String telefon, String user, String pass, String tipus) throws SQLException;
    public void borrarUsuari(int id) throws SQLException;
    public ObservableList<Usuari> getUsuaris() throws SQLException;
    public boolean editarUsuari(int id, String nom, String cognoms, String telefon, String user, String pass, String tipus) throws SQLException;
}
