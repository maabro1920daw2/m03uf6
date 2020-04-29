/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import classes.Espai;
import classes.Usuari;
import database.Utilitat;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
public class LlistaEspaisViewController implements Initializable {

    @FXML
    private TextField buscadorEspai;
    @FXML
    private TableColumn colId;
    @FXML
    private TableColumn colLocalitzacio;
    @FXML
    private TableColumn colSuperficie;
    @FXML
    private TableColumn colSales;
    @FXML
    private TableColumn colMenajdor;
    @FXML
    private TableColumn colHabitacions;
    @FXML
    private TableColumn colAdaptat;
    @FXML
    private TableColumn colHabDisp;
    @FXML
    private TableView<Espai> tableEspais;
    @FXML
    private Button borrarEspai;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mostrar(); 
    }
    
    @FXML
    private void cerrarPrograma(MouseEvent event) {
        System.exit(0);
    }
    
    private void mostrar() {
        Utilitat u = new Utilitat();
        ObservableList<Espai> gs = FXCollections.observableArrayList();
        try {
            gs = u.getEspais();
        } catch (SQLException ex) {
            Logger.getLogger(LlistaUsuarisViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        colId.setCellValueFactory(new PropertyValueFactory<>("codiEspai"));
        colLocalitzacio.setCellValueFactory(new PropertyValueFactory<>("localitzacio"));
        colSuperficie.setCellValueFactory(new PropertyValueFactory<>("metresQuadrats"));
        colSales.setCellValueFactory(new PropertyValueFactory<>("sales"));
        colMenajdor.setCellValueFactory(new PropertyValueFactory<>("menjadors"));
        colHabitacions.setCellValueFactory(new PropertyValueFactory<>("habitacions"));
        colAdaptat.setCellValueFactory(new PropertyValueFactory<>("adaptat"));
        colHabDisp.setCellValueFactory(new PropertyValueFactory<>("llitsDisponibles"));

        FilteredList<Espai> filteredData;
        filteredData = new FilteredList<>(gs, b -> true);

        buscadorEspai.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(espai -> {						
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (espai.getLocalitzacio().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches first name.
                } else {
                    return false; // Does not match.
                }
            });
        });

        SortedList<Espai> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableEspais.comparatorProperty());
        tableEspais.setItems(sortedData);
    }    
}
