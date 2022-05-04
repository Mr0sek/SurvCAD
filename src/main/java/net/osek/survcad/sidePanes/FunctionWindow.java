package net.osek.survcad.sidePanes;

import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import net.osek.survcad.styles.Colors;

/*
@author:        Lukas Mrosek
@description:   This is the placeholder for functionwindows, it's objects are top-left-window, top-right-window, bottom-left-window, bottom-right-window
 */


public class FunctionWindow extends Pane {

    public FunctionWindow () {

    }

    public void showFunctionWindow (Pane child) {
        this.getChildren().clear();
        this.getChildren().add(child);
    }

    public void hideFunctionWindow () {
        this.getChildren().clear();
    }
}
