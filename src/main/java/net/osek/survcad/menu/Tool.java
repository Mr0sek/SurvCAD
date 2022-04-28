package net.osek.survcad.menu;

import javafx.scene.control.Button;
import net.osek.survcad.menu.toolbars.Toolbar;

enum ToolSize {
    SMALL,
    MEDIUM,
    LARGE
};

public class Tool extends Button {

    private ToolBlock parent;
    private long internToolID;  // unified ID of button

    private ToolSize size;

    public Tool (ToolBlock parent, ToolSize size, long ID) {
        super("test");

        this.parent = parent;
        this.size = size;
        this.internToolID = ID;

        this.setStyle("" +
                "-fx-pref-height: " + Toolbar.TOOL_CELL_SIZE * (size.ordinal()+1) + ";" +
                "-fx-pref-width: " + Toolbar.TOOL_CELL_SIZE * (size.ordinal()+1)
        );

        // load image from database

    }
}
