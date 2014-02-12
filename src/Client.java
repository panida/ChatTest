/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cp_panida
 */
import java.net.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * The Client that can be run both as a console or a GUI
 */
public class Client {

    // for I/O
    private ObjectInputStream sInput;		// to read from the socket
    private ObjectOutputStream sOutput;		// to write on the socket
    private Socket socket;

    // if I use a GUI or not
    private TestGUI cg;

    // the server, the port and the username
    private String server, username;
    private int port;
    
    private ArrayList<Integer> listGroupID;
    private ArrayList<String> listGroupName;
    
    /**
     * Constructor called by console mode server: the server address port: the
     * port number username: the username
     */
    Client(String server, int port, String username) {
        // which calls the common constructor with the GUI set to null
        this(server, port, username, null);
    }

    /**
     * Constructor call when used from a GUI in console mode the ClienGUI
     * parameter is null
     */
    Client(String server, int port, String username, TestGUI cg) {
        this.server = server;
        this.port = port;
        this.username = username;
        // save if we are in GUI mode or not
        this.cg = cg;
        
        listGroupID = new ArrayList<>();
        listGroupName = new ArrayList<>();
        
    }
    
    /**
     * To start the dialog
     */
    public boolean start() {
        // try to connect to the server
        try {
            socket = new Socket(server, port);
        } // if it failed not much I can so
        catch (Exception ec) {
            display("Error connectiong to server:" + ec);
            return false;
        }

        String msg = "Connection accepted " + socket.getInetAddress() + ":" + socket.getPort();
        display(msg);

        /* Creating both Data Stream */
        try {
            sInput = new ObjectInputStream(socket.getInputStream());
            sOutput = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException eIO) {
            display("Exception creating new Input/output Streams: " + eIO);
            return false;
        }

        // creates the Thread to listen from the server 
        new ListenFromServer().start();
		// Send our username to the server this is the only message that we
        // will send as a String. All other messages will be ChatMessage objects
        try {
            sOutput.writeObject(username);
        } catch (IOException eIO) {
            display("Exception doing login : " + eIO);
            disconnect();
            return false;
        }
        // success we inform the caller that it worked
        return true;
    }

    /**
     * To send a message to the console or the GUI
     */
    public void display(String msg) {
        if (cg == null) {
            System.out.println(msg);      // println in console mode
        } else {
            cg.append(msg + "\n");		// append to the ClientGUI JTextArea (or whatever)
        }
    }
    public void displayPlus(String msg) {
        if (cg == null) {
            System.out.println(msg);      // println in console mode
            System.out.print("> ");
        } else {
            cg.append(msg);		// append to the ClientGUI JTextArea (or whatever)
        }
    }

    /**
     * When something goes wrong Close the Input/Output streams and disconnect
     * not much to do in the catch clause
     */
    private void disconnect() {
        try {
            if (sInput != null) {
                sInput.close();
            }
        } catch (Exception e) {
        } // not much else I can do
        try {
            if (sOutput != null) {
                sOutput.close();
            }
        } catch (Exception e) {
        } // not much else I can do
        try {
            if (socket != null) {
                socket.close();
            }
        } catch (Exception e) {
        } // not much else I can do

        // inform the GUI
        if (cg != null) {
            cg.connectionFailed();
        }

    }

    /**
     * Command (no command "login")
     */
    public void logout() {
        this.sendMessage(new ChatMessage(ChatMessage.LOGOUT, "", 0));
        this.disconnect();
    }
    
    void sendMessage(ChatMessage msg) {
        try {
            sOutput.writeObject(msg);
        } catch (IOException e) {
            display("Exception writing to server: " + e);
        }
    }
    
    public void joinGroup(String groupName) {
        this.sendMessage(new ChatMessage(ChatMessage.JOINGROUP, groupName, 0));
    }
    
    public void leaveGroup(int groupID) {
        this.sendMessage(new ChatMessage(ChatMessage.LEAVEGROUP, "", groupID));
    }
    
    public void enterGroup(int groupID) {
        this.sendMessage(new ChatMessage(ChatMessage.ENTERGROUP, "", groupID));
    }
    
    public void exitGroup(int groupID) {
        this.sendMessage(new ChatMessage(ChatMessage.EXITGROUP, "", groupID));
    }
    
    // what is it?
    public void listinGroup(int groupID) {
        this.sendMessage(new ChatMessage(ChatMessage.LISTGROUP, "", groupID));
    }
    
    public void whoisin(int groupID) {
        this.sendMessage(new ChatMessage(ChatMessage.WHOISIN, "", groupID));
    }
    
    public void createGroup(String name) {
        try {        
            ChatMessage msg = new ChatMessage(ChatMessage.CREATEGROUP, name, 0);
            sOutput.writeObject(msg);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * END Command Section
     */
    
    
    /**
     * To start the Client in console mode use one of the following command >
     * java Client > java Client username > java Client username portNumber >
     * java Client username portNumber serverAddress at the console prompt If
     * the portNumber is not specified 1500 is used If the serverAddress is not
     * specified "localHost" is used If the username is not specified
     * "Anonymous" is used > java Client is equivalent to > java Client
     * Anonymous 1500 localhost are eqquivalent
     *
     * In console mode, if an error occurs the program simply stops when a GUI
     * id used, the GUI is informed of the disconnection
     */
    public static void main(String[] args) {
        /*
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TestGUI().setVisible(true);
            }
        });
        */
        
        // default values
        int portNumber = 1500;
        String serverAddress = "localhost";
        String userName = "Anonymous";

		// depending of the number of arguments provided we fall through
        // name, port, address
        switch (args.length) {
            // > javac Client username portNumber serverAddr
            case 3:
                serverAddress = args[2];
            // > javac Client username portNumber
            case 2:
                try {
                    portNumber = Integer.parseInt(args[1]);
                } catch (Exception e) {
                    System.out.println("Invalid port number.");
                    System.out.println("Usage is: > java Client [username] [portNumber] [serverAddress]");
                    return;
                }
            // > javac Client username
            case 1:
                userName = args[0];
            // > java Client
            case 0:
                break;
            // invalid number of arguments
            default:
                System.out.println("Usage is: > java Client [username] [portNumber] {serverAddress]");
                return;
        }
        // create the Client object
        Client client = new Client(serverAddress, portNumber, userName);

        if (!client.start()) {
            return;
        }

        // wait for messages from user
        Scanner scan = new Scanner(System.in);
        // loop forever for message from the user
        while (true) {
            System.out.print("Select Group> ");
            String msg = scan.nextLine();
            if (msg.equalsIgnoreCase("LOGOUT")) {
                client.logout();
                break;
            } 
            else if (msg.equalsIgnoreCase("LISTGROUP")) {

            } 
            else if (client.listGroupID.indexOf(Integer.getInteger(msg)) > Integer.valueOf(-1)) {
                client.sendMessage(new ChatMessage(ChatMessage.ENTERGROUP, msg, 1));
                while (true) {
                    System.out.print("> ");
                    msg = scan.nextLine();
                    if (msg.equalsIgnoreCase("LOGOUT")) {
                        client.logout();
                        break;
                    }
                    else if (msg.equalsIgnoreCase("WHOISIN")) {
                        client.sendMessage(new ChatMessage(ChatMessage.WHOISIN, "", 1));
                    } 
                    else if (msg.equalsIgnoreCase("LISTGROUP")) {

                    } 
                    else if (msg.equalsIgnoreCase("EXIT")) {
                        client.sendMessage(new ChatMessage(ChatMessage.EXITGROUP, "", 1));
                        break;
                    } 
                    else {				// default to ordinary message
                        client.sendMessage(new ChatMessage(ChatMessage.MESSAGE, msg, 1));
                    }
                }
            }
        }
        // done disconnect
        client.disconnect();
    }

    /**
     * a class that waits for the message from the server and append them to the
     * JTextArea if we have a GUI or simply System.out.println() it in console
     * mode
     */
    class ListenFromServer extends Thread {

        public void run() {
            while (true) {
                try {
                    System.out.println("Start Receiving");
                    ChatMessage msg = (ChatMessage) sInput.readObject();
                    System.out.println(msg);
                    
                    // if console mode print the message and add back the prompt
                    if(msg.getType() == ChatMessage.MESSAGE || msg.getType() == ChatMessage.WHOISIN) {
                        displayPlus(msg.getMessage());
                    }
                    else if(msg.getType() == ChatMessage.JOINGROUP) {
                        if(msg.getGroupID() == 0) {
                            if (cg == null) {
                                System.out.println("No Group to join");      // println in console mode
                                System.out.print("> ");
                            } else {
                                cg.showMessageDialog("No Group to join");
                            }
                        }
                    }
                    /*
                    else if(msg.getType() == ChatMessage.LEAVEGROUP) {
                        if(msg.getGroupID() == 0) {
                            cg.showMessageDialog("No Group to leave");
                        }
                    }
                    else if(msg.getType() == ChatMessage.EXITGROUP) {
                        if(msg.getGroupID() == 0) {
                            cg.showMessageDialog("No Group to exit");
                        }
                    }
                    else if(msg.getType() == ChatMessage.ENTERGROUP) {
                        if(msg.getGroupID() == 0) {
                            cg.showMessageDialog("No Group to enter");
                        }
                    }
                    */
                    else if(msg.getType() == ChatMessage.CREATEGROUP) {
                        if(msg.getGroupID() > 0) {
                            listGroupID.add(msg.getGroupID());
                            listGroupName.add(msg.getMessage());
                        }
                        else {
                            if (cg == null) {
                                System.out.println("Repeaed Name");      // println in console mode
                                System.out.print("> ");
                            } else {
                                cg.showMessageDialog("Repeaed Name");
                            }
                        }
                    }
                    else {
                        if (cg == null) {
                            System.out.println("What the hell this type is!");
                            System.out.print("> ");
                        } else {
                            cg.showMessageDialog("There is something wrong!!!");
                        }
                    }
                    
                } catch (IOException e) {
                    display("Server has close the connection: " + e);
                    if (cg != null) {
                        cg.connectionFailed();
                    }
                    break;
                } // can't happen with a String object but need the catch anyhow
                catch (ClassNotFoundException e2) {
                }
            }
        }
    }
}
