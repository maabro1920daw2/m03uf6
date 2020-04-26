/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import database.Utilitat;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Marcos
 */
public class MenuViewController implements Initializable {
    private boolean coord=false,gestor=false;
    @FXML
    private BorderPane mainPane;
    
    @FXML
    private Button regUser,modUser,cerUser;

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

    @FXML
    private void regUsuari(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/views/RegUsuariView.fxml"));
        mainPane.setCenter(root);
    }

    @FXML
    private void modUsuari(MouseEvent event) {
    }

    @FXML
    private void cerUsuari(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/views/LlistaUsuarisView.fxml"));
        mainPane.setCenter(root);
    }
    
    @FXML
    private void regAvi(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/views/RegAviView.fxml"));
        mainPane.setCenter(root);
    }
    
    @FXML
    private void modAvi(MouseEvent event) {
    }

    @FXML
    private void cerAvi(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/views/LlistaAvisView.fxml"));
        mainPane.setCenter(root);
    }

    @FXML
    private void regEspai(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/views/RegEspaiView.fxml"));
        mainPane.setCenter(root);
    }

    @FXML
    private void modEspai(MouseEvent event) {
    }

    @FXML
    private void cerEspai(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/views/LlistaEspaisView.fxml"));
        mainPane.setCenter(root);
    }

    @FXML
    private void mosHistorial(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/views/HistorialView.fxml"));
        mainPane.setCenter(root);
    }

    @FXML
    private void sugEspai(MouseEvent event) throws IOException {
        Utilitat u = new Utilitat();
         FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/SuggerirEspaiView.fxml"));
            Parent root = loader.load();

            SuggerirEspaiViewController s = loader.getController();

            s.whatTipus(coord,gestor);

            mainPane.setCenter(root);
    }
    
    @FXML
    public void isCoordinador(boolean message,boolean m2){
        coord=message;
        gestor=m2;
        if(!coord){
            regUser.setDisable(true);
            modUser.setDisable(true);
            cerUser.setDisable(true);
        }
    }
}