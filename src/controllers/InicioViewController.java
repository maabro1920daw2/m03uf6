/**
 * Paquets
 */
package controllers;
/**
 * Imports
 */
import database.Utilitat;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import javafx.util.Duration;
import java.util.ResourceBundle;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Marcos, Victor
 */
public class InicioViewController implements Initializable {

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
    private Label errorInicio;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        imgLogo.setImage(new Image("file:/" + System.getProperty("user.dir").replace("\\", "/") + "/assets/img/logo_375x210px.png"));
        errorInicio.setVisible(false);
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
     * Metode per anar al menu dins la vista
     * @param event
     * @throws IOException
     * @throws SQLException 
     */
    @FXML
    public void irMenu(ActionEvent event) throws IOException, SQLException {
        Utilitat u = new Utilitat();

        String usuario = loginName.getText();
        String password = loginPass.getText();

        if (u.login(usuario, password)) {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/MenuView.fxml"));
            Parent root = loader.load();

            MenuViewController m = loader.getController();

            m.isCoordinador(u.coordinador(usuario),u.gestor(usuario),u.corrent(usuario));

            Scene scene = btnLogin.getScene();

            root.translateXProperty().set(scene.getWidth());

            AnchorPane parentContainer = (AnchorPane) btnLogin.getScene().getRoot();

            parentContainer.getChildren().add(root);

            Timeline timeline = new Timeline();
            KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_IN);
            KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
            timeline.getKeyFrames().add(kf);
            timeline.setOnFinished(t -> {
                parentContainer.getChildren().remove(content_area);
            });
            timeline.play();
            
        } else {
            errorInicio.setVisible(true);
        }
    }
}
