package com.example.friendbookassignment;

import java.util.ArrayList;
import java.util.Objects;

public class Friend {
    //Fields

    private ArrayList<FriendInformation> friendInfo;

    //Constructor - Default
    public Friend(){
        this.friendInfo = new ArrayList<>();
    }

    //Search for first instance with infoType
    public FriendInformation infoLookUp(String infoType){
        for(int i = 0; i<friendInfo.size(); i++){
            FriendInformation currentInfo = friendInfo.get(i);
            if(Objects.equals(infoType, currentInfo.getInformation())){
                return currentInfo;
            }
        }
        return null;
    }

    public ArrayList getAllFriendInformation(){
        return (ArrayList)this.friendInfo.clone();
    }

    // Add a new friend info
    public void addFriendInfo(FriendInformation addedInfo){
        this.friendInfo.add(addedInfo);
    }

    //Attempt to remove a select friend info
    public boolean removeFriendInfo(FriendInformation requestedRemoval){
        try{
            this.friendInfo.remove(requestedRemoval);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    // To String
    @Override
    public String toString(){
        String friendNickName = infoLookUp(FriendInformation.INFO_TYPE_NICKNAME).getValue();
        String friendName = infoLookUp(FriendInformation.INFO_TYPE_NAME).getValue();
        String friendLastName = infoLookUp(FriendInformation.INFO_TYPE_LASTNAME).getValue();
        if (friendNickName != null && friendNickName != ""){
            return friendNickName;
        } else if (friendName != null && friendName != "") {
            return friendName;
        }  else if (friendLastName != null && friendLastName != ""){
            return friendLastName;
        }
        else {
            return "Unnamed Friend";
        }
    }
}
