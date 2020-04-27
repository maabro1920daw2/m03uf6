/*
 * Paquets
 */
package main;
/**
 * Imports
 */
import java.awt.TextField;
import java.io.File;
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
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
/**
 * Clase principal de l'aplicacio
 * @author >Victor, Marcos
 */
public class main extends Application {
    private Connection connect = null;
    private ResultSet resultSet = null;
    private PreparedStatement preparedStatement = null;
    private Statement statement = null;
    public static void main(String[] args) {
        launch(args);
    }
    /**
     * Metode per iniciar l'escena
     * @param stage
     * @throws Exception 
     */
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/views/InicioView.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().clear();
        //scene.getStylesheets().add("style.css");
        stage.initStyle( StageStyle.UNDECORATED );
        stage.setScene(scene);
        stage.show();      
    }
}