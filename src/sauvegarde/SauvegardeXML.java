package sauvegarde;

import java.io.*;

/**
 * Created by Nicochu on 05/02/2017.
 */
public class SauvegardeXML extends Sauvegarde {

    public void sauvegarder() {

        System.out.println("Sauvegarde par XML");

        StringWriter out = new StringWriter();
        String fichierXML = "";
        try {
            BufferedInputStream in = new BufferedInputStream(new FileInputStream(new File("scores.XML")));
            int b;
            while ((b=in.read()) != -1)
                out.write(b);
            out.flush();
            out.close();
            in.close();

            fichierXML = out.toString();
        }
        catch (IOException ie)
        {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(new File("scores.XML")));
                // normalement si le fichier n'existe pas, il est crée à la racine du projet
                writer.write("");

                writer.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        if ( !(fichierXML.startsWith("<resultats>"))) {
            fichierXML = "<resultats>\n</resultats>";
        }

        String sauvegarde = "\t<resultat>\n\t\t<nom>\n\t\t\t"+ this.getPlayer().getNom()+"\n\t\t</nom>\n\t\t<score>\n\t\t\t"+ this.getPlayer().getScore() +"\n\t\t</score>\n\t</resultat>\n";

        fichierXML = fichierXML.substring(0,fichierXML.length()-12) + sauvegarde + "</resultats>";

        try {
            FileWriter MyFile= new FileWriter("scores.XML",false);
            MyFile.write(fichierXML);
            MyFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
