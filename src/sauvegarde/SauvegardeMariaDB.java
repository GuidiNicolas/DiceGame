package sauvegarde;

import persistance.GestionPersistance;

/**
 * Created by Nicochu on 05/02/2017.
 */
public class SauvegardeMariaDB extends Sauvegarde {

    public void sauvegarder() {
        System.out.println("Sauvegarde par MariaDB");
        GestionPersistance.sauvegarder(this.getPlayer());
    }

}
