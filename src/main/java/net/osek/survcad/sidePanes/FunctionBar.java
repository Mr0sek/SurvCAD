package net.osek.survcad.sidePanes;

import javafx.scene.Group;
import javafx.scene.layout.HBox;

import java.util.ArrayList;

public class FunctionBar extends Group {

    private Facing facing;

    private final ArrayList<FunctionButton> functionButtons;

    private final HBox functionBar;

    public FunctionBar (Facing facing) {
        super();

        this.facing = facing;

        functionButtons = new ArrayList<>();

        functionBar = new HBox();


        functionBar.setRotate(facing == Facing.TOP_LEFT || facing == Facing.BOTTOM_LEFT
                ? 270 : 90);

        this.getChildren().add(functionBar);

        functionBar.getStyleClass().add("function-bar");
    }

    public void addButton(FunctionButton functionButton) {
        // add button
        functionButtons.add(functionButton);
        functionBar.getChildren().add(functionButton);

        // listener for this button
        functionButton.setOnMouseClicked(e -> {
            functionButtons.forEach(fb -> {
                if(!fb.equals(functionButton))
                    // set all other buttons to inactive
                    fb.setActive(false);
            });

            // set this to active, if it wasn't, and the other way around
            functionButton.setActive(!functionButton.getIsActive());
        });
    }

    public void removeButton(FunctionButton functionButton) {
        if(functionButtons.contains(functionButton)) {
            functionBar.getChildren().remove(functionButton);
            functionButtons.remove(functionButton);
        }
    }
}
