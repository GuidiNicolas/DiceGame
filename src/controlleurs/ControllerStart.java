package controlleurs;

import diceGame.Player;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import main.Main;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerStart implements Initializable{

    @FXML
    public TextField pseudo;

    @FXML
    public Label verifPseudo;

    @FXML
    public void validerPseudo() throws Exception {
        if (pseudo.getText().length() == 0) {
            verifPseudo.setText("Entrez un pseudo !");
        }
        else {
            Player.getInstance().setNom(pseudo.getText());

            Main.start.close();
            Main.diceGame.showAndWait();
        }
    }

    // Méthode lancée quand la fenetre est créée
    public void initialize(URL location, ResourceBundle resources) {

    }
}
