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
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Marcos
 */
public class RegUsuariViewController implements Initializable {

    @FXML
    private TextField nomUsuari;
    @FXML
    private TextField cognomUsuari;
    @FXML
    private TextField telefonUsuari;
    @FXML
    private TextField loginUsuari;
    @FXML
    private PasswordField contrasenyaUsuari;
    @FXML
    private ComboBox<?> tiupsUsuari;

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
    
}
