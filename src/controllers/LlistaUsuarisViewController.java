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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Marcos
 */
public class LlistaUsuarisViewController implements Initializable {

    @FXML
    private TextField buscadorUsuari;
    @FXML
    private TableColumn<?, ?> colId;
    @FXML
    private TableColumn<?, ?> colNom;
    @FXML
    private TableColumn<?, ?> colCognoms;
    @FXML
    private TableColumn<?, ?> colTelefon;
    @FXML
    private TableColumn<?, ?> colUser;
    @FXML
    private TableColumn<?, ?> colContrasenya;
    @FXML
    private TableColumn<?, ?> colTipus;
    @FXML
    private TableColumn<?, ?> colBorrar;

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
