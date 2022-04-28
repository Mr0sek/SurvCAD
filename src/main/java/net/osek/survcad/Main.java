package net.osek.survcad;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Point3D;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import net.osek.survcad.embeddedDB.Database;
import net.osek.survcad.menu.ToolbarMenu;

import java.util.Objects;

public class Main extends Application {

    private static Main mainClass;

    private Database interDatabase;

    private ToolbarMenu toolbarMenu;
    private VBox toolbarMenuPane;

    @Override
    public void start(Stage stage) throws Exception {
        mainClass = this;

        // database
        interDatabase = new Database();

        // get Screen sizes
        ObservableList<Screen> screenSizes = Screen.getScreens();
        // Todo: Save screensetups in database

        // Basic layout, with menubar, sidebars, bottombar and center-layout
        BorderPane mainPane = new BorderPane();

        toolbarMenuPane = new VBox();
        toolbarMenu = new ToolbarMenu();

        VBox menuPane = new VBox();
        menuPane.getChildren().addAll(toolbarMenuPane);
        VBox leftPane = new VBox();
        VBox rightPane = new VBox();
        HBox bottomPane = new HBox();

        DrawingPane centerPane = new DrawingPane();
        DrawingSubScene drawingScene = new DrawingSubScene(centerPane);

        mainPane.setTop(menuPane);
        mainPane.setLeft(leftPane);
        mainPane.setRight(rightPane);
        mainPane.setBottom(bottomPane);
        mainPane.setCenter(drawingScene);


        // show window
        Scene scene = new Scene(mainPane, screenSizes.get(0).getBounds().getWidth(), screenSizes.get(0).getBounds().getHeight());

        OrthogonalCamera camera = new OrthogonalCamera();
        scene.setCamera(camera);

        stage.setTitle("SurvCAD");
        stage.setScene(scene);
        stage.show();

        // listener
        stage.setOnCloseRequest(event -> {
            // close database
            interDatabase.close();

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

    public static Main getMainClass() {
        return mainClass;
    }
}
