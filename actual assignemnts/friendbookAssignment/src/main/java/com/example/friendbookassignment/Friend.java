package com.example.friendbookassignment;

public class Friend {
    //Fields

    private String phoneNumber;
    private String email;
    private String name;
    private String lastName;
    private String nickName;

    //Constructor
    public Friend(String phoneNumber, String email, String name, String lastName, String nickName){
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.name = name;
        this.lastName = lastName;
        this.nickName = nickName;
    }

    //Getters

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString(){
        return this.nickName;
    }
}
