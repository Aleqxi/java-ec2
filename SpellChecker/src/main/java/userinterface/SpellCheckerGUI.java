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

/**
 * Graphical user interface basis for Spell Checker
 * @author sallasal
 */
public class SpellCheckerGUI extends Application {

    private Stage window;
    private CheckerService checkerService;

    /**
     * Initializes the application and checker service
     * @throws Exception
     */
    @Override
    public void init() throws Exception {
        this.checkerService = new CheckerService();
    }

    /**
     * Creates the window and calls the correct scene
     * @param window the argument parameter that is created in domain.Main
     */
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

    /**
     * Main for the graphical user interface and application
     * @param args passed from domain.Main
     */
    public static void main(String[] args) {
        launch(args);
    }
}
