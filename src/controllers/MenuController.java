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
public class MenuController implements Initializable {

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
    private void cambioEscena1(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/views/Escena1.fxml"));
        mainPane.setCenter(root);
    }

    @FXML
    private void cambioEscena2(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/views/Escena2.fxml"));
        mainPane.setCenter(root);
    }
    
}