/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Marcos
 */
public class ModificarEspaiViewController implements Initializable {

    @FXML
    private TextField modNom;
    @FXML
    private TextField modLocalitzacio;
    @FXML
    private TextField modSuperficie;
    @FXML
    private TextField modSales;
    @FXML
    private RadioButton opSi;
    @FXML
    private ToggleGroup gpAdaptat;
    @FXML
    private RadioButton opNo;
    @FXML
    private TextField modMenjadors;
    @FXML
    private TextField modHabitacions;
    @FXML
    private Button btnGuardar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        opSi.setToggleGroup(gpAdaptat);
        opNo.setToggleGroup(gpAdaptat);
    }    

    @FXML
    private void cerrarPrograma(MouseEvent event) {
        System.exit(0);
    }
    
}
