package net.osek.survcad.menu.toolbars;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import net.osek.survcad.Main;
import net.osek.survcad.menu.ToolbarMenuButton;
import net.osek.survcad.styles.Colors;

/*
@author:        Lukas Mrosek
@description:   Superclass of all toolbar types
                A Toolbar is the area below the toolbarMenu, where all the functions are  shown as buttons. It is
                divided in ToolBlocks.
 */

public class Toolbar extends HBox {

    private ToolbarMenuButton menuButton;    // button in the toolbarMenu

    private boolean isActive;

    public Toolbar(String name) {
        menuButton = new ToolbarMenuButton(name, this);

        isActive = false;

        setStyles();
    }

    private void setStyles() {
        this.setStyle(
                "-fx-background-color: " + Colors.TOOLBAR_BACKGROUND_COLOR.getColor() + ";" +
                        "-fx-border-color: " + Colors.BORDER_COLOR.getColor() + ";" +
                        "-fx-border-width: 1px; -fx-border-style: solid none;" +
                        "-fx-border-radius: 0px; -fx-background-radius: 0px;" +
                        "-fx-pref-height: 150px"
        );
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
}
