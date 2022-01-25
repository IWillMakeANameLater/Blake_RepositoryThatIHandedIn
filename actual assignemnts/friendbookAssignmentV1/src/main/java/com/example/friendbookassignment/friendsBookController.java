package com.example.friendbookassignment;

import java.util.*;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;

public class friendsBookController {

    //Fields
    private Friend currentFriend = null;
    private FriendInformation currentSelectedInfo = null;

    @FXML
    private Button deleteFriendButton;

    @FXML
    private Button deleteInfoButton;

    @FXML
    private Button changeInfoButton;

    @FXML
    private Button addInfoButton;

    @FXML
    private ListView<Friend> friendsList;

    @FXML
    private ListView<FriendInformation> displayInfoArea;

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

    @FXML
    private TextArea infoName;

    @FXML
    private TextArea infoValue;

    // Setup at Start

    @FXML
    public void initialize(){
    }

    // Handling Button Actions

    public void onSubmit(ActionEvent actionEvent){
        String friendName = nameField.getText();
        String friendLastName = lastNameField.getText();
        String friendNickName = nicknameField.getText();
        String friendEmail = emailField.getText();
        String friendPhoneNumber = phoneField.getText();

        Friend addedFriend = new Friend();
        addedFriend.addFriendInfo(new FriendInformation(FriendInformation.INFO_TYPE_NAME, friendName));
        addedFriend.addFriendInfo(new FriendInformation(FriendInformation.INFO_TYPE_LASTNAME, friendLastName));
        addedFriend.addFriendInfo(new FriendInformation(FriendInformation.INFO_TYPE_PHONENUMBER, friendPhoneNumber));
        addedFriend.addFriendInfo(new FriendInformation(FriendInformation.INFO_TYPE_EMAIL, friendEmail));
        addedFriend.addFriendInfo(new FriendInformation(FriendInformation.INFO_TYPE_NICKNAME, friendNickName));

        friendsList.getItems().add(addedFriend);

        nameField.clear();
        lastNameField.clear();
        nicknameField.clear();
        emailField.clear();
        phoneField.clear();
    }

    public void onDeleteFriend(ActionEvent actionEvent){
        friendsList.getSelectionModel().clearSelection();
        friendsList.getItems().remove(currentFriend);
        clearDisplayInfo();
    }

    public void onDeleteInfo(ActionEvent actionEvent){
        currentFriend.removeFriendInfo(currentSelectedInfo);
        displayInfoArea.getSelectionModel().clearSelection();
        clearEditInformation();
        loadDisplayInfo();
    }

    public void onChangeInfo(ActionEvent actionEvent){
        String newInfoName = infoName.getText();
        String newInfoValue = infoValue.getText();
        currentSelectedInfo.setInformation(newInfoName);
        currentSelectedInfo.setValue(newInfoValue);
        displayInfoArea.getSelectionModel().clearSelection();
        clearEditInformation();
        loadDisplayInfo();
    }

    public void onAddNew(ActionEvent actionEvent){
        FriendInformation newFriendInfo = new FriendInformation(infoName.getText(), infoValue.getText());
        currentFriend.addFriendInfo(newFriendInfo);
        clearEditInformation();
        loadDisplayInfo();
    }

    //Handling selection
    public void onMouseClickFriend(MouseEvent mouseEvent){
        clearDisplayInfo();
        this.currentFriend = friendsList.getSelectionModel().getSelectedItem();
        loadDisplayInfo();
        deleteFriendButton.setDisable(false);
        addInfoButton.setDisable(false);
        infoName.setDisable(false);
        infoValue.setDisable(false);
    }

    public void onMouseClickInfo(MouseEvent mouseEvent){
        clearEditInformation();
        currentSelectedInfo = displayInfoArea.getSelectionModel().getSelectedItem();
        infoName.setText(currentSelectedInfo.getInformation());
        infoValue.setText(currentSelectedInfo.getValue());
        deleteInfoButton.setDisable(false);
        changeInfoButton.setDisable(false);
    }

    //Other methods
    private void loadDisplayInfo(){
        displayInfoArea.getItems().clear();
        ArrayList<FriendInformation> currentFriendInfo = this.currentFriend.getAllFriendInformation();
        for (int i = 0; i<currentFriendInfo.size(); i++){
            FriendInformation currentInfo = currentFriendInfo.get(i);
            displayInfoArea.getItems().add(currentInfo);
        }
        friendsList.refresh();
    }

    private void clearDisplayInfo(){
        displayInfoArea.getItems().clear();
        currentFriend = null;
        deleteFriendButton.setDisable(true);
        addInfoButton.setDisable(true);
        infoName.setDisable(true);
        infoValue.setDisable(true);
        clearEditInformation();
    }

    private void clearEditInformation(){
        infoName.clear();
        infoValue.clear();
        changeInfoButton.setDisable(true);
        deleteInfoButton.setDisable(true);
        currentSelectedInfo = null;
    }
}