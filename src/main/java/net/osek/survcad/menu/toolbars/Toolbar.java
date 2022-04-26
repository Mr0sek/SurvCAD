package net.osek.survcad.menu.toolbars;

import net.osek.survcad.menu.ToolbarMenuButton;

/*
@author:        Lukas Mrosek
@description:   Superclass of all toolbar types
                A Toolbar is the area below the toolbarMenu, where all the functions are  shown as buttons. It is
                divided in ToolBlocks.
 */

public class Toolbar {

    private ToolbarMenuButton menuButton;    // button in the toolbarMenu

    private boolean isActive;

    public Toolbar(String name) {
        menuButton = new ToolbarMenuButton(name, this);

        isActive = false;
    }

    // changes the visibility of the toolbar
    public void setVisible(boolean isVisible) {
        if (isVisible) {
            menuButton.setActive();
        } else {
            menuButton.setInactive();
        }

        isActive = isVisible;
    }

    public boolean isActive() {
        return isActive;
    }

    public ToolbarMenuButton getMenuButton() {
        return menuButton;
    }
}
