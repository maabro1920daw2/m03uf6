/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import classes.Avi;
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
public class LlistaAvisViewController implements Initializable {

    @FXML
    private TextField buscadorAvi;
    @FXML
    private TableColumn colId;
    @FXML
    private TableColumn colNom;
    @FXML
    private TableColumn colCognoms;
    @FXML
    private TableColumn colEspai;
    @FXML
    private TableColumn colTelf;
    @FXML
    private TableColumn colTelfFamiliar;
    @FXML
    private TableView<Avi> tableAvis;
    @FXML
    private Button borrarAvi;
    @FXML
    private TableColumn colMinusvalia;
    @FXML
    private TableColumn colEdat;

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
        ObservableList<Avi> gs = FXCollections.observableArrayList();
        try {
            gs = u.getAvis();
        } catch (SQLException ex) {
            Logger.getLogger(LlistaUsuarisViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        colId.setCellValueFactory(new PropertyValueFactory<>("codiAvi"));
        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colCognoms.setCellValueFactory(new PropertyValueFactory<>("cognoms"));
        colEdat.setCellValueFactory(new PropertyValueFactory<>("edat"));
        colEspai.setCellValueFactory(new PropertyValueFactory<>("espai"));
        colTelf.setCellValueFactory(new PropertyValueFactory<>("numTelefon"));
        colTelfFamiliar.setCellValueFactory(new PropertyValueFactory<>("telefonFamiliar"));
        colMinusvalia.setCellValueFactory(new PropertyValueFactory<>("minusvalia"));

        FilteredList<Avi> filteredData;
        filteredData = new FilteredList<>(gs, b -> true);

        buscadorAvi.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(avi -> {
                // If filter text is empty, display all persons.						
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();
                if (avi.getNom().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches first name.
                } else if (avi.getCognoms().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                }else {
                    return false; // Does not match.
                }
            });
        });

        SortedList<Avi> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableAvis.comparatorProperty());
        tableAvis.setItems(sortedData);
    }

    @FXML
    private void eliminarAvi(MouseEvent event) throws SQLException {
        Utilitat u = new Utilitat();
        Avi g = tableAvis.getSelectionModel().getSelectedItem();
        u.borrarAvi(g.getCodiAvi());
        mostrar();
    }
    
}
