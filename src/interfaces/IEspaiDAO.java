/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import classes.Espai;
import java.sql.SQLException;
import javafx.collections.ObservableList;

/**
 *
 * @author Marcos
 */
public interface IEspaiDAO {
    public boolean registrarEspai(String nom, String cognoms, String telefon, String user, String pass, String tipus) throws SQLException;
    public void borrarEspai(int id) throws SQLException;
    public ObservableList<Espai> getAvis() throws SQLException;
    public boolean editarEspai(int id, String nom, String cognoms, String telefon, String user, String pass, String tipus) throws SQLException;    
}
