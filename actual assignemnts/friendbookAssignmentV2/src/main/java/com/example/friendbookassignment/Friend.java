package com.example.friendbookassignment;

import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

public class Friend {
    //Fields

    private ArrayList<FriendInformation> friendInfo;
    private UUID friendID;

    //Constructor - Default
    public Friend(){
        this.friendInfo = new ArrayList<>();
        this.friendID = UUID.randomUUID();
    }

    //Constructor - Set UUID
    public Friend(UUID friendID){
        this.friendInfo = new ArrayList<>();
        this.friendID = friendID;
    }

    public UUID getFriendID(){
        return this.friendID;
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
        FriendInformation friendNickNameInfo = infoLookUp(FriendInformation.INFO_TYPE_NICKNAME);
        if (friendNickNameInfo != null){
            String nickName = friendNickNameInfo.getValue();
            if (nickName != ""){
                return nickName;
            }
        }
        return "Unnamed Friend";
    }
}
