package Controllers;

import Main.AmoebaApplication;
import com.google.inject.internal.asm.$Label;
import game.Game;
import game.Player;
import game.PlayerDao;
import game.Table;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.input.MouseEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DurationFormatUtils;

import java.awt.*;
import java.io.IOException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Slf4j
public class GameSceneController {

    private PlayerDao playerDao;
    private FXMLLoader fxmlLoader;
    private StartSceneController startSceneController;

    @FXML
    private GridPane gamePane;
    @FXML
    public static Label player1Name;
    @FXML
    public static Label player2Name;

    @FXML
    private Label MoveCount;
    @FXML
    private Label stopWatch;

    @FXML
    private Button Player1GiveUp;
    @FXML
    private Button Player2GiveUp;

    private Player Player1;
    private Player Player2;

    private Game game;
    public Timeline stopWatchTimeline;
    public Instant startTime;



    @FXML
    public void setPlayersName(String name1, String name2) {
//        log.info(name1);
//        log.info(name2);
//        player1Name.setText(name1);
//        player2Name.setText(name2);
        Player1 = new Player(name1);
        Player2 = new Player(name2);
        playerDao.persist(Player1.createPlayer());
        playerDao.persist(Player2.createPlayer());

//        Platform.runLater(() -> player1Name.setText(name1));
//        Platform.runLater(() -> player2Name.setText(name2));

    }

    @FXML
    public void startGame(String player1, String player2, int tableSize) {
        log.info("startGame");

//        setPlayersName(player1, player2);
//        Player1 = playerDao.findPlayer(player1);
//        Player2 = playerDao.findPlayer(player2);
//        game=new Game(Player1,Player2,tableSize);
//        table = new Table();
//        displayGameState();


//        for (int i=0;i<tableSize;i++) {
//            gamePane.addColumn(0);
//            gamePane.addRow(0);
//    }
    }

    @FXML
    public void handleClickOnCube(MouseEvent mouseEvent) throws IOException {
        int row = GridPane.getRowIndex((Node) mouseEvent.getSource());
        int col = GridPane.getColumnIndex((Node) mouseEvent.getSource());
        log.info("Clicked: " + row + ", " + col);

//            log.info("Index ({}, {}) is chosen.", row, col);
        if (Table.available(row, col, Table.getPlayerNum())) {
            MoveCount.setText(String.valueOf(Table.getMove()));
            Table.newMove();
            log.info("New move");
            displayGameState();
            log.info("Display");
            if (Table.check() == 1) {
                log.info("Player 1 win");
//                Player1.WinGame();
//                Player2.LoseGame();
                Parent root = fxmlLoader.load(getClass().getResource("/fxml/finalWindow.fxml"));
//                Scene scene = new Scene(root);
//                scene.getStylesheets().add("/Css/Style.css");
                Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
//                stage.setScene(scene);
                stage.setScene(new Scene(root));
                stage.show();
                AmoebaApplication.stage.getScene().setRoot(root);

            } else if (Table.check() == 2) {
                log.info("Player 2 win");
//                Player2.WinGame();
//                Player1.LoseGame();
                Parent root = fxmlLoader.load(getClass().getResource("/fxml/finalWindow.fxml"));
//                Scene scene = new Scene(root);
//                scene.getStylesheets().add("/Css/Style.css");
                Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
//                stage.setScene(scene);
                stage.setScene(new Scene(root));
                stage.show();
                AmoebaApplication.stage.getScene().setRoot(root);

            }
        }
        displayGameState();
        log.info("Display");
    }

    @FXML
    public void Player1GiveUp(ActionEvent event) throws IOException {
        log.info("Player 1 gave up.");
//        Player1.LoseGame();
//        Player2.WinGame();
//            gameOver.setValue(true);
        Player2GiveUp.setDisable(true);
        Parent root = fxmlLoader.load(getClass().getResource("/fxml/finalWindow.fxml"));
//                Scene scene = new Scene(root);
//                scene.getStylesheets().add("/Css/Style.css");
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//                stage.setScene(scene);
        stage.setScene(new Scene(root));
        stage.show();
        AmoebaApplication.stage.getScene().setRoot(root);

    }

    @FXML
    public void Player2GiveUp(ActionEvent event) throws IOException {
        log.info("Player 2 gave up.");
//        Player2.LoseGame();
//        Player1.WinGame();
//            gameOver.setValue(true);
        Player1GiveUp.setDisable(true);
        Parent root = fxmlLoader.load(getClass().getResource("/fxml/finalWindow.fxml"));
//                Scene scene = new Scene(root);
//                scene.getStylesheets().add("/Css/Style.css");
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//                stage.setScene(scene);
        stage.setScene(new Scene(root));
        stage.show();
        AmoebaApplication.stage.getScene().setRoot(root);

    }


    public void displayGameState() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                ImageView view = (ImageView) gamePane.getChildren().get(i * 10 + j);
//                if (view.getImage() != null) {
//                    log.trace("Image({}, {}) = {}", i, j, view.getImage().getUrl());
//                }
                if (Table.table[i][j] == 1) {
                    view.setImage(StartSceneController.X);
                } else if (Table.table[i][j] == 2) {
                    view.setImage(StartSceneController.O);
                } else if (Table.table[i][j] == 0) {
                    view.setImage(StartSceneController.empty);
                }
            }
        }
    }

    public void createStopWatch() {
        stopWatchTimeline = new Timeline(new KeyFrame(javafx.util.Duration.ZERO, e -> {
            long millisElapsed = startTime.until(Instant.now(), ChronoUnit.MILLIS);
            stopWatch.setText(DurationFormatUtils.formatDuration(millisElapsed, "HH:mm:ss"));
        }), new KeyFrame(javafx.util.Duration.seconds(1)));
        stopWatchTimeline.setCycleCount(Animation.INDEFINITE);
        stopWatchTimeline.play();
    }
}
