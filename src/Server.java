
/**
 *
 * @author cp_panida
 */
import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*;

/*
 * The server that can be run both as a console application or a GUI
 */
public class Server {

    // a unique ID for each connection
    private static int uniqueId;
    // a unique ID for each group
    private static int uniqueGrId;
    // an ArrayList to keep the list of the Client
    private ArrayList<ClientThread> clientList;
    // if I am in a GUI
    private ServerGUI servGUI;
    // to display time
    private SimpleDateFormat sdf;
    // the port number to listen for connection
    private int port;
    // the boolean that will be turned of to stop the server
    private boolean keepGoing;

    private ArrayList<Group> listGr;


    /*
     *  server constructor that receive the port to listen to for connection as parameter
     *  in console
     */
    public Server(int port) {
        this(port, null);
    }

    public Server(int port, ServerGUI servGUI) {
        // GUI or not
        this.servGUI = servGUI;
        // the port
        this.port = port;
        // to display hh:mm:ss
        sdf = new SimpleDateFormat("HH:mm:ss");
        // ArrayList for the Client list
        clientList = new ArrayList<ClientThread>();
        listGr = new ArrayList<Group>();
    }

    public void start() {
        keepGoing = true;
        /* create socket server and wait for connection requests */
        try {
            // the socket used by the server
            ServerSocket serverSocket = new ServerSocket(port);

            // infinite loop to wait for connections
            while (keepGoing) {
                // format message saying we are waiting
                display("Server waiting for Clients on port " + port + ".");

                Socket socket = serverSocket.accept();  	// accept connection
                // if I was asked to stop
                if (!keepGoing) {
                    break;
                }
                ClientThread ct = new ClientThread(socket);  // make a thread of it
                clientList.add(ct);			// save it in the ArrayList
                ct.start();
            }
            // I was asked to stop
            try {
                serverSocket.close();
                for (int i = 0; i < clientList.size(); i++) {
                    ClientThread tc = clientList.get(i);
                    try {
                        tc.sInput.close();
                        tc.sOutput.close();
                        tc.socket.close();
                    } catch (IOException ioE) {
                        // not much I can do
                    }
                }
            } catch (Exception e) {
                display("Exception closing the server and clients: " + e);
            }
        } // something went bad
        catch (IOException e) {
            String msg = sdf.format(new Date()) + " Exception on new ServerSocket: " + e + "\n";
            display(msg);
        }
    }

    /**
     * For the GUI to stop the server
     */
    protected void stop() {
        keepGoing = false;
        // connect to myself as Client to exit statement 
        // Socket socket = serverSocket.accept();
        try {
            new Socket("localhost", port);
        } catch (Exception e) {
            // nothing I can really do
        }
    }
    /*
     * Display an event (not a message) to the console or the GUI
     */

    private void display(String msg) {
        String time = sdf.format(new Date()) + " " + msg;
        if (servGUI == null) {
            System.out.println(time);
        } else {
            servGUI.appendEvent(time + "\n");
        }
    }

    /**
     * to broadcast a message to all Clients
     */
    private synchronized void broadcast(String message, int grID) {
        // add HH:mm:ss and \n to the message
        String time = sdf.format(new Date());
        String messageLf = time + " " + message + "\n";
        ChatMessage chatMsgLf;
        // display message on console or GUI
        if (servGUI == null) {
            System.out.print(messageLf);
        } else {
            //servGUI.appendRoom(messageLf, grID);     // append in the room window
        }
        chatMsgLf = new ChatMessage(ChatMessage.MESSAGE, messageLf, grID);
        // we loop in reverse order in case we would have to remove a Client
        // because it has disconnected        
        Group g = searchGroupByGroupID(grID);
        g.addChatMessage(chatMsgLf);
        int mID = g.getCurrentMessageID();
        
        ArrayList<Integer> userInGr = g.getListUserID();
        for (int i = userInGr.size(); --i >= 0;) {
            int currentID = userInGr.get(i);
            ClientThread ct = searchUserByUserID(currentID);
            if (ct.getCurrentGroupID() == g.getID()) {
                if (ct.getLastMessageID(g.getID()) < g.getCurrentMessageID() - 1) {
                    for (int j = ct.getLastMessageID(g.getID()) + 1; j <= g.getCurrentMessageID() - 1; j++) {
                        System.out.println("message: "+j);
                        if (!ct.writeMsg(g.getMessage(j))) {
                            clientList.remove(currentID);
                            display("Disconnected Client " + ct.username + " removed from list.");
                        }
                    }
                    
                }
                if (!ct.writeMsg(g.getMessage(mID))) {
                     clientList.remove(currentID);
                     display("Disconnected Client " + ct.username + " removed from list.");
               }
                else{
                    
                    ct.setLastMessageID(g.getID(), mID);
                }

            }
        }
    }

    // for a client who logoff using the LOGOUT message
    synchronized void remove(int id) {
        // scan the array list until we found the Id
        for (int i = 0; i < clientList.size(); ++i) {
            ClientThread ct = clientList.get(i);
            // found it
            if (ct.id == id) {
                clientList.remove(i);
                ArrayList<Integer> groupOfClient = ct.getListGroupID();
                for (int j = 0; j < groupOfClient.size(); j++) {
                    searchGroupByGroupID(groupOfClient.get(j)).leaveGroup(id);
                }
                return;
            }
        }
    }

    /**
     * @author LotK
     * @param id
     * @return
     */
    private ClientThread searchUserByUserID(int id) {
        int left = 0, right = clientList.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (clientList.get(mid).getID() == id) {
                System.out.println("Found user: " + clientList.get(mid).getUsername());
                return clientList.get(mid);
            }
            if (clientList.get(mid).getID() < id) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println("Not found user with id " + id);
        return null;
    }

    private Group searchGroupByGroupID(int id) {
        int left = 0, right = listGr.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (listGr.get(mid).getID() == id) {
                return listGr.get(mid);
            }
            else if (listGr.get(mid).getID() < id) {
                left = mid +1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println("Not found Group with id " + id);
        return null;
    }

    private Group searchGroupByName(String grName) {
        Group g;
        for (int i = 0; i < listGr.size(); i++) {
            g = listGr.get(i);
            if (g.getName().equalsIgnoreCase(grName)) {
                return g;
            }
        }
        return null;
    }

    /**
     * To run as a console application just open a console window and: > java
     * Server > java Server portNumber If the port number is not specified 1500
     * is used
     */
    public static void main(String[] args) {
        // start server on port 1500 unless a PortNumber is specified 
        int portNumber = 1500;
        switch (args.length) {
            case 1:
                try {
                    portNumber = Integer.parseInt(args[0]);
                } catch (Exception e) {
                    System.out.println("Invalid port number.");
                    System.out.println("Usage is: > java Server [portNumber]");
                    return;
                }
            case 0:
                break;
            default:
                System.out.println("Usage is: > java Server [portNumber]");
                return;

        }
        // create a server object and start it
        Server server = new Server(portNumber);
        server.start();
    }

    /**
     * One instance of this thread will run for each client
     */
    class ClientThread extends Thread {

        ArrayList<Integer> listGrID;
        ArrayList<Integer> lastMesID;

        int currentGrID; //if I'm not in any group, currentGrID=-1

        // the socket where to listen/talk
        Socket socket;
        ObjectInputStream sInput;
        ObjectOutputStream sOutput;
        // my unique id (easier for deconnection)
        int id;
        // the Username of the Client
        String username;
        // the only type of message a will receive
        ChatMessage cm;
        // the date I connect
        String date;

        // Constructore
        ClientThread(Socket socket) {
            // a unique id
            id = ++uniqueId;
            this.socket = socket;
            this.currentGrID = -1;
            this.listGrID = new ArrayList<>();
            this.lastMesID = new ArrayList<>();
            /* Creating both Data Stream */
            System.out.println("Thread trying to create Object Input/Output Streams");
            try {
                // create output first
                sOutput = new ObjectOutputStream(socket.getOutputStream());
                sInput = new ObjectInputStream(socket.getInputStream());
                // read the username
                username = (String) sInput.readObject();
                display(username + " just connected.");
            } catch (IOException e) {
                display("Exception creating new Input/output Streams: " + e);
                return;
            } // have to catch ClassNotFoundException
            // but I read a String, I am sure it will work
            catch (ClassNotFoundException e) {
            }
            date = new Date().toString() + "\n";
        }

        // what will run forever
        public void run() {
            // to loop until LOGOUT
            boolean keepGoing = true;
            while (keepGoing) {
                // read a String (which is an object)
                try {
                    cm = (ChatMessage) sInput.readObject();
                } catch (IOException e) {
                    display(username + " Exception reading Streams: " + e);
                    break;
                } catch (ClassNotFoundException e2) {
                    break;
                }
                // the messaage part of the ChatMessage
                String message = cm.getMessage();
                String msg = "";
                String msgToClient = "";
                ChatMessage outMsg;
                String tname;
                // Switch on the type of message receive
                switch (cm.getType()) {

                    case ChatMessage.MESSAGE:

                        broadcast(username + ": " + message, cm.getGroupID());
                        break;
                    case ChatMessage.LOGOUT:
                        currentGrID = -1;
                        display(username + " disconnected");
                        keepGoing = false;
                        break;
                    case ChatMessage.WHOISIN:

                        msg = msg + "List of the users connected at " + sdf.format(new Date()) + "\n";
                        // scan clientList the users connected
                        Group g = searchGroupByGroupID(id);
                        ArrayList<Integer> listUserInGroup = g.getListUserID();
                        for (int i = 0; i < listUserInGroup.size(); ++i) {
                            ClientThread ct = searchUserByUserID(listUserInGroup.get(i));
                            msg = msg + (i + 1) + ") " + ct.username + " since " + ct.date;
                            msgToClient = msgToClient + ct.username + ",";
                        }
                        outMsg = new ChatMessage(ChatMessage.WHOISIN, msgToClient, cm.getGroupID());
                        display(msg);
                        writeMsg(outMsg);
                        break;

                    case ChatMessage.LISTGROUP:
                        msg = "";
                        msgToClient = "";

                        msg = msg + "List of the Group connected at " + sdf.format(new Date()) + "\n";

                        for (int i = 0; i < listGrID.size(); ++i) {
                            g = searchGroupByGroupID(listGrID.get(i));
                            msg = msg + (i + 1) + ") " + g.getName();
                            msgToClient = msgToClient + g.getID() + "," + g.getName() + ";";
                        }
                        outMsg = new ChatMessage(ChatMessage.LISTGROUP, msgToClient, cm.getGroupID());
                        display(msg);
                        writeMsg(outMsg);
                        break;
                    case ChatMessage.JOINGROUP:
                        g = searchGroupByName(cm.getMessage());
                        if (g != null) {
                            if (!g.isInGroup(id)) {
                                g.addUser(id);
                                listGrID.add(g.getID());
                                lastMesID.add(g.getCurrentMessageID());
                                currentGrID = g.getID();
                                display("" + username + " just joined group " + g.getName());
                                broadcast("" + username + " just joined", g.getID());
                                outMsg = new ChatMessage(ChatMessage.JOINGROUP, g.getName(), g.getID());
                                writeMsg(outMsg);
                            } else {
                                display("" + username + " is already in Group " + g.getName());
                                outMsg = new ChatMessage(ChatMessage.JOINGROUP, "" + username + " is already in Group " + g.getName(), 0);
                                writeMsg(outMsg);

                            }
                        } else {
                            display("" + cm.getMessage() + " does not exist");
                            writeMsg(new ChatMessage(ChatMessage.JOINGROUP, "" + cm.getMessage() + " does not exist", 0));
                        }
                        break;
                    case ChatMessage.CREATEGROUP:
                        tname = cm.getMessage();
                        g = searchGroupByName(tname);
                        if (g == null) {
                            g = new Group(tname, ++uniqueGrId);
                            
                            listGr.add(g);
                            display("" + username + " just created group " + tname + " with ID " + g.getID());
                            outMsg = new ChatMessage(ChatMessage.CREATEGROUP, ""+tname, g.getID());
                            writeMsg(outMsg);
                        } else {
                            display("" + tname + " already exists");
                            outMsg = new ChatMessage(ChatMessage.CREATEGROUP, "" + tname + " already exists", 0);
                            writeMsg(outMsg);
                        }
                        break;
                    case ChatMessage.ENTERGROUP:
//                        tname = cm.getMessage();
                        int tID = cm.getGroupID();
                        g = searchGroupByGroupID(tID);
                        if (g != null) {              
//                            display("" + username + " just entered group " + tname + " with ID " + g.getID());
                            display("" + username + " just entered group " + g.getName() + " with ID " + g.getID());
                            currentGrID=g.getID();
                            outMsg = new ChatMessage(ChatMessage.ENTERGROUP,"", g.getID());
                            writeMsg(outMsg);
                            //broadcast("" + username + " just entered group",g.getID());
                        
                        } 
//                        else {
//                            display("" + tname + " does not exists");
//                            outMsg = new ChatMessage(ChatMessage.ENTERGROUP, "Group " + tname + " does not exist", 0);
//                            writeMsg(outMsg);
//                        }
                        break;
                    case ChatMessage.EXITGROUP:
                        currentGrID=-1;
                        break;
                    case ChatMessage.LEAVEGROUP:
                        searchGroupByGroupID(currentGrID).leaveGroup(id);
                        int index = indexOfgr(id);
                        listGrID.remove(index);
                        lastMesID.remove(index);
                        broadcast(""+username+" left group",currentGrID);
                        
                        currentGrID=-1;
                        break;
                        
                        
                        
                        
                        
                }
            }
            // remove myself from the arrayList containing the list of the
            // connected Clients
            remove(id);
            close();
        }

        // try to close everything
        private void close() {
            // try to close the connection
            try {
                if (sOutput != null) {
                    sOutput.close();
                }
            } catch (Exception e) {
            }
            try {
                if (sInput != null) {
                    sInput.close();
                }
            } catch (Exception e) {
            };
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (Exception e) {
            }
        }

        /*
         * Write a String to the Client output stream
         */
        private boolean writeMsg(ChatMessage msg) {
            // if Client is still connected send the message to it
            if (!socket.isConnected()) {
                close();
                return false;
            }
            // write the message to the stream
            try {
                sOutput.writeObject(msg);
            } // if an error occurs, do not abort just inform the user
            catch (IOException e) {
                display("Error sending message to " + username);
                display(e.toString());
            }
            return true;
        }

        private int getID() {
            return id;
        }

        private String getUsername() {
            return username;
        }

        private int getLastMessageID(int grID) {
            return lastMesID.get(indexOfgr(grID));
        }

        private int getCurrentGroupID() {
            return this.currentGrID;
        }

        private void setLastMessageID(int grID, int mID) {
            lastMesID.set(indexOfgr(grID), mID);
        }

        private ArrayList<Integer> getListGroupID() {
            return listGrID;
        }

        private int indexOfgr(int grID) {
            for (int i = 0; i < listGrID.size(); i++) {
                if (listGrID.get(i) == grID) {
                    return i;
                }
            }
            return -1;
        }
    }
}
