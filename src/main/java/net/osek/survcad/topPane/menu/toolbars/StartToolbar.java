package net.osek.survcad.topPane.menu.toolbars;

/*
@author:        Lukas Mrosek
@description:   Toolbar for all file related tools, such as creating new files/projects, import, export, etc...
 */

import net.osek.survcad.topPane.menu.ToolBlock;

public class StartToolbar extends Toolbar {

    public StartToolbar() {
        super("Start");

        createToolblocks();
    }

    private void createToolblocks() {

        // files block
        int[][] cellOccupancy = new int[][] {
                {1001}};

        ToolBlock createToolBlock = new ToolBlock("Files");
        createToolBlock.fillWithTools(cellOccupancy);

        this.getChildren().add(createToolBlock);
    }
}
