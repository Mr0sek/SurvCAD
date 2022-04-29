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
                {1,1,1,7,7,10,14,16,17},
                {1,1,1,7,7,8,18,18,19},
                {1,1,1,9,12,13,18,18,20}};

        ToolBlock createToolBlock = new ToolBlock("Create");
        createToolBlock.fillWithTools(cellOccupancy);

        this.getChildren().add(createToolBlock);
    }
}
