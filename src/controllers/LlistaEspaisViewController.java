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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Marcos
 */
public class LlistaEspaisViewController implements Initializable {

    @FXML
    private TextField buscadorEspai;
    @FXML
    private TableColumn<?, ?> colId;
    @FXML
    private TableColumn<?, ?> colLocalitzacio;
    @FXML
    private TableColumn<?, ?> colSuperficie;
    @FXML
    private TableColumn<?, ?> colSales;
    @FXML
    private TableColumn<?, ?> colMenajdor;
    @FXML
    private TableColumn<?, ?> colHabitacions;
    @FXML
    private TableColumn<?, ?> colAdaptat;
    @FXML
    private TableColumn<?, ?> colHabDisp;
    @FXML
    private TableView<?> tableEspais;
    @FXML
    private Button borrarEspai;

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
