/*
 * Paquets
 */
package controllers;
/**
 * Imports
 */
import database.Utilitat;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Marcos, Victor
 */
public class ModificarAviViewController implements Initializable {

    @FXML
    private TextField modNom;
    @FXML
    private TextField modCognoms;
    @FXML
    private TextField modEdat;
    @FXML
    private TextField modTelefon;
    @FXML
    private TextField modFamiliar;
    @FXML
    private ComboBox<String> modTipus;
    @FXML
    private Button btnGuardar;
    @FXML
    private TextField idAvi;
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
        tipos.addAll("FISICA", "PSIQUICA", "CAP");
        modTipus.setItems(tipos);
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
     * Metode per actualitzar la BD desde la vista
     * @param event
     * @throws SQLException 
     */
    @FXML
    private void actualizarBD(MouseEvent event) throws SQLException {
        if(event.getSource().equals(btnGuardar)){
            Utilitat u= new Utilitat();           
            if(u.editarAvi(Integer.parseInt(idAvi.getText()), modNom.getText(), modCognoms.getText(),
                    Integer.parseInt(modEdat.getText()), modTelefon.getText(), modFamiliar.getText(), modTipus.getValue())){
                infoCorrecto.setVisible(true);
            }else{
                infoError.setVisible(true);
            }    
        }
    }
    
}
