package com.example.friendbookassignment;

import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;

import com.example.friendbookassignment.Friend;

public class friendsBookController {

    //Fields

    // Setting up elements

    @FXML
    private Button deleteButton;

    @FXML
    private Button submitButton;

    @FXML
    private ListView friendsList;

    @FXML
    private TableView friendInfoTable;
    
    @FXML
    private TableColumn friendInfoCol;

    @FXML
    private TableColumn friendInfoCol2;

    @FXML
    private TextArea nameField;

    @FXML
    private TextArea lastNameField;

    @FXML
    private TextArea emailField;

    @FXML
    private TextArea phoneField;

    @FXML
    private TextArea nicknameField;

    // Handling Button Actions

    public void onSubmit(ActionEvent actionEvent){
        String friendName = nameField.getText();
        String friendLastName = lastNameField.getText();
        String friendNickName = nicknameField.getText();
        String friendEmail = emailField.getText();
        String friendPhoneNumber = phoneField.getText();

        Friend addedFriend = new Friend(friendPhoneNumber, friendEmail, friendName, friendLastName, friendNickName);
        friendsList.getItems().add(addedFriend);

        nameField.clear();
        lastNameField.clear();
        nicknameField.clear();
        emailField.clear();
        phoneField.clear();
    }

    public void onDelete(ActionEvent actionEvent){

    }

    public void onMouseClickFriend(MouseEvent mouseEvent){
        System.out.println("Clicked!");
    }
}