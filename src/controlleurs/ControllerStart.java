package controlleurs;

import diceGame.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import main.Main;

public class ControllerStart{

    @FXML
    public TextField pseudo;

    @FXML
    public Label verifPseudo;

    @FXML
    public void validerPseudo() throws Exception {
        if ( (pseudo.getText().length() == 0) || ((pseudo.getText().length() > 15))) {
            verifPseudo.setText("Entrez un pseudo ! (Maximum 15 caractères)");
        }
        else {
            Player.getInstance().setNom(pseudo.getText());

            Main.start.close();
            Main.diceGame.showAndWait();
        }
    }
}
