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
    public static Stage highScores;


    @Override
    public void start(Stage stage) throws Exception{

        start = new Stage();
        diceGame = new Stage();
        regles = new Stage();
        highScores = new Stage();

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
        regles.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                regles.close();
                diceGame.show();
            }
        });

        Parent root4 = FXMLLoader.load(getClass().getResource("../vues/highScores.fxml"));
        highScores.setResizable(false);
        highScores.setTitle("Règles");
        highScores.setScene(new Scene(root4, 600, 450));
        highScores.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                highScores.close();
                diceGame.show();
            }
        });

        start.setResizable(false);

        start.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
