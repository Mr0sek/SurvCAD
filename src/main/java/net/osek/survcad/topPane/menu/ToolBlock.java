package net.osek.survcad.topPane.menu;

import javafx.scene.layout.GridPane;
import net.osek.survcad.topPane.menu.toolbars.Toolbar;
import net.osek.survcad.styles.Colors;

import java.util.ArrayList;

public class ToolBlock extends GridPane {

    private String name;

    public ToolBlock(String name) {
        super();

        // in-code style has to remain here, because of needed variables for h- and v-gab
        // todo: get this into styles.css
        setStyle();
    }

    // cellOccupancy: [height][lenght]
    public void fillWithTools (int[][] cellOccupancy)  {
        // go through matrix, to find out, where what button is placed and what size it has
        int nHeight = 0; int nLength = 0;

        ArrayList<Integer> placedList = new ArrayList<>();  // contains nHeight*cellOccupancy[0].length+nLength of all filled cells

        fillWithTools(nHeight, nLength, cellOccupancy, placedList);
    }

    private void fillWithTools(int nHeight, int nLength, int[][] cellOccupancy, ArrayList<Integer> placedList) {
        // check, if height or length is out of limit
        if(nHeight >= cellOccupancy.length) {
            fillWithTools(0, nLength+1, cellOccupancy, placedList);
            return;
        }
        if(nLength >= cellOccupancy[0].length) {
            return;
        }
        // check, if cell is already occupant
        if(placedList.contains(nHeight*cellOccupancy[0].length+nLength)) {
            fillWithTools(nHeight+1, nLength, cellOccupancy, placedList);
            return;
        }

        ToolSize toolSize;
        // find out size of button
        try {
            if (cellOccupancy[0].length > nLength - 1 && cellOccupancy[nHeight][nLength + 1] == cellOccupancy[nHeight][nLength]) {

                // button size is minimum medium
                if (cellOccupancy[nHeight][nLength + 2] == cellOccupancy[nHeight][nLength]) {

                    // button size is large
                    toolSize = ToolSize.LARGE;

                    // this is to make sure, no tool gets overriden
                    for (int i = nLength; i <= nLength + 2; i++) {
                        for (int j = nHeight; j <= nHeight + 2; j++) {
                            placedList.add(j * cellOccupancy[0].length + i);
                        }
                    }

                    fillWithTools(0, nLength + 3, cellOccupancy, placedList);
                } else {

                    // button size is medium
                    toolSize = ToolSize.MEDIUM;

                    // this is to make sure, no tool gets overriden
                    for (int i = nLength; i <= nLength + 1; i++) {
                        for (int j = nHeight; j <= nHeight + 1; j++) {
                            placedList.add(j * cellOccupancy[0].length + i);
                        }
                    }

                    fillWithTools(nHeight + 2, nLength, cellOccupancy, placedList);
                }
            } else {

                // button size is small
                toolSize = ToolSize.SMALL;

                // this is to make sure, no tool gets overriden
                for (int i = nLength; i <= nLength; i++) {
                    for (int j = nHeight; j <= nHeight; j++) {
                        placedList.add(j * cellOccupancy[0].length + i);
                    }
                }

                fillWithTools(nHeight + 1, nLength, cellOccupancy, placedList);
            }
        } catch (IndexOutOfBoundsException e) {
            // button size is small as well
            toolSize = ToolSize.SMALL;

            // this is to make sure, no tool gets overriden
            for (int i = nLength; i <= nLength; i++) {
                for (int j = nHeight; j <= nHeight; j++) {
                    placedList.add(j * cellOccupancy[0].length + i);
                }
            }

            fillWithTools(nHeight + 1, nLength, cellOccupancy, placedList);
        }

        this.add(new ToolButton(this, toolSize, cellOccupancy[nHeight][nLength]), nLength, nHeight, toolSize.ordinal()+1, toolSize.ordinal()+1);
    }

    private void setStyle() {
        this.setStyle("" +
                "-fx-hgap: " + Toolbar.TOOL_GAP + "px; -fx-vgap: " + Toolbar.TOOL_GAP +"px;" +
                "-fx-padding: " + (Toolbar.TOOL_GAP /2) + "px;" +
                "-fx-border-width: 1px; -fx-border-color: " + Colors.BORDER_COLOR.getColor() + ";" +
                "-fx-border-style: hidden solid hidden solid; -fx-border-insets: 5px;"
        );
    }
}
