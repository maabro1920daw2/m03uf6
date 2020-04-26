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
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
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
    private TableView<Usuari> tableUsuaris;
    @FXML
    private TableColumn colId;
    @FXML
    private TableColumn colNom;
    @FXML
    private TableColumn colCognoms;
    @FXML
    private TableColumn colTelefon;
    @FXML
    private TableColumn colUser;
    @FXML
    private TableColumn colContrasenya;
    @FXML
    private TableColumn colTipus;
    @FXML
    private TableColumn colBorrar;
    @FXML
    private Button editarUsuari;
    @FXML
    private Button borrarUsuari;

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

    @FXML
    private void eliminarUsuari(MouseEvent event) throws SQLException {
        Utilitat u = new Utilitat();
        Usuari g = tableUsuaris.getSelectionModel().getSelectedItem();
        u.borrarUsuari(g.getCodiUsuari());
        mostrar();
    }

    private void mostrar() {
        Utilitat u = new Utilitat();
        ObservableList<Usuari> gs = FXCollections.observableArrayList();
        try {
            gs = u.getUsuaris();
        } catch (SQLException ex) {
            Logger.getLogger(LlistaUsuarisViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        colId.setCellValueFactory(new PropertyValueFactory<>("codiUsuari"));
        colNom.setCellValueFactory(new PropertyValueFactory<>("nomUsuari"));
        colCognoms.setCellValueFactory(new PropertyValueFactory<>("cognomsUsuari"));
        colTelefon.setCellValueFactory(new PropertyValueFactory<>("telfUsuari"));
        colUser.setCellValueFactory(new PropertyValueFactory<>("loginUsuari"));
        colContrasenya.setCellValueFactory(new PropertyValueFactory<>("passUsuari"));
        colTipus.setCellValueFactory(new PropertyValueFactory<>("tipus"));

        FilteredList<Usuari> filteredData;
        filteredData = new FilteredList<>(gs, b -> true);

        buscadorUsuari.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(usuari -> {
                // If filter text is empty, display all persons.						
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();
                if (usuari.getNomUsuari().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches first name.
                } else if (usuari.getTipus().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else {
                    return false; // Does not match.
                }
            });
        });

        SortedList<Usuari> sortedData = new SortedList<>(filteredData);

        sortedData.comparatorProperty().bind(tableUsuaris.comparatorProperty());

        tableUsuaris.setItems(sortedData);
    }
}
