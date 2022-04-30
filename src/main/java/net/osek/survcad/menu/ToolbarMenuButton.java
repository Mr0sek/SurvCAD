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
        super("  " + name + "  ");

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
                        "-fx-start-margin: 0px; -fx-padding: 3px; -fx-border-radius: 0px; -fx-font-size: 12px;" +
                        " -fx-background-radius: 0px; -fx-border-width: 0px 0px 3px 0px; -fx-border-style: hidden;" +
                        "-fx-min-width: 80px;"
        );

        // hover style
        this.setOnMouseEntered(e -> {
            if (!toolbar.isActive())
                this.setStyle(
                        "-fx-background-color: " + Colors.MENU_BAR_BACKGROUND_HOVER.getColor() + ";" +
                                "-fx-text-fill: " + Colors.MENU_BAR_TEXT_COLOR_HOVER.getColor() + ";" +
                                "-fx-start-margin: 0px; -fx-border-radius: 0px; -fx-background-radius: 0px;" +
                                "-fx-padding: 3px; -fx-border-width: 0px 0px 3px 0px; -fx-border-style: hidden;" +
                                "-fx-font-size: 12px; -fx-min-width: 80px;"
                );
        });

        // hover exit -> standard style
        this.setOnMouseExited(e -> {
            if (!toolbar.isActive())
                this.setStyle(
                        "-fx-background-color: " + Colors.MENU_BAR_BACKGROUND_INACTIVE.getColor() + ";" +
                                "-fx-text-fill: " + Colors.MENU_BAR_TEXT_COLOR_INACTIVE.getColor() + ";" +
                                "-fx-start-margin: 0px; -fx-border-radius: 0px; -fx-background-radius: 0px;" +
                                "-fx-padding: 3px; -fx-border-width: 0px 0px 3px 0px; -fx-border-style: hidden;" +
                                "-fx-font-size: 12px; -fx-min-width: 80px;"
                );
        });
    }

    public void setActive() {
        // set style to active
        this.setStyle(
                "-fx-background-color: " + Colors.MENU_BAR_BACKGROUND_ACTIVE.getColor() + ";" +
                        "-fx-text-fill: " + Colors.MENU_BAR_TEXT_COLOR_ACTIVE.getColor() + ";" +
                        "-fx-font-size: 12px;" +
                        "-fx-border-width: 0px 0px 3px 0px; -fx-border-style: hidden hidden solid hidden; " +
                        "-fx-border-color: " + Colors.MENU_BAR_BORDER_ACTIVE.getColor() + ";" +
                        "-fx-background-radius: 0px; -fx-border-radius: 0px; " +
                        "-fx-start-margin: 0px; -fx-padding: 3px; -fx-min-width: 80px;"
        );
    }

    public void setInactive() {
        // set style to inactive
        this.setStyle(
                "-fx-background-color: " + Colors.MENU_BAR_BACKGROUND_INACTIVE.getColor() + ";" +
                        "-fx-text-fill: " + Colors.MENU_BAR_TEXT_COLOR_INACTIVE.getColor() + ";" +
                        "-fx-start-margin: 0px; -fx-border-radius: 0px; -fx-background-radius: 0px;" +
                        "-fx-padding: 3px; -fx-border-width: 0px 0px 3px 0px; -fx-border-style: hidden;" +
                        "-fx-font-size: 12px; -fx-min-width: 80px;"
        );
    }
}
