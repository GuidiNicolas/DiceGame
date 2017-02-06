package sauvegarde;

import diceGame.Player;

/**
 * Created by Nicochu on 05/02/2017.
 */
public abstract class Sauvegarde {

    Player player = Player.getInstance();

    public Player getPlayer() {
        return player;
    }

    public abstract void sauvegarder();
}
