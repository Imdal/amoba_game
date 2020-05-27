package Main;

import com.gluonhq.ignite.guice.GuiceContext;
import com.google.inject.AbstractModule;
import game.PlayerDao;
import guice.PersistenceModule;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class AmoebaApplication extends Application {

    private FXMLLoader fxmlLoader;
    public static Stage stage;

    private final GuiceContext context = new GuiceContext(this, () -> List.of(
            new AbstractModule() {
                @Override
                protected void configure() {
                    install(new PersistenceModule("Amoeba"));
                    bind(PlayerDao.class);
                }
            }
    ));

    @Override
    public void start(Stage stage) throws Exception {
        log.info("Starting application...");
//        context.init();
        AmoebaApplication.stage=stage;
        Parent root = FXMLLoader.load(AmoebaApplication.class.getResource("/fxml/startWindow.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add("/Css/Style.css");

        stage.setTitle("Amoeba");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
}
