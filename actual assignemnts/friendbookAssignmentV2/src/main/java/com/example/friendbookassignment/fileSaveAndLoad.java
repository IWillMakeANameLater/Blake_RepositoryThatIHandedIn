package com.example.friendbookassignment;

import java.io.*;
import java.util.ArrayList;
import java.util.UUID;

public class fileSaveAndLoad {

    public static ArrayList<Friend> SAVEDFRIENDS = new ArrayList<>();

    private static FileWriter baseWriter;
    private static BufferedWriter friendWriter;

    private static FileReader baseReader;
    private static BufferedReader friendReader;

    private static String saveFile = "src/saveFiles/friends.txt";

    //Save friend
    public static boolean saveFriend(Friend friendToSave) throws IOException {

        if(lookForSavedFriend(friendToSave.getFriendID()) != null) {
            return false;
        }
        baseWriter = new FileWriter(saveFile, true);
        friendWriter = new BufferedWriter(baseWriter);

        friendWriter.write("___FRIEND___//X//\r");

        ArrayList<FriendInformation> allFriendInfo = friendToSave.getAllFriendInformation();
        friendWriter.write("__FID__:" + friendToSave.getFriendID() + "//X//\r");
        for(FriendInformation info : allFriendInfo){
            String infoName = info.getInformation();
            String infoValue = info.getValue();
            friendWriter.write("__INFO__:" + infoName + "//X//__VALUE__:" + infoValue + "//X//\r");
        }

        friendWriter.write("__END__//X//\r");
        friendWriter.close();

        updateSavedFriends();
        return true;
    }

    public static Friend lookForSavedFriend(UUID friendID){
        for(Friend savedFriend : SAVEDFRIENDS){
           if (savedFriend.getFriendID().compareTo(friendID) == 0){
               return savedFriend;
           }
        }
        return null;
    }

    public static void updateSavedFriends() throws IOException {
        SAVEDFRIENDS.clear();

        baseReader = new FileReader(saveFile);
        friendReader = new BufferedReader(baseReader);

        String line;
        boolean readingFriend = false;

        UUID friendID = null;
        ArrayList<FriendInformation> userFriendInformation = new ArrayList<>();

        while((line = friendReader.readLine()) != null){
            if (line.contains("___FRIEND___//X//")){
                readingFriend = true;
                continue;
            } else if ( line.contains("__END__//X//")){
                readingFriend = false;
                Friend savedFriend = new Friend(friendID);
                for(FriendInformation friendInfo : userFriendInformation ){
                    savedFriend.addFriendInfo(friendInfo);
                }
                SAVEDFRIENDS.add(savedFriend);

                friendID = null;
                userFriendInformation.clear();
                continue;
            }
            if (readingFriend){
                if(line.contains("__FID__:")){
                    int start = 8;
                    int end = line.indexOf("//X//");
                    String userID = line.substring(start, end);
                    friendID = UUID.fromString(userID);
                } else if (line.contains("__INFO__:")){
                    int infoNameStart = 9;
                    int infoNameEnd = line.indexOf("//X//");
                    String infoName = line.substring(infoNameStart, infoNameEnd);
                    line = line.substring(infoNameEnd + 5);
                    int infoValueStart = 10;
                    int infoValueEnd = line.indexOf("//X//");
                    String infoValue = line.substring(infoValueStart, infoValueEnd);
                    userFriendInformation.add(new FriendInformation(infoName, infoValue));
                }
            }
        }
    }

    public static boolean deleteFriend(UUID friendID) throws IOException {
        boolean deletedFriend = false;

        PrintWriter clearWriter = new PrintWriter(saveFile);
        clearWriter.flush();
        clearWriter.close();

        ArrayList<Friend> backupFriends = new ArrayList<>(SAVEDFRIENDS);
        SAVEDFRIENDS.clear();
        for (Friend saved : backupFriends) {
            UUID savedID = saved.getFriendID();
            if (savedID.compareTo(friendID) == 0) {  // Don't save this friend
                deletedFriend = true;
            } else {
                saveFriend(saved);
            }
        }
        updateSavedFriends();
        return deletedFriend;
    }

    public static void changeSaveFile(String saveFilePath) throws IOException {
        saveFile = saveFilePath;
        updateSavedFriends();
    }

    public static String getSaveFileName(){
        return saveFile;
    }
}
