/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Marcos
 */
public class InicioController implements Initializable {
    @FXML
    private ImageView imgLogo;
    @FXML
    private AnchorPane content_area;
    @FXML
    private TextField loginName;
    @FXML
    private TextField loginPass;
    @FXML
    private Button btnLogin;
    @FXML
    private Button btnRegister;
    @FXML
    private TextField nombreUsuario;
    @FXML
    private TextField passwordUsuario;
    @FXML
    private ComboBox<String> tipoUsuario;
    @FXML
    private Button btnRegistro;
    @FXML
    private Button btnVolver;
    @FXML
    private Pane panelInicio;
    @FXML
    private Pane panelRegistro;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> tipos = FXCollections.observableArrayList();
        tipos.addAll("Coordinador", "Gestor", "Corrent");
        imgLogo.setImage(new Image ("file:/"+System.getProperty("user.dir").replace("\\", "/")+"/assets/img/logo_375x210px.png"));
        tipoUsuario.setItems(tipos);
    }
    
    @FXML
    private void cerrarPrograma(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    private void irRegistro(MouseEvent event) {
        if(event.getSource().equals(btnRegister)){
            panelRegistro.toFront();
        }
    }

    @FXML
    private void irLogin(MouseEvent event) {
        if(event.getSource().equals(btnVolver)){
            panelInicio.toFront();
        }
    }

    @FXML
    public void irMenu(ActionEvent event) throws IOException {
        Parent menuViewParent = FXMLLoader.load(getClass().getResource("/views/MenuView.fxml"));
        Scene menuViewScene = new Scene(menuViewParent);
        menuViewScene.getStylesheets().clear();
        
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(menuViewScene);
        window.show();
    }
    
}
