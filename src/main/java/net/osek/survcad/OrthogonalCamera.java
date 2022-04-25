package net.osek.survcad;

import javafx.scene.ParallelCamera;

public class OrthogonalCamera extends ParallelCamera {

    public OrthogonalCamera() {

        this.setNearClip(1);
        this.setFarClip(1000);

        this.translateZProperty().set(-200);

    }
}
