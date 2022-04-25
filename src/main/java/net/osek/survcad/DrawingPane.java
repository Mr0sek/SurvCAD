package net.osek.survcad;

import javafx.scene.DepthTest;
import javafx.scene.Group;
import javafx.scene.effect.BlendMode;
import javafx.scene.layout.Pane;
import javafx.scene.shape.CullFace;
import javafx.scene.shape.Sphere;

public class DrawingPane extends Group {

    public DrawingPane() {
        super();

        // load contents
        Sphere s1 = new Sphere(100);
        s1.translateXProperty().set(500);       // x, y and z coordinates
        s1.translateYProperty().set(500);
        s1.translateZProperty().set(0);
        s1.setCullFace(CullFace.BACK);          // to not render the back
        //s1.setViewOrder(s1.getTranslateZ());    // this makes sure to  plot the objects in the correct order

        Sphere s2 = new Sphere(100);
        s2.translateXProperty().set(600);
        s2.translateYProperty().set(500);
        s2.translateZProperty().set(500);
        s2.setCullFace(CullFace.BACK);
        //s2.setViewOrder(s2.getTranslateZ());
        this.getChildren().addAll(s1, s2);
        this.setDepthTest(DepthTest.ENABLE);
    }
}
