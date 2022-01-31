package com.example.friendbookassignment;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

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
    private Button saveButton;

    @FXML
    private ListView<Friend> friendsList;

    @FXML
    private ListView<FriendInformation> displayInfoArea;

    @FXML
    private ListView<String> saveFileDisplay;

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

    @FXML
    private TextArea newSaveFileNameField;

    @FXML
    private Label currentFileText;

    //On start setup

    @FXML
    public void initialize() throws IOException{
        updateListedSaveFiles();
        if(!saveFileDisplay.getItems().contains("src/saveFiles/friends.txt")){
            File defaultSaveFile = new File("src/saveFiles/friends.txt"); // in case default save file does not exist
            defaultSaveFile.createNewFile();
            updateListedSaveFiles();
        }
        currentFileText.setText(fileSaveAndLoad.getSaveFileName());
        fileSaveAndLoad.updateSavedFriends();

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

    public void onDeleteFriend(ActionEvent actionEvent) throws IOException {
        friendsList.getSelectionModel().clearSelection();
        friendsList.getItems().remove(currentFriend);
        fileSaveAndLoad.deleteFriend(currentFriend.getFriendID());
        clearDisplayInfo();
    }

    public void onDeleteInfo(ActionEvent actionEvent) throws IOException {
        currentFriend.removeFriendInfo(currentSelectedInfo);
        displayInfoArea.getSelectionModel().clearSelection();
        clearEditInformation();
        loadDisplayInfo();
        updateSaveFile();
    }

    public void onChangeInfo(ActionEvent actionEvent) throws IOException {
        String newInfoName = infoName.getText();
        String newInfoValue = infoValue.getText();
        currentSelectedInfo.setInformation(newInfoName);
        currentSelectedInfo.setValue(newInfoValue);
        displayInfoArea.getSelectionModel().clearSelection();
        clearEditInformation();
        loadDisplayInfo();
        updateSaveFile();
    }

    public void onAddNew(ActionEvent actionEvent) throws IOException {
        FriendInformation newFriendInfo = new FriendInformation(infoName.getText(), infoValue.getText());
        currentFriend.addFriendInfo(newFriendInfo);
        clearEditInformation();
        loadDisplayInfo();
        updateSaveFile();
    }

    public void onSave(ActionEvent actionEvent) throws IOException {
        fileSaveAndLoad.saveFriend(currentFriend);
    }

    public void onLoad(ActionEvent actionEvent) throws IOException{
        loadFriends();
    }

    public void onAddSaveFile(ActionEvent actionEvent) throws IOException {
        String newFileName = newSaveFileNameField.getText();
        newSaveFileNameField.clear();

        String path = "src/saveFiles/"+newFileName+".txt";
        File newSaveFile = new File(path);
        newSaveFile.createNewFile();

        saveFileDisplay.getItems().add(newSaveFile.getPath());
        updateListedSaveFiles();
    }

    //Handling selection
    public void onMouseClickFriend(MouseEvent mouseEvent){
        clearDisplayInfo();
        this.currentFriend = friendsList.getSelectionModel().getSelectedItem();
        if (currentFriend != null){
            loadDisplayInfo();
            deleteFriendButton.setDisable(false);
            addInfoButton.setDisable(false);
            infoName.setDisable(false);
            infoValue.setDisable(false);
            saveButton.setDisable(false);
        }
    }

    public void onMouseClickInfo(MouseEvent mouseEvent){
        clearEditInformation();
        currentSelectedInfo = displayInfoArea.getSelectionModel().getSelectedItem();
        if(currentSelectedInfo != null){
            infoName.setText(currentSelectedInfo.getInformation());
            infoValue.setText(currentSelectedInfo.getValue());
            deleteInfoButton.setDisable(false);
            changeInfoButton.setDisable(false);
        }
    }

    public void onSelectSaveFile(MouseEvent mouseEvent) throws IOException {
        String newSaveFilePath;
        newSaveFilePath = saveFileDisplay.getSelectionModel().getSelectedItem();
        fileSaveAndLoad.changeSaveFile(newSaveFilePath);
        currentFileText.setText(fileSaveAndLoad.getSaveFileName());
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
        saveButton.setDisable(true);
        clearEditInformation();
    }

    private void clearEditInformation(){
        infoName.clear();
        infoValue.clear();
        changeInfoButton.setDisable(true);
        deleteInfoButton.setDisable(true);
        currentSelectedInfo = null;
    }

    private void loadFriends(){
        friendsList.getItems().clear();
        for(Friend savedFriend : fileSaveAndLoad.SAVEDFRIENDS){
            friendsList.getItems().add(savedFriend);
        }
    }

    private void updateSaveFile() throws IOException {
        fileSaveAndLoad.deleteFriend(currentFriend.getFriendID());
        fileSaveAndLoad.saveFriend(currentFriend);
    }

    private void updateListedSaveFiles() throws IOException {
        saveFileDisplay.getItems().clear();
        String basePath = "src/saveFiles";
        File saveDirectory = new File(basePath);
        for (File file : Objects.requireNonNull(saveDirectory.listFiles())){
            saveFileDisplay.getItems().add(file.getPath());
        }
    }
}