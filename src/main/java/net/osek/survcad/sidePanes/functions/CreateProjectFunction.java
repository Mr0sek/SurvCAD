package net.osek.survcad.sidePanes.functions;

import javafx.scene.control.Label;
import net.osek.survcad.sidePanes.FunctionButton;
import net.osek.survcad.sidePanes.FunctionManager;
import net.osek.survcad.utils.ToolIDs;

public class CreateProjectFunction extends Function {

    public CreateProjectFunction() {
        super(ToolIDs.CREATE_PROJECT, "Create project");

        // create function window
        Label title = new Label("Create project");
        Label desc_path = new Label("Please enter the path to your project");

        this.getChildren().addAll(title, desc_path);
    }
}
