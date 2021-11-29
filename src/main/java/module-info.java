module cnpm.team.quanlynhankhau {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;

    opens cnpm.team.quanlynhankhau to javafx.fxml;
    exports cnpm.team.quanlynhankhau;
}