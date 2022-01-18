package com.example.calculator;

public class calcAction {
    //Constants

    public static final String ACTIONTYPE_NUM = "NUMBER";
    public static final String ACTIONTYPE_OPERATOR = "OPERATOR";

    //Fields
    private String actionType;
    private String value;

    //Constructor
    public calcAction(String actionType, String value){
        this.actionType = actionType;
        this.value = value;
    }

    //Getters
    public String getActionType(){
        return this.actionType;
    }

    public String getValue(){
        return this.value;
    }

    //String method
    @Override
    public String toString(){
        return "Action Type:"+this.actionType+" , Value:" + this.value;
    }
}
