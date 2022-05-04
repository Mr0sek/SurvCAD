package net.osek.survcad.sidePanes;

import javafx.scene.layout.*;
import net.osek.survcad.sidePanes.functions.FileSystemFunction;
import net.osek.survcad.sidePanes.functions.ProjectFunction;
import net.osek.survcad.utils.ToolIDs;

public abstract class FunctionManager {

    private static FunctionBar topLeftFunctionBar, bottomLeftFunctionBar;

    private static FunctionWindow topLeftFunctionWindow, bottomLeftFunctionWindow;


    public static void initFunctionBars(Pane leftPane) {

        VBox leftFunctionMenu = new VBox();
        Region leftFunctionBarFiller = new Region();                                    // the space between top and bottom function bar
        VBox.setVgrow(leftFunctionBarFiller, Priority.ALWAYS);  // to make it grow, when window size changes    todo: disappears, when you decrease the window size to a certain point
        topLeftFunctionBar = new FunctionBar(Facing.TOP_LEFT);
        bottomLeftFunctionBar = new FunctionBar(Facing.TOP_RIGHT);
        leftFunctionMenu.getChildren().addAll(topLeftFunctionBar, leftFunctionBarFiller, bottomLeftFunctionBar);

        VBox leftFunctionWindow = new VBox();
        topLeftFunctionWindow = new FunctionWindow();
        bottomLeftFunctionWindow = new FunctionWindow();
        leftFunctionWindow.getChildren().addAll(topLeftFunctionWindow, bottomLeftFunctionWindow);

        leftPane.getChildren().addAll(leftFunctionMenu, leftFunctionWindow);
    }

    public static FunctionBar getTopLeftFunctionBar() {
        return topLeftFunctionBar;
    }

    public static FunctionBar getBottomLeftFunctionBar() {
        return bottomLeftFunctionBar;
    }

    public static FunctionWindow getTopLeftFunctionWindow() {
        return topLeftFunctionWindow;
    }

    public static FunctionWindow getBottomLeftFunctionWindow() {
        return bottomLeftFunctionWindow;
    }
}
