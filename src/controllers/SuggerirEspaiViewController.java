/*
 * Paquets
 */
package controllers;
/**
 * Imports
 */
import classes.Avi;
import classes.Coordinador;
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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Marcos, Victor
 */
public class SuggerirEspaiViewController implements Initializable {
    private boolean coord,gestor;
    @FXML
    private Button btnValidar;
    @FXML
    private Button btnDenegar;
    @FXML
    private Button btnReformular;
    @FXML
    private Pane paneCoordinador;
    @FXML
    private TableView<Avi> taulaSuggeriments;
    @FXML
    private TableColumn<?, ?> colId;
    @FXML
    private TableColumn<?, ?> colNom;
    @FXML
    private TableColumn<?, ?> colEspai;
    @FXML
    private TableColumn<?, ?> colEdat;
    @FXML
    private TableColumn<?, ?> colMinusvalia;
    @FXML
    private Pane paneGestor;
    @FXML
    private TextField codiAvi;
    @FXML
    private TextField codiEspai;
    @FXML
    private TextField codiEspaiR;
    @FXML
    private DatePicker dataEntrada;
    @FXML
    private DatePicker dataSortida;
    @FXML
    private Button btnSugerir;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mostrar();
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
     * Metode per habilitar opcions del menu depenent del tipus d'usuari
     */
    private void mostrar() {        
       if(coord){
           paneGestor.setVisible(false);           
       }
       if(gestor){
           paneCoordinador.setVisible(false);
       }
        Utilitat u = new Utilitat();
        ObservableList<Avi> gs = FXCollections.observableArrayList();
        try {
            gs = u.getAvisSugerits();
        } catch (SQLException ex) {
            Logger.getLogger(LlistaUsuarisViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        colId.setCellValueFactory(new PropertyValueFactory<>("codiAvi"));
        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colEspai.setCellValueFactory(new PropertyValueFactory<>("espai"));
        colEdat.setCellValueFactory(new PropertyValueFactory<>("edat"));
        colMinusvalia.setCellValueFactory(new PropertyValueFactory<>("minusvalia"));
        taulaSuggeriments.setItems(gs);
    }
    /**
     * Metode per identificar el tipus de l'usuari
     * @param c
     * @param g 
     */
    public void whatTipus(boolean c,boolean g){
        System.out.println("hola");
        coord=c;
        gestor=g;
        mostrar();
    }

    @FXML
    private void validar(MouseEvent event) throws SQLException {
        Utilitat u = new Utilitat();
        Avi a = taulaSuggeriments.getSelectionModel().getSelectedItem();
        Coordinador.validarAssignacio(a);
    }

    @FXML
    private void denegar(MouseEvent event) throws SQLException {
        Utilitat u = new Utilitat();
        Avi a = taulaSuggeriments.getSelectionModel().getSelectedItem();
        Coordinador.denegarAssignacio(a);
    }

    @FXML
    private void reformular(MouseEvent event) throws SQLException {
        Utilitat u = new Utilitat();
        Avi a = taulaSuggeriments.getSelectionModel().getSelectedItem();
        int codiE =Integer.parseInt(codiEspaiR.getText());
        Coordinador.reformularAssignacio(a,codiE);
    }

    @FXML
    private void sugerir(MouseEvent event) throws SQLException {
        Utilitat u = new Utilitat();
        String dateE=dataEntrada.getValue().toString();
        String dateS=dataSortida.getValue().toString();
        int codiA =Integer.parseInt(codiAvi.getText());
        int codiE =Integer.parseInt(codiEspai.getText());
        Gestor.sugerirLloc(codiA,codiE,dateE,dateS);
    }
    
    
    
}