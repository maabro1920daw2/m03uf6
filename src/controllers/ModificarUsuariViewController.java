/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Marcos
 */
public class ModificarUsuariViewController implements Initializable {

    @FXML
    private TextField modNom;
    @FXML
    private TextField modCognoms;
    @FXML
    private TextField modTelefon;
    @FXML
    private TextField modLogin;
    @FXML
    private PasswordField modContrasenya;
    @FXML
    private ComboBox<String> modTipus;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> tipos = FXCollections.observableArrayList();
        tipos.addAll("Coordinador", "Gestor", "Corrent");
        modTipus.setItems(tipos);
    }    

    @FXML
    private void cerrarPrograma(MouseEvent event) {
    }
    
}
