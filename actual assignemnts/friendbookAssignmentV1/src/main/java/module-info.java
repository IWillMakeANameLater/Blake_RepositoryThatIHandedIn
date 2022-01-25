module com.example.friendbookassignment {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.friendbookassignment to javafx.fxml;
    exports com.example.friendbookassignment;
}