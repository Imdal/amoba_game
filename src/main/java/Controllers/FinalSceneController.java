package Controllers;

import Main.AmoebaApplication;
import game.Game;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;


import javax.inject.Inject;
import java.io.IOException;

@Slf4j
public class FinalSceneController {
    @Inject
    private FXMLLoader fxmlLoader;
    @FXML
    private Label Player1Label;
    @FXML
    private Label lifetimeGames1;
    @FXML
    private Label winGames1;
    @FXML
    private Label loseGames1;
    @FXML
    private Label winRow1;
    @FXML
    private Label bestWinRow1;
    @FXML
    private Label Player2Label;
    @FXML
    private Label lifetimeGames2;
    @FXML
    private Label winGames2;
    @FXML
    private Label loseGames2;
    @FXML
    private Label winRow2;
    @FXML
    private Label bestWinRow2;
    @FXML
    private ImageView winner1;
    @FXML
    private ImageView winner2;

    @FXML
    public void newGame(ActionEvent event) throws IOException {
        log.info("Starting application...");
        Parent root = fxmlLoader.load(getClass().getResource("/fxml/startWindow.fxml"));
                Scene scene = new Scene(root);
                scene.getStylesheets().add("/Css/Style.css");
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        AmoebaApplication.stage.getScene().setRoot(root);

    }

    public void showPlayer1Stats() {
        if (Game.Winner==1) {
            winner1.setImage(new Image("/images/Crown.png"));
            winner1.setFitWidth(40);
        }
        Player1Label.setText(Game.player1Name);
        lifetimeGames1.setText(String.valueOf(Game.Player1.getGames()));
        winGames1.setText(String.valueOf(Game.Player1.getWins()));
        loseGames1.setText(String.valueOf(Game.Player1.getGames()-Game.Player1.getWins()));
        winRow1.setText(String.valueOf(Game.Player1.getWinRow()));
        bestWinRow1.setText(String.valueOf(Game.Player1.getBestWinRow()));
    }

    public void showPlayer2Stats() {
        if (Game.Winner==2) {
            winner2.setImage(new Image("/images/Crown.png"));
            winner2.setFitWidth(40);
        }
        Player2Label.setText((Game.player2Name));
        lifetimeGames2.setText(String.valueOf(Game.Player2.getGames()));
        winGames2.setText(String.valueOf(Game.Player2.getWins()));
        loseGames2.setText(String.valueOf(Game.Player2.getGames()-Game.Player2.getWins()));
        winRow2.setText(String.valueOf(Game.Player2.getWinRow()));
        bestWinRow2.setText(String.valueOf(Game.Player2.getBestWinRow()));
    }

    public void exit() {
        Platform.exit();
        System.exit(0);
    }

}
