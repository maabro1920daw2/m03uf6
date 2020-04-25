/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import classes.Avi;
import classes.Gestor;
import classes.Usuari;
import database.Utilitat;


import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private TableView tableUsuaris;
    @FXML
    private TableColumn colId;
    @FXML
    private TableColumn colNom;
    @FXML
    private TableColumn<?, ?> colCognoms;
    @FXML
    private TableColumn<?, ?> colTelefon;
    @FXML
    private TableColumn colUser;
    @FXML
    private TableColumn colContrasenya;
    @FXML
    private TableColumn colTipus;
    @FXML
    private TableColumn<?, ?> colBorrar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Utilitat u=new Utilitat();
        ObservableList<Usuari> gs= FXCollections.observableArrayList();;
        try {
            gs = u.getUsuaris();
        } catch (SQLException ex) {
            Logger.getLogger(LlistaUsuarisViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        
        colId.setCellValueFactory(
                new PropertyValueFactory<>("codiUsuari"));
        colNom.setCellValueFactory(
                new PropertyValueFactory<>("nomUsuari"));
        colContrasenya.setCellValueFactory(
                new PropertyValueFactory<>("passUsuari"));
       colTipus.setCellValueFactory(
                new PropertyValueFactory<>("tipus"));
 
        tableUsuaris.getColumns().clear();
        tableUsuaris.setItems(gs);
        
        tableUsuaris.getColumns().addAll(colId, colNom, colContrasenya, colTipus);
    }    

    @FXML
    private void cerrarPrograma(MouseEvent event) {
        System.exit(0);
    }
    
}
