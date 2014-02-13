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
    private String username;
    private final ArrayList<Integer> listGroupID;
    private ArrayList<Integer> lastMesID;

    public User(String _name, int _id) {
        username = _name;
        id = _id;
        listGroupID = new ArrayList<>();
        lastMesID = new ArrayList<>();
    }

    public int getID() {
        return this.id;
    }

    public String getName() {
        return this.username;
    }

    public ArrayList<Integer> getGroupID() {
        return this.listGroupID;
    }

    public void addGroup(int groupID) {
        if (listGroupID.indexOf(groupID) == -1) {
            listGroupID.add(groupID);
        } else {
            System.out.println("This user(" + this.username + ") is already in this group(" + groupID + ")");
        }
    }

    public void leaveGroup(int index) {
        listGroupID.remove(index);
        lastMesID.remove(index);
        
        /*
        if (listGroupID.indexOf(Integer.valueOf(groupID)) != -1) {
            listGroupID.remove(listGroupID.indexOf(Integer.valueOf(groupID)));
        } else {
            System.out.println("This user(" + this.username + ") is not in this group(" + groupID + ")");
        }
        */
    }

    public void addMsgID(int msgID) {
        lastMesID.add(msgID);
    }
    
    
    
    
    
    public int getLastMessageID(int grID) {
            return lastMesID.get(indexOfgr(grID));
        }

    public int indexOfgr(int grID) {
        for (int i = 0; i < listGroupID.size(); i++) {
            if (listGroupID.get(i) == grID) {
                return i;
            }
        }
        return -1;
    }

    public void setLastMessageID(int grID, int mID) {
        lastMesID.set(indexOfgr(grID), mID);
    }

    public ArrayList<Integer> getListGroupID() {
        return listGroupID;
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
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        a.leaveGroup(4);
        a.leaveGroup(5);

        it = group.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
