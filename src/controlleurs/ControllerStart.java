package controlleurs;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import vues.Main;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerStart implements Initializable {

    @FXML
    public TextField pseudo;

    @FXML
    public static Label verifPseudo;

    @FXML
    public Button boutonValider;

    @FXML
    public void validerPseudo() throws Exception {
        if (pseudo.getText().length() == 0) {
            verifPseudo.setVisible(true);
        }
        else {
            Main.start.close();

            Main.diceGame.showAndWait();
        }
    }

    // Méthode lancée quand la fenetre est créée
    public void initialize(URL location, ResourceBundle resources) {
        verifPseudo.setVisible(false);
    }
}
