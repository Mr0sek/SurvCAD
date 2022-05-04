package net.osek.survcad;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Screen;
import javafx.stage.Stage;
import net.osek.survcad.embeddedDB.Database;
import net.osek.survcad.sidePanes.Facing;
import net.osek.survcad.sidePanes.FunctionBar;
import net.osek.survcad.sidePanes.FunctionManager;
import net.osek.survcad.topPane.menu.ToolbarMenu;

import java.util.Objects;

public class Main extends Application {

    private static Main mainClass;

    private Database internDatabase;

    private ToolbarMenu toolbarMenu;
    private VBox toolbarMenuPane;
    private VBox functionBarLeftMenuPane;
    private HBox functionBarLeftPane;

    @Override
    public void start(Stage stage) throws Exception {
        mainClass = this;

        // database
        internDatabase = new Database();

        // get Screen sizes
        ObservableList<Screen> screenSizes = Screen.getScreens();
        // Todo: Save screen setups in database

        // Basic layout, with menubar, sidebars, bottom bar and center-layout
        BorderPane mainPane = new BorderPane();

        // toolbar (top)
        toolbarMenuPane = new VBox();
        toolbarMenu = new ToolbarMenu();    // adds itself to this.getChildren

        // function bars (left and right)
        functionBarLeftPane = new HBox();            // the function pane on the left, containing the function window itself and
        // initialize the functions manager
        FunctionManager.initFunctionBars(functionBarLeftPane);


        VBox rightPane = new VBox();
        HBox bottomPane = new HBox();

        DrawingPane centerPane = new DrawingPane();
        DrawingSubScene drawingScene = new DrawingSubScene(centerPane);

        mainPane.setTop(toolbarMenuPane);
        mainPane.setLeft(functionBarLeftPane);
        mainPane.setRight(rightPane);
        mainPane.setBottom(bottomPane);
        mainPane.setCenter(drawingScene);


        // show window
        Scene scene = new Scene(mainPane, screenSizes.get(0).getBounds().getWidth(), screenSizes.get(0).getBounds().getHeight());

        // styles.sass
        try {
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/net/osek/survcad/styles.css")).toExternalForm());
        } catch (NullPointerException e) {
            e.printStackTrace();
            // and ignore... for now
        }

        // camera
        OrthogonalCamera camera = new OrthogonalCamera();
        scene.setCamera(camera);

        stage.setTitle("SurvCAD");
        stage.setScene(scene);
        stage.show();

        // listener
        stage.setOnCloseRequest(event -> {
            // close database
            internDatabase.close();

            // shut down system
            Platform.exit();
            System.exit(0);
        });
    }

    public static void main(String[] args) {
        launch();
    }


    public ToolbarMenu getToolbarMenu() {
        return toolbarMenu;
    }

    public VBox getToolbarMenuPane() {
        return toolbarMenuPane;
    }

    public Database getInternDatabase() {
        return internDatabase;
    }

    public static Main getMainClass() {
        return mainClass;
    }
}
