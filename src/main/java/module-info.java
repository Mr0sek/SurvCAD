module net.osek.survcad {
    requires javafx.controls;
    requires javafx.fxml;


    opens net.osek.survcad to javafx.fxml;
    exports net.osek.survcad;
    exports net.osek.survcad.menu;
    opens net.osek.survcad.menu to javafx.fxml;
    exports net.osek.survcad.menu.toolbars;
    opens net.osek.survcad.menu.toolbars to javafx.fxml;
}