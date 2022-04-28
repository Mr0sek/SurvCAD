package net.osek.survcad.menu;

import javafx.scene.control.Button;
import net.osek.survcad.Main;
import net.osek.survcad.menu.toolbars.Toolbar;
import net.osek.survcad.styles.Colors;

/*
@author:        Mrosek Lukas
@description:   Describes the menu buttons, with which you choose the tool category
 */
public class ToolbarMenuButton extends Button {

    private Toolbar toolbar;

    public ToolbarMenuButton(String name, Toolbar toolbar) {
        super(name);

        this.toolbar = toolbar;

        setStyles();
        setListener();
    }

    private void setListener() {
        this.setOnMouseClicked(e -> {
            Main.getMainClass().getToolbarMenu().onMenuButtonClicked(toolbar);
        });
    }

    private void setStyles() {
        // standard style
        this.setStyle(
                "-fx-background-color: " + Colors.MENU_BAR_BACKGROUND_INACTIVE.getColor() + ";" +
                        "-fx-text-fill: " + Colors.MENU_BAR_TEXT_COLOR_INACTIVE.getColor() + ";" +
                        "-fx-border-radius: 0px; -fx-background-radius: 0px;"
        );

        // hover style
        this.setOnMouseEntered(e -> {
            if (!toolbar.isActive())
                this.setStyle(
                        "-fx-background-color: " + Colors.MENU_BAR_BACKGROUND_HOVER.getColor() + ";" +
                                "-fx-text-fill: " + Colors.MENU_BAR_TEXT_COLOR_HOVER.getColor() + ";" +
                                "-fx-border-radius: 0px; -fx-background-radius: 0px;"
                );
        });

        // hover exit -> standard style
        this.setOnMouseExited(e -> {
            if (!toolbar.isActive())
                this.setStyle(
                        "-fx-background-color: " + Colors.MENU_BAR_BACKGROUND_INACTIVE.getColor() + ";" +
                                "-fx-text-fill: " + Colors.MENU_BAR_TEXT_COLOR_INACTIVE.getColor() + ";" +
                                "-fx-border-radius: 0px; -fx-background-radius: 0px;"
                );
        });
    }

    public void setActive() {
        // set style to active
        this.setStyle(
                "-fx-background-color: " + Colors.MENU_BAR_BACKGROUND_ACTIVE.getColor() + ";" +
                        "-fx-text-fill: " + Colors.MENU_BAR_TEXT_COLOR_ACTIVE.getColor() + ";" +
                        "-fx-border-radius: 0px; -fx-background-radius: 0px;"
        );
    }

    public void setInactive() {
        // set style to inactive
        this.setStyle(
                "-fx-background-color: " + Colors.MENU_BAR_BACKGROUND_INACTIVE.getColor() + ";" +
                        "-fx-text-fill: " + Colors.MENU_BAR_TEXT_COLOR_INACTIVE.getColor() + ";" +
                        "-fx-border-radius: 0px; -fx-background-radius: 0px;"
        );
    }
}
