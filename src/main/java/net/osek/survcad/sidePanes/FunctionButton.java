package net.osek.survcad.sidePanes;

import javafx.scene.control.Button;
import net.osek.survcad.sidePanes.functions.Function;
import net.osek.survcad.utils.ToolIDs;

public class FunctionButton extends Button {

    private ToolIDs id;

    private Function parent;

    private boolean isActive = false;

    public FunctionButton (ToolIDs id, String text, Function parent) {
        super(text);

        this.id = id;
        this.parent = parent;

        this.getStyleClass().add("function-button-inactive");
    }

    public void setActive(boolean isActive) {
        this.getStyleClass().clear();
        this.getStyleClass().add(isActive ? "function-button-active" : "function-button-inactive");

        this.isActive = isActive;

        // open/close it's function window
        if(isActive) {
            parent.show();
        } else {
            parent.hide();
        }
    }

    public boolean getIsActive () {
        return isActive;
    }
}
