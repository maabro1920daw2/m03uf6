/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.TextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author >Victor
 */
public class main {
     private Connection connect = null;
    private ResultSet resultSet = null;
    private PreparedStatement preparedStatement = null;
    private Statement statement = null;
    public static void main(String[] args) {
        
    }
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
     @FXML
    private TextField loginName, loginPass;
     @FXML 
     private AnchorPane rootPane;
     @FXML
    protected void login(ActionEvent event) throws SQLException {
        String name = loginName.getText();
        String pass =loginPass.getText();
        this.conectarDatabase();
        try {
            System.out.println("Introdueix el codi de l'alumne:");
            
            this.statement = this.connect.createStatement();
            this.resultSet = statement.executeQuery("SELECT * FROM alumne where name=" + name+" and pass="+pass);
            if (this.resultSet!=null) {
                //AnchorPane pane=FXMLLoader.load(getClass().getResource("f2.fxml"));
                //rootPane.getChildren().setAll(pane);
            }
            else{
                //write wrong username or password
            }
            this.resultSet.close();
            this.statement.close();
            this.connect.close();
        } catch (InputMismatchException e) {
            System.out.println("El codi te que ser un nombre.");
        }

    }

    }

