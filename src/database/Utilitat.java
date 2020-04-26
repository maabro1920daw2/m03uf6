/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import classes.Avi;
import classes.Coordinador;
import classes.Corrent;
import classes.Gestor;
import classes.Usuari;
import interfaces.IAviDAO;
import interfaces.IUsuariDAO;
import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author marco
 */
public class Utilitat extends Connexio implements IUsuariDAO, IAviDAO {

    private ResultSet resultSet = null;
    private PreparedStatement preparedStatement = null;
    private Statement statement = null;
    
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

    @Override
    public boolean registrarAvi(String nom, String cognoms, String telefon, String user, String pass, String tipus) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borrarAvi(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObservableList<Avi> getAvis() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean editarAvi(int id, String nom, String cognoms, String telefon, String user, String pass, String tipus) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean registrarAvi(String nom, String cognom, String tel, String familiar, int edat, String minus) throws SQLException {
        try {
            this.conectar();
            this.connect.setAutoCommit(false);
            Statement st = this.connect.createStatement();
            st.executeUpdate("INSERT INTO AVIS(nom,cognom,edat,tel,familiar) VALUES(" + nom + "," + cognom + "," + edat + "," + tel + "," + familiar + "," + minus + ")");
            this.connect.commit();
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

    public boolean registrarEspai(String localitzacio, float superficie, int sales, int menaidors, int habitacions) throws SQLException {
        this.conectar();
        try {
            this.connect.setAutoCommit(false);
            Statement st = this.connect.createStatement();
            st.executeUpdate("INSERT INTO ESPAIS(localitzacio,superficie,sales,menaidors,habitacions) VALUES(" + localitzacio + "," + superficie + "," + sales + "," + menaidors + "," + habitacions + ")");
            this.connect.commit();
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
