package Controllers;

import com.google.inject.internal.asm.$Label;
import game.Game;
import game.Player;
import game.PlayerDao;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.List;


public class GameSceneController {

    private FXMLLoader fxmlLoader;
    private String player1name;
    private String player2name;

    @FXML
    private GridPane gamePane;
    private Label x= new Label("X");
    private Label o= new Label("O");
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

    @FXML
    private Pane GamePane;

    private Game game;

    private Player player1;
    private Player player2;


    public void setPlayersName (String name1, String name2){
        Platform.runLater(() -> player1Name.setText(name1));
        Platform.runLater(() -> player2Name.setText(name2));

    }

    public void startGame (String player1, String player2,int tableSize){
        System.out.println("kurva anyád");
        setPlayersName(player1,player2);
        for (int i=0;i<tableSize;i++) {
            gamePane.addColumn(0);
            gamePane.addRow(0);
            gamePane.add(x,i,i);
        }

    }

}
