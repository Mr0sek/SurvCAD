package net.osek.survcad;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Point3D;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import net.osek.survcad.menu.ToolbarMenu;

import java.util.Objects;

public class Main extends Application {

    private static Main mainClass;

    private ToolbarMenu toolbarMenu;
    private VBox toolbarMenuPane;

    @Override
    public void start(Stage stage) throws Exception {
        mainClass = this;

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

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();


        // DXF Test
    }

    public static void main(String[] args) {
        launch();
    }

    private static void testPoints() {
        Point3D p1 = new Point3D(0,0,0);
        Point3D p2 = new Point3D(1,1,1);
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
