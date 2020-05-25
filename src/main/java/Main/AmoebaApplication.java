package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class AmoebaApplication extends Application {

    private FXMLLoader fxmlLoader;
    public static Stage stage;

    @Override
    public void start(Stage stage) throws Exception {

        AmoebaApplication.stage=stage;
        Parent root = FXMLLoader.load(AmoebaApplication.class.getResource("/fxml/startWindow.fxml"));
        stage.setTitle("Amoeba");
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.show();
    }
}
