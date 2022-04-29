package net.osek.survcad;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import net.osek.survcad.embeddedDB.Database;
import net.osek.survcad.menu.ToolbarMenu;

public class Main extends Application {

    private static Main mainClass;

    private Database internDatabase;

    private ToolbarMenu toolbarMenu;
    private VBox toolbarMenuPane;

    @Override
    public void start(Stage stage) throws Exception {
        mainClass = this;

        // database
        internDatabase = new Database();

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
