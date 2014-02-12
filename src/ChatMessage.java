/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
        // Cat Naooo

/**
 *
 * @author cp_panida
 */

import java.io.*;
/*
 * This class defines the different type of messages that will be exchanged between the
 * Clients and the Server. 
 * When talking from a Java Client to a Java Server a lot easier to pass Java objects, no 
 * need to count bytes or to wait for a line feed at the end of the frame
 */

public class ChatMessage implements Serializable {

    protected static final long serialVersionUID = 1112122200L;

	// The different types of message sent by the Client
    // WHOISIN to receive the list of the users connected
    // MESSAGE an ordinary message
    // LOGOUT to disconnect from the Server
    static final int LOGIN = 1, LOGOUT = 2, MESSAGE = 3, JOINGROUP = 4, LEAVEGROUP = 5, EXITGROUP = 6, ENTERGROUP = 7, 
            LISTGROUP = 8, WHOISIN = 9, CREATEGROUP = 10;
    private int type;
    private String message;
    private int groupID;

    // constructor
    ChatMessage(int type, String message, int _groupID) {
        this.type = type;
        this.message = message;
        this.groupID = _groupID;
    }

    // getters
    int getType() {
        return type;
    }

    String getMessage() {
        return message;
    }

    int getGroupID() {
        return groupID;
    }
    
    @Override
    public String toString() {
        return this.getMessage();
    }
}
