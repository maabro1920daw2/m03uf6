/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

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
    private ComboBox<?> tipoUsuario;
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
        imgLogo.setImage(new Image ("file:/"+System.getProperty("user.dir").replace("\\", "/")+"/assets/img/logo_375x210px.png"));
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
    
}
