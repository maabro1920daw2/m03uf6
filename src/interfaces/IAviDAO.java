/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import classes.Avi;
import java.sql.SQLException;
import javafx.collections.ObservableList;

/**
 *
 * @author Marcos
 */
public interface IAviDAO {
    public boolean registrarAvi(String nom, String cognoms, String telefon, String user, String pass, String tipus) throws SQLException;
    public void borrarAvi(int id) throws SQLException;
    public ObservableList<Avi> getAvis() throws SQLException;
    public boolean editarAvi(int id, String nom, String cognoms, String telefon, String user, String pass, String tipus) throws SQLException;
}
