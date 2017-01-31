package controlleurs;

import diceGame.DiceGame;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ControllerDiceGame {

    @FXML
    public static Button boutonJouer;

    public void play() {
        DiceGame dg = DiceGame.getInstance();
    }

}
