package main;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


public class Main extends Application {

    public static Stage start;
    public static Stage diceGame;
    public static Stage regles;


    @Override
    public void start(Stage stage) throws Exception{

        start = new Stage();
        diceGame = new Stage();
        regles = new Stage();

        Parent root = FXMLLoader.load(getClass().getResource("../vues/start.fxml"));
        start.setResizable(false);
        start.setTitle("Entrez votre pseudo");
        start.setScene(new Scene(root, 600, 450));


        Parent root2 = FXMLLoader.load(getClass().getResource("../vues/diceGame.fxml"));
        diceGame.setResizable(false);
        diceGame.setTitle("Dice Game");
        diceGame.setScene(new Scene(root2, 600, 450));
        diceGame.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                System.exit(0);
            }
        });


        Parent root3 = FXMLLoader.load(getClass().getResource("../vues/regles.fxml"));
        regles.setResizable(false);
        regles.setTitle("Règles");
        regles.setScene(new Scene(root3, 600, 450));


        start.setResizable(false);

        start.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
