package net.osek.survcad;

import javafx.scene.Parent;
import javafx.scene.SceneAntialiasing;
import javafx.scene.SubScene;

/*
@author:        Mrosek Lukas
@description:   DrawingSubScene is a child of superclass SubScene.
                It manages all parameters of sub scene, such as window size and visibility
                and is used to show all the 3d objects.
                Parent is of type DrawingPane and contains all the 3d objects.
 */

public class DrawingSubScene extends SubScene {

    DrawingPane parent;

    public DrawingSubScene(DrawingPane parent) {
        // ,,,true, SceneAntialiasing.BALANCE -> makes sure, all objrects are shown in correct Z oder
        super(parent, 1200, 1200, true, SceneAntialiasing.BALANCED);

        this.parent = parent;
    }
}
