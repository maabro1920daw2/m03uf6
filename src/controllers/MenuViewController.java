/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author Marcos
 */
public class MenuViewController implements Initializable {

    @FXML
    private BorderPane mainPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    private void cerrarPrograma(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    private void regUsuari(MouseEvent event) {
    }

    @FXML
    private void modUsuari(MouseEvent event) {
    }

    @FXML
    private void cerUsuari(MouseEvent event) {
    }
    
    @FXML
    private void regAvi(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/views/RegAviView.fxml"));
        mainPane.setCenter(root);
    }
    
    @FXML
    private void modAvi(MouseEvent event) {
    }

    @FXML
    private void cerAvi(MouseEvent event) {
    }

    @FXML
    private void regEspai(MouseEvent event) {
    }

    @FXML
    private void modEspai(MouseEvent event) {
    }

    @FXML
    private void cerEspai(MouseEvent event) {
    }

    @FXML
    private void mosHistorial(MouseEvent event) {
    }
    
}