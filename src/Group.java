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
    
    
    public Group(String _name, int _id){
        name = _name;
        id = _id;
        listUserID = new ArrayList<>();
    }
    
    public int getID() {
        return this.id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public ArrayList<Integer> getUserID() {
        return this.listUserID;
    }
    
    public void addUser(int UserID) {
        if(listUserID.indexOf(Integer.valueOf(UserID)) == -1) {
            listUserID.add(Integer.valueOf(UserID));
        }
        else {
            System.out.println("This user(" + this.name + ") is already in this group(" + UserID + ")");
        }
    }
    public void leaveGroup(int UserID) {
        if(listUserID.indexOf(Integer.valueOf(UserID)) != -1) {
            listUserID.remove(listUserID.indexOf(Integer.valueOf(UserID)));
        }
        else {
            System.out.println("This user(" + this.name + ") is not in this group(" + UserID + ")");
        }
    }
    
}
