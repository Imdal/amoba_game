package Controllers;

import Main.AmoebaApplication;
import game.Table;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;
import javafx.scene.control.Button;


import java.io.IOException;

@Slf4j
public class FinalSceneController {
    @FXML
    private Button newGameButton;
    @FXML
    private Button exitButton;
    @FXML
    private FXMLLoader fxmlLoader;

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
        Table.table=Table.initTable;

    }

    public void exit() {
        Platform.exit();
        System.exit(0);
    }

}
