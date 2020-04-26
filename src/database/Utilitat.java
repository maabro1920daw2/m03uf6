/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import classes.Coordinador;
import classes.Corrent;
import classes.Gestor;
import classes.Usuari;
import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author marco
 */
public class Utilitat {

    private Connection connect = null;
    private ResultSet resultSet = null;
    private PreparedStatement preparedStatement = null;
    private Statement statement = null;

    public void conectarDatabase() throws SQLException {
        try {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                System.out.println("Error al registrar el driver de MySQL: " + ex);
            }
            this.connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/BDGestion?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
        } catch (SQLException sqle) {
            System.out.println("Error: " + sqle);
        }
    }

    public boolean registrarUsuari(String nom, String cognoms, String telefon, String user, String pass, String tipus) throws SQLException {
        this.conectarDatabase();
        try {
            this.connect.setAutoCommit(false);
            Statement st = this.connect.createStatement();
            st.executeUpdate("INSERT INTO usuaris(nom,cognoms,telefon,login,contrasenya,tipus) VALUES('" + nom + "','" + cognoms + "','" + telefon + "','" + user + "','" + pass + "','" + tipus + "')");
            this.connect.commit();
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

    public void borrarUsuari(int id) throws SQLException {
        this.conectarDatabase();
        try {
            this.statement = this.connect.createStatement();
            statement.executeUpdate("DELETE FROM usuaris where id='" + id + "'");
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public boolean registrarAvi(String nom, String cognom, String tel, String familiar, int edat, String minus) throws SQLException {
        this.conectarDatabase();
        try {
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
        this.conectarDatabase();
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

    public ObservableList<Usuari> getUsuaris() throws SQLException {
        ObservableList<Usuari> o = FXCollections.observableArrayList();
        this.conectarDatabase();
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

    public void mostrarTaula() throws SQLException {
        this.conectarDatabase();
        this.statement = this.connect.createStatement();
        this.resultSet = statement.executeQuery("SELECT * FROM alumne");
        while (resultSet.next()) {
            System.out.println("-----------------------------------------------");
            System.out.println("Codi: " + resultSet.getInt("codi"));
            System.out.println("Nom: " + resultSet.getString("nom"));
            System.out.println("Cognom: " + resultSet.getString("cognom"));
            System.out.println("Nota: " + resultSet.getDouble("nota"));
            System.out.println("-----------------------------------------------\n");
        }
        this.resultSet.close();
        this.statement.close();
        this.connect.close();
    }

    public void mostrarCodi() throws SQLException {
        int codi;
        Scanner ent = new Scanner(System.in);
        this.conectarDatabase();
        try {
            System.out.println("Introdueix el codi de l'alumne:");
            codi = ent.nextInt();
            this.statement = this.connect.createStatement();
            this.resultSet = statement.executeQuery("SELECT * FROM alumne where codi=" + codi);
            while (resultSet.next()) {
                System.out.println("-----------------------------------------------");
                System.out.println("Codi: " + resultSet.getInt("codi"));
                System.out.println("Nom: " + resultSet.getString("nom"));
                System.out.println("Cognom: " + resultSet.getString("cognom"));
                System.out.println("Nota: " + resultSet.getDouble("nota"));
                System.out.println("-----------------------------------------------\n");
            }
            this.resultSet.close();
            this.statement.close();
            this.connect.close();
        } catch (InputMismatchException e) {
            System.out.println("El codi te que ser un nombre.");
        }
    }

    public boolean login(String user, String pass) throws SQLException {
        this.conectarDatabase();
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
        this.conectarDatabase();
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

        this.conectarDatabase();
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
