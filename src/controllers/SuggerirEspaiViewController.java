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
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
    private TableView<?> taulaSuggeriments;
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
    
}