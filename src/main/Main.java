package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    public static Stage start;
    public static Stage diceGame;


    @Override
    public void start(Stage stage) throws Exception{

        start = new Stage();
        diceGame = new Stage();

        Parent root = FXMLLoader.load(getClass().getResource("../vues/start.fxml"));
        start.setTitle("Entrez votre pseudo");
        start.setScene(new Scene(root, 600, 450));

        Parent root2 = FXMLLoader.load(getClass().getResource("../vues/diceGame.fxml"));
        diceGame.setTitle("Dice Game");
        diceGame.setScene(new Scene(root2, 600, 450));


        start.setResizable(false);

        start.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
