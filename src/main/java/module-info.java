module net.osek.survcad {
    requires java.sql;
    requires javafx.graphics;
    requires javafx.controls;
    requires org.apache.derby.engine;
    requires org.apache.derby.tools;
    requires java.desktop;


    opens net.osek.survcad to javafx.fxml;
    exports net.osek.survcad;
    exports net.osek.survcad.menu;
    opens net.osek.survcad.menu to javafx.fxml;
    exports net.osek.survcad.menu.toolbars;
    opens net.osek.survcad.menu.toolbars to javafx.fxml;
}