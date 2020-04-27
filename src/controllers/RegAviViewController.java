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
import java.util.regex.Pattern;
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
public class RegAviViewController implements Initializable {

    @FXML
    private TextField nomAvi;
    @FXML
    private TextField edatAvi;
    @FXML
    private TextField cognomAvi;
    @FXML
    private TextField telefonAvi;
    @FXML
    private TextField falimiarAvi;
    @FXML
    private Button btnGuardarAvi;
    @FXML
    private ComboBox<String> selectMinusvalia;
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
        selectMinusvalia.setItems(tipos);
        infoCorrecto.setVisible(false);
        infoError.setVisible(false);
    }

    /**
     * Metode per tancar l'aplicacio
     *
     * @param event
     */
    @FXML
    private void cerrarPrograma(MouseEvent event) {
        System.exit(0);
    }

    /**
     * Metode per guardar a la BD desde la vista
     *
     * @param event
     * @throws SQLException
     */
    @FXML
    private void guardarBasedatos(MouseEvent event) throws SQLException {
        if (event.getSource().equals(btnGuardarAvi)) {
            Utilitat u = new Utilitat();
            if (!stringContainsNumber(nomAvi.getText()) || !stringContainsNumber(cognomAvi.getText()) || !stringContainsLetter(telefonAvi.getText()) || !stringContainsLetter(falimiarAvi.getText())) {
                if (u.registrarAvi(nomAvi.getText(), cognomAvi.getText(), Integer.parseInt(edatAvi.getText()),
                        telefonAvi.getText(), falimiarAvi.getText(), selectMinusvalia.getValue())) {
                    infoCorrecto.setVisible(true);
                } else {
                    infoError.setVisible(true);
                }
            }
            else{
                infoError.setText("Algunas dadas no estan en formato completo");
                infoError.setVisible(true);
            }
        }
    }

    public boolean stringContainsNumber(String s) {
        return Pattern.compile("[0-9]").matcher(s).find();
    }
   public boolean stringContainsLetter(String s) {
        return Pattern.compile("[a-zA-Z]").matcher(s).find();
    }
}
