package net.osek.survcad.menu;

import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import net.osek.survcad.Main;
import net.osek.survcad.menu.toolbars.DrawToolbar;
import net.osek.survcad.menu.toolbars.StartToolbar;
import net.osek.survcad.menu.toolbars.Toolbar;
import net.osek.survcad.styles.Colors;

import java.util.ArrayList;
import java.util.function.Consumer;

/*
@author:        Lukas Mrosek
@description:   ToolbarMenu is the menu, where you chose, which category of tools you want to be shown in the toolbar.
 */

public class ToolbarMenu extends HBox {

    private ArrayList<Toolbar> toolbars;

    public ToolbarMenu() {
        super();

        // initialization of all toolbar categories
        StartToolbar start = new StartToolbar();
        DrawToolbar draw = new DrawToolbar();

        toolbars = new ArrayList<>();
        toolbars.add(start);
        toolbars.add(draw);

        setStyle();

        // menuButtons are the buttons to choose a toolbar category
        // add them to this list
        ArrayList<ToolbarMenuButton> menuButtons = new ArrayList<>();
        Consumer<Toolbar> getMenuItems = new Consumer<Toolbar>() {
            @Override
            public void accept(Toolbar toolbar) {
                menuButtons.add(toolbar.getMenuButton());
            }
        };
        toolbars.forEach(getMenuItems);

        // add all menu buttons to the horizontal box
        this.getChildren().addAll(menuButtons);

        // add this HBox itself to the topPane of the programm
        Main.getMainClass().getToolbarMenuPane().getChildren().add(this);

        // make all toolbars invisible, but the StartToolbar
        toolbars.forEach(toolbar -> {toolbar.setActive(false);});
        start.setActive(true);
    }

    public void onMenuButtonClicked(Toolbar toolbar) {
        // set toolbar as active
        toolbars.forEach(tb -> {tb.setActive(false);});
        toolbar.setActive(true);
    }

    private void setStyle () {
        this.setStyle("" +
                "-fx-background-color: " + Colors.MENU_BAR_BACKGROUND_INACTIVE.getColor() + ";" +
                "-fx-border-color: " + Colors.BORDER_COLOR.getColor() + ";" +
                "-fx-border-width: 1px; -fx-border-style: hidden hidden solid hidden;"
        );
    }
}
