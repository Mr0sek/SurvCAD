package net.osek.survcad.sidePanes.functions;

import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import net.osek.survcad.Main;
import net.osek.survcad.embeddedDB.NoEntryException;
import net.osek.survcad.sidePanes.FunctionBar;
import net.osek.survcad.sidePanes.FunctionButton;
import net.osek.survcad.sidePanes.FunctionManager;
import net.osek.survcad.styles.Colors;
import net.osek.survcad.utils.ToolIDs;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Function extends Pane {

    private static ArrayList<ToolIDs> activeFunctions = new ArrayList<>();

    private ToolIDs id;

    private FunctionButton functionButton;

    // ui inside function window
    Button xCloseBtn;
    HBox functionsMenu;

    public Function (ToolIDs id, String name) {

       if(activeFunctions.contains(id)) {
           return;  // this object should be automatically deleted by the java garbage collector
       }

       this.id = id;
       activeFunctions.add(id);


        // todo: get from database, to which function bar this belongs
        FunctionBar functionBar = FunctionManager.getTopLeftFunctionBar();

        // create new button
        functionButton = new FunctionButton(id, name, this);
        functionBar.addButton(functionButton);

        // layout of this function's pane
        VBox mainVbox = new VBox(); // vertical box (2 entries), on top is the function's menu, bottom is the function itself
        functionsMenu = new HBox();
        // load close button's image
        xCloseBtn = new Button();

        functionsMenu.getChildren().add(xCloseBtn);
        mainVbox.getChildren().add(functionsMenu);
        this.getChildren().add(mainVbox);

        setStyle();
    }

    private void setStyle() {

        // style of the close button
        try {
            String imgString = "url(\"" + Main.getMainClass().getInternDatabase().getButtonImagePath(ToolIDs.X_CLOSE.getID())  +"\")";
            xCloseBtn.setStyle("" +
                    "-fx-min-height: 10px; -fx-min-width: 10px; -fx-max-height: 10px; -fx-max-width: 10px;" +
                    "-fx-background-insets: -3px;" +
                    "-fx-background-image: " + imgString + "; " +
                    "-fx-background-size: contain; -fx-background-position: center; -fx-background-repeat: no-repeat; " +
                    "-fx-background-radius: 3px;");
        } catch (SQLException | NoEntryException | IOException e) {
            throw new RuntimeException(e);
        }
        // style of close button when hover
        xCloseBtn.setOnMouseClicked(event -> {
            try {
                String imgString = "url(\"" + Main.getMainClass().getInternDatabase().getButtonImagePath(ToolIDs.X_CLOSE.getID())  +"\")";
                xCloseBtn.setStyle("" +
                        "-fx-min-height: 10px; -fx-min-width: 10px; -fx-max-height: 10px; -fx-max-width: 10px;" +
                        "-fx-background-insets: -3px;" +
                        "-fx-background-image: " + imgString + "; " +
                        "-fx-background-color: " + Colors.BG_GREY_HOVER.getColor() + ";" +
                        "-fx-background-size: contain; -fx-background-position: center; -fx-background-repeat: no-repeat; " +
                        "-fx-background-radius: 3px;");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (NoEntryException e) {
                throw new RuntimeException(e);
            }
        });

        // style of top menu
        functionsMenu.setStyle("" +
                "-fx-padding: 5px; -fx-orientation: right; -fx-background-color: " + Colors.BG_GREY_LIGHT.getColor());

    }

    public void show() {
        FunctionManager.getTopLeftFunctionWindow().showFunctionWindow(this);
    }

    public void hide() {
        FunctionManager.getTopLeftFunctionWindow().hideFunctionWindow();
    }
}
