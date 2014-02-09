/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LotK
 */

import java.util.*;

public class User {
    private int id;
    private String name;
    private final ArrayList<Integer> listGroupID;
    
    public User(String _name, int _id) {
        name = _name;
        id = _id;
        listGroupID = new ArrayList<>();
    }
    public int getID() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public ArrayList<Integer> getGroupID() {
        return this.listGroupID;
    }
    
    public void addGroup(int groupID) {
        if(listGroupID.indexOf(Integer.valueOf(groupID)) == -1) {
            listGroupID.add(Integer.valueOf(groupID));
        }
        else {
            System.out.println("This user(" + this.name + ") is already in this group(" + groupID + ")");
        }
    }
    public void leaveGroup(int groupID) {
        if(listGroupID.indexOf(Integer.valueOf(groupID)) != -1) {
            listGroupID.remove(listGroupID.indexOf(Integer.valueOf(groupID)));
        }
        else {
            System.out.println("This user(" + this.name + ") is not in this group(" + groupID + ")");
        }
    }
    
    public static void main(String args[]) {
        User a = new User("Panida", 3);
        System.out.println(a.getID() + " " + a.getName());
        a.addGroup(1);
        a.addGroup(7);
        a.addGroup(5);
        a.addGroup(7);
        ArrayList<Integer> group = a.getGroupID();
        Iterator<Integer> it = group.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
        
        a.leaveGroup(4);
        a.leaveGroup(5);
        
        it = group.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
