/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author marco
 */
public class Utilitat {

    private Connection connect = null;
    private ResultSet resultSet = null;
    private PreparedStatement preparedStatement = null;
    private Statement statement = null;

    private void conectarDatabase() throws SQLException {
        try {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                System.out.println("Error al registrar el driver de MySQL: " + ex);
            }
            this.connect = DriverManager.getConnection("jdbc:mysql://localhost:3308/BDAlumnes?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "root", "");
        } catch (SQLException sqle) {
            System.out.println("Error: " + sqle);
        }
    }

    public void afegirAlumne() throws SQLException {
        int codi;
        String nom, cognom;
        double nota;
        this.conectarDatabase();
        Scanner ent = new Scanner(System.in);
        try {
            System.out.println("Introdueix el codi de l'alumne:");
            codi = ent.nextInt();
            System.out.println("Introudeix el nom de l'alumne:");
            nom = ent.next();
            System.out.println("Introdueix el cognom de l'alumne:");
            cognom = ent.next();
            System.out.println("Introdueix la nota de l'alumne:");
            nota = ent.nextDouble();
            this.preparedStatement = this.connect.prepareStatement("insert into alumne values (?, ?, ?, ?)");
            this.preparedStatement.setInt(1, codi);
            this.preparedStatement.setString(2, nom);
            this.preparedStatement.setString(3, cognom);
            this.preparedStatement.setDouble(4, nota);
            this.preparedStatement.executeUpdate();
            this.preparedStatement.close();
            this.connect.close();
        } catch (SQLIntegrityConstraintViolationException sqle) {
            System.out.println("El codi ja esta introduit. Prova un altre.");
        }
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

}
