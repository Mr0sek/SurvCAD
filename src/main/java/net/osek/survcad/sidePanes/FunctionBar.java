package net.osek.survcad.sidePanes;

import javafx.scene.Group;
import javafx.scene.layout.HBox;

import java.util.ArrayList;

public class FunctionBar extends Group {

    private Facing facing;

    private HBox functionBar;

    private ArrayList<FunctionButton> functionButtons;

    public FunctionBar (Facing facing) {
        super();

        this.facing = facing;

        functionBar = new HBox();

        functionButtons = new ArrayList<>();

        functionButtons.add(new FunctionButton(2001, "test1", this));
        functionButtons.add(new FunctionButton(2002, "Test2",  this));

        functionBar.getChildren().addAll(functionButtons);
        functionBar.setRotate(facing == Facing.LEFT ? 270 : 90);

        this.getChildren().add(functionBar);

        functionBar.getStyleClass().add("function-bar");
    }

    public void functionButtonClicked (FunctionButton functionButton) {
        functionButtons.forEach(fb -> {fb.setActive(false);});
        functionButton.setActive(true);
    }
}
