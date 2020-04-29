/*
 * Paquets
 */
package controllers;
/**
 * Imports
 */
import database.Utilitat;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Marcos, Victor
 */
public class RegUsuariViewController implements Initializable {

    @FXML
    private TextField nomUsuari;
    @FXML
    private TextField cognomUsuari;
    @FXML
    private TextField telefonUsuari;
    @FXML
    private TextField loginUsuari;
    @FXML
    private PasswordField contrasenyaUsuari;
    @FXML
    private ComboBox<String> tipusUsuari;
    @FXML
    private Button btnGuardar;
    @FXML
    private Label infoCorrecto;
    @FXML
    private Label infoError;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> tipos = FXCollections.observableArrayList();
        tipos.addAll("Coordinador", "Gestor", "Corrent");
        tipusUsuari.setItems(tipos);
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
    /**
     * Metode per guardar a la BD desde la vista
     * @param event
     * @throws SQLException 
     */
    @FXML
    private void guardarBasedatos(MouseEvent event) throws SQLException {
        if(event.getSource().equals(btnGuardar)){
            Utilitat u= new Utilitat();           
            if(nomUsuari.getText().isEmpty() || cognomUsuari.getText().isEmpty() || telefonUsuari.getText().isEmpty() 
                    || loginUsuari.getText().isEmpty()  || contrasenyaUsuari.getText().isEmpty()){
                infoError.setVisible(true);
            }else{               
                u.registrarUsuari(nomUsuari.getText(),cognomUsuari.getText(),telefonUsuari.getText(),loginUsuari.getText(), 
                        contrasenyaUsuari.getText(), tipusUsuari.getValue());
                infoCorrecto.setVisible(true);
            }    
        }
    }
    
}
