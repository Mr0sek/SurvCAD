module net.osek.survcad {
    requires javafx.controls;
    requires javafx.fxml;


    opens net.osek.survcad to javafx.fxml;
    exports net.osek.survcad;
}