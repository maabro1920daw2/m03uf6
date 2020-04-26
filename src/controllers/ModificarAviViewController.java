/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Marcos
 */
public class ModificarAviViewController implements Initializable {

    @FXML
    private TextField modNom;
    @FXML
    private TextField modCognoms;
    @FXML
    private TextField modEdat;
    @FXML
    private TextField modTelefon;
    @FXML
    private TextField modFamiliar;
    @FXML
    private ComboBox<String> modTipus;
    @FXML
    private Button btnGuardar;
    @FXML
    private TextField idAvi;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> tipos = FXCollections.observableArrayList();
        tipos.addAll("FISICA", "PSIQUICA");
        modTipus.setItems(tipos);
    }    

    @FXML
    private void cerrarPrograma(MouseEvent event) {
        System.exit(0);
    }
    
}
