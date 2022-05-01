module net.osek.survcad {
    requires java.sql;
    requires javafx.graphics;
    requires javafx.controls;
    requires org.apache.derby.engine;
    requires org.apache.derby.tools;
    requires java.desktop;


    opens net.osek.survcad to javafx.fxml;
    exports net.osek.survcad;
    exports net.osek.survcad.topPane.menu;
    opens net.osek.survcad.topPane.menu to javafx.fxml;
    exports net.osek.survcad.topPane.menu.toolbars;
    opens net.osek.survcad.topPane.menu.toolbars to javafx.fxml;
    exports net.osek.survcad.sidePanes;
    opens net.osek.survcad.sidePanes to javafx.fxml;
}