package Controllers;

import com.google.inject.internal.asm.$Label;
import game.Game;
import game.Player;
import game.PlayerDao;
import game.Table;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.input.MouseEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import lombok.extern.slf4j.Slf4j;

import java.awt.*;
import java.io.IOException;
import java.util.List;

@Slf4j
public class GameSceneController {

    private PlayerDao playerDao;
    private FXMLLoader fxmlLoader;
    private StartSceneController startSceneController;

    @FXML
    private GridPane gamePane;
    @FXML
    private Label player1Name;
    @FXML
    private Label player2Name;

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
//    private Table table;
    public static Image X = new Image("images/aqDRd4o.png");
    public static Image O = new Image("images/OhAJg3J.png");
    public static Image empty = new Image("images/empty.png");



    @FXML
    public void setPlayersName (String name1, String name2){
        log.info(name1);
        log.info(name2);
        player1Name.setText(name1);
        player2Name.setText(name2);
        Player1 = new Player(name1);
        Player2 = new Player(name2);

//        Platform.runLater(() -> player1Name.setText(name1));
//        Platform.runLater(() -> player2Name.setText(name2));

    }
    @FXML
    public void startGame (String player1, String player2,int tableSize) {
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
    public void handleClickOnCube(MouseEvent mouseEvent) {
        int row = GridPane.getRowIndex((Node) mouseEvent.getSource());
        int col = GridPane.getColumnIndex((Node) mouseEvent.getSource());
        log.info("Clicked: "+row+", "+col);

//            log.info("Index ({}, {}) is chosen.", row, col);
            if(Table.available(row,col,Table.getPlayerNum())) {
                Table.newMove();
                Table.cout();
                log.info("New move");
                if(Table.check()==1) {
                    Player1.WinGame();
                    Player2.LoseGame();
                }
                else if (Table.check()==2) {
                    Player2.WinGame();
                    Player1.LoseGame();
                }
            }
        displayGameState();
        log.info("Display");


    }

        @FXML
    public void Player1GiveUp() {
        log.info("Player 1 gave up.");
        Player1.LoseGame();
        Player2.WinGame();
    }

    @FXML
    public void Player2GiveUp() {
        log.info("Player 2 gave up.");
        Player2.LoseGame();
        Player1.WinGame();
    }

    @FXML
    public void displayGameState() {
        for(int i=0;i<Table.getSize();i++){
            for(int j=0;j<Table.getSize();j++) {
                ImageView view = (ImageView) gamePane.getChildren().get(i *10 + j);
//                if (view.getImage() != null) {
//                    log.trace("Image({}, {}) = {}", i, j, view.getImage().getUrl());
//                }
                if(Table.currentState(i,j) == 1){
                    view.setImage(X);
                }
                else if(Table.currentState(i,j) == 2) {
                    view.setImage(O);
                }
                else if(Table.currentState(i,j) == 0) {
                    view.setImage(empty);
                }
            }
        }
    }
}