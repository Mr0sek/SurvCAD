package net.osek.survcad.sidePanes;

import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.paint.Paint;
import net.osek.survcad.Main;
import net.osek.survcad.styles.Colors;

public class FunctionButton extends Button {

    private FunctionBar functionBar;
    private int id;

    public FunctionButton (int id, String text, FunctionBar functionBar) {
        super(text);

        this.id = id;
        this.functionBar = functionBar;

        setListener();

        this.getStyleClass().add("function-button-inactive");
    }

    public void setActive(boolean isActive) {
        this.getStyleClass().clear();
        this.getStyleClass().add(isActive ? "function-button-active" : "function-button-inactive");
    }

    private void setListener () {
        this.setOnMouseClicked(e -> {
            functionBar.functionButtonClicked(this);
        });
    }
}
