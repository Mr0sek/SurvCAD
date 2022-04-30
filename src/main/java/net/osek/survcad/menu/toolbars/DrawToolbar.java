package net.osek.survcad.menu.toolbars;

/*
@author:        Lukas Mrosek
@description:   Toolbar for all drawing tools such as creation of points, polylines, ...
 */

import net.osek.survcad.menu.ToolBlock;

public class DrawToolbar extends Toolbar {

    public DrawToolbar() {
        super("Draw");

        createToolblocks();
    }

    private void createToolblocks() {
        int[][] cellOccupancy = new int[][] {
                {1,2}};

        ToolBlock createToolBlock = new ToolBlock("Create");
        createToolBlock.fillWithTools(cellOccupancy);

        this.getChildren().add(createToolBlock);
    }
}
