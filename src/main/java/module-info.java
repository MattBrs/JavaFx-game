module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;


    opens it.unitn.prog2.matteo_brusarosco to javafx.fxml;
    exports it.unitn.prog2.matteo_brusarosco;
}