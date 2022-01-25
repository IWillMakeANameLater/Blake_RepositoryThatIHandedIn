package com.example.friendbookassignment;

import java.util.*;

public class FriendInformation {

    //Static Constants -- These are the default "Data Types" of a "Friend"

    public static final String INFO_TYPE_NAME = "Name";
    public static final String INFO_TYPE_LASTNAME = "Last Name";
    public static final String INFO_TYPE_PHONENUMBER = "Phone Number";
    public static final String INFO_TYPE_EMAIL = "Email";
    public static final String INFO_TYPE_NICKNAME = "Nickname";

    //Fields
    private String information;
    private String value;

    //Constructor
    public FriendInformation(String information, String value){
        this.value = value;
        this.information = information;
    }

    //Getters and Setters

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString(){
        return this.information + ": "+ this.value;
    }
}
