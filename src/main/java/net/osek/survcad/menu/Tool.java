package net.osek.survcad.menu;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import net.osek.survcad.Main;
import net.osek.survcad.embeddedDB.NoEntryException;
import net.osek.survcad.menu.toolbars.Toolbar;
import net.osek.survcad.styles.Colors;
import net.osek.survcad.utils.StringUtil;

import java.io.IOException;
import java.sql.SQLException;

enum ToolSize {
    SMALL,
    MEDIUM,
    LARGE
};

public class Tool extends Button {

    private ToolBlock parent;
    private int internToolID;  // unified ID of button

    private String imgPath;
    private ToolSize size;

    public Tool (ToolBlock parent, ToolSize size, int ID) {
        super();

        this.parent = parent;
        this.size = size;
        this.internToolID = ID;

        loadImage();
        setStyle();
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
                    "-fx-background-size: cover; -fx-background-position: center; -fx-background-repeat: no-repeat;"
            );
        }
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
}
