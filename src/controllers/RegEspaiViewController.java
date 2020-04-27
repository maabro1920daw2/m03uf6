/*
 * Paquets
 */
package controllers;
/**
 * Imports
 */
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Marcos, Victor
 */
public class RegEspaiViewController implements Initializable {

    @FXML
    private TextField localitzacioEspai;
    @FXML
    private TextField superficieEspai;
    @FXML
    private TextField salesEspai;
    @FXML
    private TextField menajdorsEspai;
    @FXML
    private TextField habitacionsEspais;
    @FXML
    private RadioButton opSi;
    @FXML
    private ToggleGroup AdaptatGp;
    @FXML
    private RadioButton opNo;
    @FXML
    private Label infoError;
    @FXML
    private Label infoCorrecto;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        opSi.setToggleGroup(AdaptatGp);
        opNo.setToggleGroup(AdaptatGp);
        infoCorrecto.setVisible(false);
        infoError.setVisible(false);
    }    
    /**
     * Metode per tancar l'aplicacio
     * @param event 
     */
    @FXML
    private void cerrarPrograma(MouseEvent event) {
        System.exit(0);
    }
    
}
