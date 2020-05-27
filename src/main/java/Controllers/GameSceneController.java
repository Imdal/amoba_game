package Controllers;

import Main.AmoebaApplication;
import game.Game;
import game.Table;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DurationFormatUtils;

import javax.inject.Inject;
import java.io.IOException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Slf4j
public class GameSceneController {

    @Inject
    private FXMLLoader fxmlLoader;
    @FXML
    private GridPane gamePane;
    @FXML
    public Label player1Name;
    @FXML
    public Label player2Name;
    @FXML
    private Label MoveCount;
    @FXML
    private Label stopWatch;
    @FXML
    private Button Player1GiveUp;
    @FXML
    private Button Player2GiveUp;

    public Timeline stopWatchTimeline;
    public Instant startTime;


    public void handleClickOnCell(MouseEvent mouseEvent) throws IOException {
        int row = GridPane.getRowIndex((Node) mouseEvent.getSource());
        int col = GridPane.getColumnIndex((Node) mouseEvent.getSource());
        log.info("Clicked: " + row + ", " + col);

        log.info("set Player 1 name to {}",Game.player1Name);
        player1Name.setText(Game.player1Name);
        log.info("set Player 2 name to {}",Game.player2Name);
        player2Name.setText(Game.player2Name);


        if (Table.available(row, col, Table.getPlayerNum())) {
            MoveCount.setText(String.valueOf(Table.getMove()));
            Table.newMove();
            log.info("New move");
            displayGameState();
            log.info("Display");
            if (Table.check() == 1) {
                log.info("Player 1 win");
                Game.Player1.WinGame();
                Game.Winner=1;
                Game.Player2.LoseGame();
                Parent root = fxmlLoader.load(getClass().getResource("/fxml/finalWindow.fxml"));
                Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                scene.getStylesheets().add("/Css/Style.css");
                stage.setScene(scene);
                stage.show();
                AmoebaApplication.stage.getScene().setRoot(root);

            } else if (Table.check() == 2) {
                log.info("Player 2 win");
                Game.Player2.WinGame();
                Game.Winner=2;
                Game.Player1.LoseGame();
                Parent root = fxmlLoader.load(getClass().getResource("/fxml/finalWindow.fxml"));
                Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                scene.getStylesheets().add("/Css/Style.css");
                stage.setScene(scene);
                stage.show();
                AmoebaApplication.stage.getScene().setRoot(root);
            } else if(Table.fullTable()) {
                log.info("Draw");
                Game.Player1.LoseGame();
                Game.Player2.LoseGame();
                Parent root = fxmlLoader.load(getClass().getResource("/fxml/finalWindow.fxml"));
                Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                scene.getStylesheets().add("/Css/Style.css");
                stage.setScene(scene);
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
        Game.Player1.LoseGame();
        Game.Player2.WinGame();
        Game.Winner=2;
        Player2GiveUp.setDisable(true);
        Parent root = fxmlLoader.load(getClass().getResource("/fxml/finalWindow.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/Css/Style.css");
        stage.setScene(scene);
        stage.show();
        AmoebaApplication.stage.getScene().setRoot(root);

    }

    @FXML
    public void Player2GiveUp(ActionEvent event) throws IOException {
        log.info("Player 2 gave up.");
        Game.Player2.LoseGame();
        Game.Player1.WinGame();
        Game.Winner=1;
        Player1GiveUp.setDisable(true);
        Parent root = fxmlLoader.load(getClass().getResource("/fxml/finalWindow.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/Css/Style.css");
        stage.setScene(scene);
        stage.show();
        AmoebaApplication.stage.getScene().setRoot(root);

    }


    public void displayGameState() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                ImageView view = (ImageView) gamePane.getChildren().get(i * 10 + j);
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
