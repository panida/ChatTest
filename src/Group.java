/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cp_panida
 */
import java.util.ArrayList;

public class Group {

    private int id;
    private String name;
    private final ArrayList<Integer> listUserID;
    private ArrayList<ChatMessage> listMessage;

    public Group(String _name, int _id) {
        name = _name;
        id = _id;
        listUserID = new ArrayList<>();
        listMessage = new ArrayList<ChatMessage>();
    }

    public int getID() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Integer> getListUserID() {
        return this.listUserID;
    }

    public void addUser(int userID) {
        if (listUserID.indexOf(Integer.valueOf(userID)) == -1) {
            listUserID.add(Integer.valueOf(userID));
        } else {
            System.out.println("This user is already in this group");
        }
    }

    public void leaveGroup(int userID) {
        if (listUserID.indexOf(Integer.valueOf(userID)) != -1) {
            listUserID.remove(listUserID.indexOf(Integer.valueOf(userID)));
        } else {
            System.out.println("This user(" + userID + ") is not in this group " + this.id);
        }
    }
    
    public void addChatMessage(ChatMessage msg){
        listMessage.add(msg);
    }
    
    public ChatMessage getMessage(int msgID){
        return listMessage.get(msgID);
    }
    
    public int getCurrentMessageID(){
        return listMessage.size()-1;
    }
    
    public boolean isInGroup(int userID){
        for(int i=0;i<listUserID.size();i++){
            if(userID == listUserID.get(i)) return true;
        }
        return false;
    }

}
