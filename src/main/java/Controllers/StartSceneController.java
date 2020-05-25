package Controllers;

import Main.AmoebaApplication;
import game.Game;
import game.Player;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.event.ActionEvent;


import java.io.IOException;

public class StartSceneController {
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

        Parent root = (Parent) fxmlLoader.load(getClass().getResource("/fxml/gameWindow.fxml"));
        AmoebaApplication.stage.getScene().setRoot(root);
        fxmlLoader.<GameSceneController>getController().startGame(Player1NameText.getText(), Player2NameText.getText(),(int) TableSizeSlider.getValue());
    }
    }
}
