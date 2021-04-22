package userinterface;

/**
 * Graphical user interface for Spell Checker
 *
 * @author sallasal
 */
import domain.*;
import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.stage.*;

public class SpellCheckerGUI extends Application {

    private Stage window;
    private CheckerService checkerService;

    @Override
    public void init() throws Exception {
        this.checkerService = new CheckerService();
    }

    @Override
    public void start(Stage window) {
        VBox setting = new VBox();
        window.setTitle("Spell Checker");
        window.setWidth(800.00);
        window.setHeight(800.00);
        setting.setPadding(new Insets(20, 20, 20, 20));

        CheckScene checkScene = new CheckScene();
        Scene checker = checkScene.getCheckScene(window, checkerService);

        window.setScene(checker);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
