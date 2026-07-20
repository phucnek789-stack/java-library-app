module com.pnhp.libraryapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.base;

    opens com.pnhp.libraryapp to javafx.fxml;
    exports com.pnhp.libraryapp;
    exports com.pnhp.pojo;
}
