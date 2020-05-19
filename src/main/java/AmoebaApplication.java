import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class AmoebaApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(AmoebaApplication.class.getResource("/startWindow.fxml"));
        stage.setTitle("Amoeba");
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.show();
    }
}
