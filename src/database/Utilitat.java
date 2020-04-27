/**
 * Paquets
 */
package database;
/**
 * Imports
 */
import classes.Avi;
import classes.Coordinador;
import classes.Corrent;
import classes.Gestor;
import classes.Usuari;
import enumerations.Minusvalia;
import interfaces.IAviDAO;
import interfaces.IUsuariDAO;
import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Clase utilitat per fer operacions de la BD
 * @author Marcos, Victor
 */
public class Utilitat extends Connexio implements IUsuariDAO, IAviDAO {

    private ResultSet resultSet = null;
    private PreparedStatement preparedStatement = null;
    private Statement statement = null;
    /**
     * Metode per registrar un usuari en la BD, implementat de IUsuariDAO
     * @param nom
     * @param cognoms
     * @param telefon
     * @param user
     * @param pass
     * @param tipus
     * @return
     * @throws SQLException 
     */
    @Override
    public boolean registrarUsuari(String nom, String cognoms, String telefon, String user, String pass, String tipus) throws SQLException {
        try {
            this.conectar();
            this.connect.setAutoCommit(false);
            this.preparedStatement = this.connect.prepareStatement("insert into usuaris(nom,cognoms,telefon,login,contrasenya,tipus) values (?, ?, ?, ?, ?, ?)");
            this.preparedStatement.setString(1, nom);
            this.preparedStatement.setString(2, cognoms);
            this.preparedStatement.setString(3, telefon);
            this.preparedStatement.setString(4, user);
            this.preparedStatement.setString(5, pass);
            this.preparedStatement.setString(6, tipus);
            this.preparedStatement.executeUpdate();
            this.connect.commit();
            this.preparedStatement.close();
            this.connect.close();
            return true;
        } catch (SQLIntegrityConstraintViolationException sqle) {
            System.out.println("El usuari ja existeix. Prova un altre.");
            return false;
        } catch (SQLException e) {
            System.out.println(e.toString());
            if (this.connect != null) {
                try {
                    this.connect.rollback();
                    return false;
                } catch (SQLException ex) {
                    System.out.println(ex.toString());
                    return false;
                }
            }

            return false;

        }
    }
    /**
     * Metode per editar un usuari a la BD, implementat de IUsuariDAO 
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
    @Override
    public boolean editarUsuari(int id, String nom, String cognoms, String telefon, String user, String pass, String tipus) throws SQLException {
        try {
            this.conectar();
            this.connect.setAutoCommit(false);
            this.preparedStatement = this.connect.prepareStatement("update usuaris set nom=?, cognoms=?, telefon=?, login=?, contrasenya=?, tipus=? where id=?");
            this.preparedStatement.setString(1, nom);
            this.preparedStatement.setString(2, cognoms);
            this.preparedStatement.setString(3, telefon);
            this.preparedStatement.setString(4, user);
            this.preparedStatement.setString(5, pass);
            this.preparedStatement.setString(6, tipus);
            this.preparedStatement.setInt(7, id);
            this.preparedStatement.executeUpdate();
            this.connect.commit();
            this.preparedStatement.close();
            this.connect.close();
            return true;
        } catch (SQLIntegrityConstraintViolationException sqle) {
            System.out.println("El usuari ja existeix. Prova un altre.");
            return false;
        } catch (SQLException e) {
            System.out.println(e.toString());
            if (this.connect != null) {
                try {
                    this.connect.rollback();
                    return false;
                } catch (SQLException ex) {
                    System.out.println(ex.toString());
                    return false;
                }
            }
            return false;
        }
    }
    /**
     * Metode per eliminar un usuari, implementat de IUsuariDAO
     * @param id
     * @throws SQLException 
     */
    @Override
    public void borrarUsuari(int id) throws SQLException {
        try {
            this.conectar();
            this.statement = this.connect.createStatement();
            statement.executeUpdate("DELETE FROM usuaris where id='" + id + "'");
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    /**
     * Metode per llistas els usuaris en la taula, implementat de IUsuariDAO
     * @return
     * @throws SQLException 
     */
    @Override
    public ObservableList<Usuari> getUsuaris() throws SQLException {
        ObservableList<Usuari> o = FXCollections.observableArrayList();
        this.conectar();
        this.statement = this.connect.createStatement();
        this.resultSet = statement.executeQuery("SELECT * FROM usuaris");
        while (resultSet.next()) {
            if (resultSet.getString("tipus").equalsIgnoreCase("coordinador")) {
                o.add(new Coordinador(resultSet.getInt("id"), resultSet.getString("nom"), resultSet.getString("cognoms"), resultSet.getString("telefon"), resultSet.getString("login"), resultSet.getString("contrasenya")));
            } else if (resultSet.getString("tipus").equalsIgnoreCase("gestor")) {
                o.add(new Gestor(resultSet.getInt("id"), resultSet.getString("nom"), resultSet.getString("cognoms"), resultSet.getString("telefon"), resultSet.getString("login"), resultSet.getString("contrasenya")));
            } else {
                o.add(new Corrent(resultSet.getInt("id"), resultSet.getString("nom"), resultSet.getString("cognoms"), resultSet.getString("telefon"), resultSet.getString("login"), resultSet.getString("contrasenya")));
            }
        }
        this.resultSet.close();
        this.statement.close();
        this.connect.close();
        return o;
    }
    /**
     * Metode per registrar un avi a la BD, implementat de IAviDAO
     * @param nom
     * @param cognoms
     * @param edat
     * @param numTelefon
     * @param telefonFamiliar
     * @param minusvalia
     * @return
     * @throws SQLException 
     */
    @Override
    public boolean registrarAvi(String nom, String cognoms, int edat, String numTelefon, String telefonFamiliar, String minusvalia) throws SQLException {
        try {
            this.conectar();
            this.connect.setAutoCommit(false);
            this.preparedStatement = this.connect.prepareStatement("insert into avis(nom,cognoms,edat,minusvalia,telefon,telefonFamiliar) values (?, ?, ?, ?, ?, ?)");
            this.preparedStatement.setString(1, nom);
            this.preparedStatement.setString(2, cognoms);
            this.preparedStatement.setInt(3, edat);
            this.preparedStatement.setString(4, minusvalia);
            this.preparedStatement.setString(5, numTelefon);
            this.preparedStatement.setString(6, telefonFamiliar);
            this.preparedStatement.executeUpdate();
            this.connect.commit();
            this.preparedStatement.close();
            this.connect.close();
            return true;
        } catch (SQLIntegrityConstraintViolationException sqle) {
            System.out.println("El avi ja existeix. Prova un altre.");
            return false;
        } catch (SQLException e) {
            System.out.println(e.toString());
            if (this.connect != null) {
                try {
                    this.connect.rollback();
                    return false;
                } catch (SQLException ex) {
                    System.out.println(ex.toString());
                    return false;
                }
            }
            return false;
        }
    }
    /**
     * Metode per borrar una avi de la BD, implementat de IAviDAO
     * @param id
     * @throws SQLException 
     */
    @Override
    public void borrarAvi(int id) throws SQLException {
        try {
            this.conectar();
            this.statement = this.connect.createStatement();
            statement.executeUpdate("DELETE FROM avis where aviId='" + id + "'");
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    /**
     * Metode per llistar els avis, implementat de IAviDAO
     * @return
     * @throws SQLException 
     */
    @Override
    public ObservableList<Avi> getAvis() throws SQLException {
        ObservableList<Avi> o = FXCollections.observableArrayList();
        this.conectar();
        this.statement = this.connect.createStatement();
        this.resultSet = statement.executeQuery("SELECT * FROM avis");
        while (resultSet.next()) {
            Minusvalia min = Minusvalia.valueOf(resultSet.getString("minusvalia"));
            o.add(new Avi(resultSet.getInt("aviId"), resultSet.getString("nom"), resultSet.getString("cognoms"),resultSet.getInt("edat"), 
                    resultSet.getString("telefon"), resultSet.getString("telefonFamiliar"), min ));
        }
        this.resultSet.close();
        this.statement.close();
        this.connect.close();
        return o;
    }
    /**
     * Metode per editar avis, implementat de IAviDAO
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
    @Override
    public boolean editarAvi(int codiAvi, String nom, String cognoms, int edat, String numTelefon, String telefonFamiliar, String minusvalia) throws SQLException {
        try {
            this.conectar();
            this.connect.setAutoCommit(false);
            this.preparedStatement = this.connect.prepareStatement("update avis set nom=?, cognoms=?, edat=?, minusvalia=?, telefon=?, telefonFamiliar=? where aviId=?");
            this.preparedStatement.setString(1, nom);
            this.preparedStatement.setString(2, cognoms);
            this.preparedStatement.setInt(3, edat);
            this.preparedStatement.setString(4, minusvalia);
            this.preparedStatement.setString(5, numTelefon);
            this.preparedStatement.setString(6, telefonFamiliar);
            this.preparedStatement.setInt(7, codiAvi);
            this.preparedStatement.executeUpdate();
            this.connect.commit();
            this.preparedStatement.close();
            this.connect.close();
            return true;
        } catch (SQLIntegrityConstraintViolationException sqle) {
            System.out.println("El avi ja existeix. Prova un altre.");
            return false;
        } catch (SQLException e) {
            System.out.println(e.toString());
            if (this.connect != null) {
                try {
                    this.connect.rollback();
                    return false;
                } catch (SQLException ex) {
                    System.out.println(ex.toString());
                    return false;
                }
            }
            return false;
        }
    }

    /**
     * Metode per inicia sesio en l'aplicacio
     * @param user
     * @param pass
     * @return
     * @throws SQLException 
     */
    public boolean login(String user, String pass) throws SQLException {
        this.conectar();
        try {
            this.statement = this.connect.createStatement();
            this.resultSet = statement.executeQuery("SELECT * FROM usuaris where login='" + user + "' and contrasenya='" + pass + "'");
            return this.resultSet.isBeforeFirst();
        } catch (SQLIntegrityConstraintViolationException sqle) {
            System.out.println("El codi ja esta introduit. Prova un altre.");
            return false;
        }
    }
    /**
     * Metode per saber si un usuari es coordinador
     * @param user
     * @return
     * @throws SQLException 
     */
    public boolean coordinador(String user) throws SQLException {
        this.conectar();
        this.statement = this.connect.createStatement();
        this.resultSet = statement.executeQuery("SELECT * FROM usuaris where login='" + user + "'");
        while (resultSet.next()) {
            if (resultSet.getString("tipus").equalsIgnoreCase("coordinador")) {
                return true;
            } else {
                return false;
            }
        }
        this.resultSet.close();
        this.statement.close();
        this.connect.close();
        return false;
    }
    /**
     * Metode per saber si un usuari es gestor
     * @param user
     * @return
     * @throws SQLException 
     */
    public boolean gestor(String user) throws SQLException {
        this.conectar();
        this.statement = this.connect.createStatement();
        this.resultSet = statement.executeQuery("SELECT * FROM usuaris where login='" + user + "'");
        while (resultSet.next()) {
            if (resultSet.getString("tipus").equalsIgnoreCase("gestor")) {
                return true;
            } else {
                return false;
            }
        }
        this.resultSet.close();
        this.statement.close();
        this.connect.close();
        return false;
    }

}
