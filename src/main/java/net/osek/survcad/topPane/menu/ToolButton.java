package net.osek.survcad.topPane.menu;

import javafx.scene.control.Button;
import net.osek.survcad.Main;
import net.osek.survcad.embeddedDB.NoEntryException;
import net.osek.survcad.sidePanes.functions.CreateProjectFunction;
import net.osek.survcad.sidePanes.functions.Function;
import net.osek.survcad.topPane.menu.toolbars.Toolbar;
import net.osek.survcad.styles.Colors;
import net.osek.survcad.utils.StringUtil;

import java.io.IOException;
import java.sql.SQLException;

enum ToolSize {
    SMALL,
    MEDIUM,
    LARGE
}

public class ToolButton extends Button {

    private ToolBlock parent;
    private int internToolID;  // unified ID of button

    private String imgPath;
    private ToolSize size;

    public ToolButton(ToolBlock parent, ToolSize size, int id) {
        super();

        this.parent = parent;
        this.size = size;
        this.internToolID = id;

        loadImage();
        // styles has to stay in-code, because of needed variables
        // todo: move this to styles.css
        setStyle();
        setListener();
    }

    private void setStyle () {
        int pxSize = Toolbar.getToolCellSize() * (size.ordinal() + 1);
        if(imgPath == null) {
            this.setStyle("" +
                    "-fx-max-height: " + pxSize + "px; -fx-min-height: " + pxSize + "px;" +
                    "-fx-max-width: " + pxSize + "px; -fx-min-width: " + pxSize + "px;" +
                    "-fx-background-color: " + Colors.TOOLBAR_BACKGROUND_COLOR.getColor()
            );
        } else {
            String bgImgString = "url(\"" + imgPath +"\")";
            this.setStyle("" +
                    "-fx-max-height: " + pxSize + "px; -fx-min-height: " + pxSize + "px;" +
                    "-fx-max-width: " + pxSize + "px; -fx-min-width: " + pxSize + "px;" +
                    "-fx-background-color: " + Colors.TOOLBAR_BACKGROUND_COLOR.getColor() + ";" +
                    "-fx-background-image: " + bgImgString + ";" +
                    "-fx-background-size: contain; -fx-background-position: center; -fx-background-repeat: no-repeat;"
            );
        }
    }

    private void setListener () {
        this.setOnMouseClicked(e -> {
            // execute button function
            startButtonFunction(internToolID);
        });
    }

    private void loadImage() {
        // load image from database
        try {

            imgPath = StringUtil.fixUrlForCss(
                    System.getProperty("user.dir") + "/" + Main.getMainClass().getInternDatabase().getButtonImagePath(internToolID)
            );
        } catch (SQLException | IOException e) {
            e.printStackTrace();

            // todo: show text instead of image
        } catch (NoEntryException e2) {
            System.out.println(e2.getMessage());
        }
    }

    // create a new window for this function
    private static void startButtonFunction (int id) {
        switch (id) {
            case 1001:  new CreateProjectFunction(); break;
        }
    }
}
