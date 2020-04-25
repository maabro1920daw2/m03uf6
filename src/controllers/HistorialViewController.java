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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Marcos
 */
public class HistorialViewController implements Initializable {

    @FXML
    private DatePicker dataEntrada;
    @FXML
    private DatePicker dataSortida;
    @FXML
    private TableColumn<?, ?> colId;
    @FXML
    private TableColumn<?, ?> colNom;
    @FXML
    private TableColumn<?, ?> colEspai;
    @FXML
    private TableColumn<?, ?> colEntrada;
    @FXML
    private TableColumn<?, ?> colSortida;

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
