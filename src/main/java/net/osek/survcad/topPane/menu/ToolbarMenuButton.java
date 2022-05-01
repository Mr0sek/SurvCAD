package net.osek.survcad.topPane.menu;

import javafx.scene.control.Button;
import net.osek.survcad.Main;
import net.osek.survcad.topPane.menu.toolbars.Toolbar;
import net.osek.survcad.styles.Colors;

/*
@author:        Mrosek Lukas
@description:   Describes the menu buttons, with which you choose the tool category
 */
public class ToolbarMenuButton extends Button {

    private Toolbar toolbar;

    public ToolbarMenuButton(String name, Toolbar toolbar) {
        super("  " + name + "  ");

        this.toolbar = toolbar;

        this.getStyleClass().add("menu-button-inactive");
        setListener();
    }

    private void setListener() {
        this.setOnMouseClicked(e -> {
            Main.getMainClass().getToolbarMenu().onMenuButtonClicked(toolbar);
        });
    }

    public void setActive() {
        // set style to active
        this.getStyleClass().clear();
        this.getStyleClass().add("menu-button-active");
    }

    public void setInactive() {
        // set style to inactive
        this.getStyleClass().clear();
        this.getStyleClass().add("menu-button-inactive");
    }
}
