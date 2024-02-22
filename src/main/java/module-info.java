module com.example.javatest {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javatest to javafx.fxml;
    exports com.example.javatest;
}