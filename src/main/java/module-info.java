module com.example.casino7 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.casino7 to javafx.fxml;
    exports com.example.casino7;
}