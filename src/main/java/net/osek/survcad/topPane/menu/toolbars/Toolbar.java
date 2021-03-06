package net.osek.survcad.topPane.menu.toolbars;

import javafx.scene.layout.HBox;
import net.osek.survcad.Main;
import net.osek.survcad.topPane.menu.ToolbarMenuButton;
import net.osek.survcad.styles.Colors;

/*
@author:        Lukas Mrosek
@description:   Superclass of all toolbar types
                A Toolbar is the area below the toolbarMenu, where all the functions are  shown as buttons. It is
                divided in ToolBlocks.
 */

public class Toolbar extends HBox {

    private static final int TOOL_CELL_SIZE = 18;    // size of a SMALL tool in px
    public static final int TOOL_GAP = 10;           // HGap and VGap between toolbuttons in px

    private ToolbarMenuButton menuButton;    // button in the toolbarMenu

    private boolean isActive;

    public Toolbar(String name) {
        menuButton = new ToolbarMenuButton(name, this);

        isActive = false;

        this.getStyleClass().add("tool-bar");
    }

    // changes the visibility of the toolbar
    public void setActive(boolean isActive) {
        if (isActive) {
            menuButton.setActive();

            // add this to Toolbar HBox, so this is shown
            Main.getMainClass().getToolbarMenuPane().getChildren().add(this);
        } else {
            menuButton.setInactive();

            // remove this from Toolbar HBox, so it isn't visible anymore
            Main.getMainClass().getToolbarMenuPane().getChildren().remove(this);
        }

        this.isActive = isActive;
    }

    public boolean isActive() {
        return isActive;
    }

    public ToolbarMenuButton getMenuButton() {
        return menuButton;
    }

    public static int getToolCellSize() {
        return TOOL_CELL_SIZE;
    }
}
