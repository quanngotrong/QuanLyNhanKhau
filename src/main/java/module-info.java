module cnpm.team.quanlynhankhau {
    requires javafx.controls;
    requires javafx.fxml;


    opens cnpm.team.quanlynhankhau to javafx.fxml;
    exports cnpm.team.quanlynhankhau;
}