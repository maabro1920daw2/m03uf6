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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Marcos
 */
public class SuggerirEspaiViewController implements Initializable {
    private boolean coord,gestor;
    @FXML
    private TextField codiAvi;
    @FXML
    private TextField codiEspai;
    @FXML
    private DatePicker dataEntrada;
    @FXML
    private DatePicker dataSortida;
    @FXML
    private Button btnSuggerir;
    @FXML
    private Button btnValidar;
    @FXML
    private Button btnDenegar;
    @FXML
    private Button btnReformular;
    @FXML
    private AnchorPane coordPanel,gestorPanel;

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
    private void mostrar() {
        
       if(coord){
           gestorPanel.setVisible(false);
           
       }
       if(gestor){
           coordPanel.setVisible(false);
       }
    }
    
     @FXML
    public void whatTipus(boolean c,boolean g){
        System.out.println("hola");
        coord=c;
        gestor=g;
         mostrar();
    }
    
}
