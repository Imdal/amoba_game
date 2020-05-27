package Controllers;

import Main.AmoebaApplication;
import game.Game;
import game.Player;
import game.PlayerDao;
import game.Table;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;


import java.io.IOException;
import java.time.Instant;

@Slf4j
public class StartSceneController {
    private PlayerDao playerDao;
    private GameSceneController gameSceneController=new GameSceneController();

    @Inject
    private FXMLLoader fxmlLoader;

    @FXML
    private TextField Player1NameText;
    @FXML
    private TextField Player2NameText;

    @FXML
    private Label player1label;
    @FXML
    private Label player2label;

    @FXML
    private Slider TableSizeSlider;

    public static Image X;
    public static Image O;
    public static Image empty;
    private Player Player1;
    private Player Player2;


    @FXML
    void startAction(ActionEvent event) throws IOException {
        if(Player2NameText.getText().equals(Player1NameText.getText())) {
            player1label.setTextFill(Color.web("#ff0000"));
            player2label.setTextFill(Color.web("#ff0000"));
        }
        else if (Player1NameText.getText().isEmpty()) {
            player1label.setTextFill(Color.web("#ff0000"));
        }
        else if(Player2NameText.getText().isEmpty())
        {
            player1label.setTextFill(Color.web("#000000"));
            player2label.setTextFill(Color.web("#ff0000"));
        }
        else {
            player2label.setTextFill(Color.web("#000000"));
            player1label.setTextFill(Color.web("#000000"));

            Parent root = fxmlLoader.load(getClass().getResource("/fxml/gameWindow.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add("/Css/Style.css");
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
            AmoebaApplication.stage.getScene().setRoot(root);
//            gameSceneController.createStopWatch();
//            gameSceneController.startTime = Instant.now();

//
//        gameSceneController.startGame(Player1NameText.getText(), Player2NameText.getText(),(int) TableSizeSlider.getValue());
//        fxmlLoader.<GameSceneController>getController().startGame(Player1NameText.getText(), Player2NameText.getText(),(int) TableSizeSlider.getValue());

            log.info("Table init");
            log.info("Table cout");
//        Table.cout();
            O = new Image("images/aqDRd4o.png");
            X = new Image("images/OhAJg3J.png");
            empty = new Image("images/empty.png");
            log.info("Set names");
            Table.setInitTable();
            Game.setPlayers(Player1NameText.getText(), Player2NameText.getText());
//            gameSceneController.setPlayersName();
            fxmlLoader.<GameSceneController>getController().setPlayersName();
//            gameSceneController.setPlayersName(Player1NameText.getText(), Player2NameText.getText());
//            fxmlLoader.<GameSceneController>getController().setPlayersName(Player1NameText.getText(), Player2NameText.getText());
//            GameSceneController.player1Name.setText(Player1NameText.getText());
//            GameSceneController.player2Name.setText(Player2NameText.getText());
//            Player1=playerDao.findPlayer(Player1NameText.getText());
//            Player2=playerDao.findPlayer(Player2NameText.getText());
//                Player1 = new Player(Player1NameText.getText());
//                Player2 = new Player(Player2NameText.getText());
//                playerDao.persist(Player1.createPlayer());
//                playerDao.persist(Player2.createPlayer());

//        Platform.runLater(() -> player1Name.setText(name1));
//        Platform.runLater(() -> player2Name.setText(name2));


        }
    }
}