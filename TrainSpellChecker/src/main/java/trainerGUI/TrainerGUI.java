package trainerGUI;

/**
 *
 * @author sallasal
 */
import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import trainerDomain.*;

public class TrainerGUI extends Application {

    private Stage window;
    private TrainerService trainer;

    @Override
    public void init() throws Exception {
        this.trainer = new TrainerService();
    }

    @Override
    public void start(Stage window) {
        VBox setting = new VBox();
        window.setTitle("Teach Spell Checker!");
        window.setWidth(800.00);
        window.setHeight(800.00);
        setting.setPadding(new Insets(20, 20, 20, 20));


        InsertScene insertScene = new InsertScene();
        Scene insert = insertScene.getInsertScene(window, trainer);

        window.setScene(insert);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
