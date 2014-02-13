
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LotK
 */
public class TestGUI extends javax.swing.JFrame {
    
    Client client;
    boolean login;
    boolean isEnter;
    ButtonGroup groupRadio;
    ArrayList<JRadioButton> listGroup;
    
    /**
     * Creates new form TestGUI
     */
    
    void setObjectEnable(boolean bl) {
        joinGroupButton.setEnabled(bl);
        leaveGroupButton.setEnabled(bl);
        enterGroupButton.setEnabled(bl);
        exitGroupButton.setEnabled(bl);
        messageField.setEnabled(bl);
        createGroupButton.setEnabled(bl);
    }
    String testRadio = "testRadio";
    public TestGUI() {
        initComponents();
        
        this.setTitle("Chat");
        
        login = false;
        client = null;
        isEnter = false;
        setObjectEnable(false);
        sendButton.setEnabled(false);
        
        groupRadio = new ButtonGroup();
        listGroup = new ArrayList<>();
        listGroupPanel.setLayout(new BoxLayout(listGroupPanel, BoxLayout.Y_AXIS));
        
        // test Radio
        /*
        for(int i=0 ; i<10 ; i++) {
            listGroup.add(new JRadioButton(i+""));
            groupRadio.add(listGroup.get(listGroup.size()-1));
            listGroupPanel.add(listGroup.get(listGroup.size()-1));
        }*/
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        usernameField = new javax.swing.JTextField();
        loginButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listGroupPanel = new javax.swing.JPanel();
        messageField = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        sendButton = new javax.swing.JButton();
        joinGroupButton = new javax.swing.JButton();
        leaveGroupButton = new javax.swing.JButton();
        enterGroupButton = new javax.swing.JButton();
        exitGroupButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        addressField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        portField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        joinGroupField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        createGroupField = new javax.swing.JTextField();
        createGroupButton = new javax.swing.JButton();
        LG = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        usernameField.setText("Anonymous");

        loginButton.setText("Log In");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout listGroupPanelLayout = new javax.swing.GroupLayout(listGroupPanel);
        listGroupPanel.setLayout(listGroupPanelLayout);
        listGroupPanelLayout.setHorizontalGroup(
            listGroupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 148, Short.MAX_VALUE)
        );
        listGroupPanelLayout.setVerticalGroup(
            listGroupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 173, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(listGroupPanel);

        messageField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                messageFieldKeyPressed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        sendButton.setText("Send");
        sendButton.setName("sendButton"); // NOI18N
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });

        joinGroupButton.setText("Join Group");
        joinGroupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                joinGroupButtonActionPerformed(evt);
            }
        });

        leaveGroupButton.setText("Leave Group");
        leaveGroupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leaveGroupButtonActionPerformed(evt);
            }
        });

        enterGroupButton.setText("Enter Group");
        enterGroupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterGroupButtonActionPerformed(evt);
            }
        });

        exitGroupButton.setText("Exit Group");
        exitGroupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitGroupButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Server address:");

        addressField.setText("localhost");

        jLabel2.setText("Port:");

        portField.setText("1500");

        jLabel3.setText("User Name:");

        jLabel4.setText("group:");

        jLabel5.setText("jLabel5");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(75, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addContainerGap())
        );

        createGroupButton.setText("Create Group");
        createGroupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createGroupButtonActionPerformed(evt);
            }
        });

        LG.setText("List Group???");
        LG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LGActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(joinGroupField, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(joinGroupButton)
                                                .addGap(43, 43, 43)))
                                        .addGap(106, 106, 106))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(createGroupField, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(createGroupButton, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                        .addGap(82, 82, 82)))
                                .addComponent(leaveGroupButton))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(addressField, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel2))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(loginButton)
                                    .addComponent(portField, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(enterGroupButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(exitGroupButton, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(messageField, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(sendButton))
                                    .addComponent(jScrollPane3)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addComponent(LG)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(addressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(portField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(loginButton)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(joinGroupField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(joinGroupButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(enterGroupButton)
                            .addComponent(exitGroupButton))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(messageField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sendButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(leaveGroupButton)
                    .addComponent(createGroupField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(createGroupButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LG)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 
    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        // TODO add your handling code here:
        if(!login) {
            try {
            client = new Client(addressField.getText(), Integer.parseInt(portField.getText()), 
                    usernameField.getText(), this);
            }
            catch (Exception e) {
                System.out.println(e);
            }
            if (!client.start()) {
                showMessageDialog("Error to Start");
                return;
            }

            client.listInGroup();
            jTextArea1.setText("");
            // load list group
            
            
            login = true;
            loginButton.setText("Log Out");
            setObjectEnable(true);
            exitGroupButton.setEnabled(false);
            leaveGroupButton.setEnabled(false);
        }
        else {
            client.logout();
            
            listGroupPanel.removeAll();
            listGroup.clear();
            
            login = false;
            loginButton.setText("Log In");
            setObjectEnable(false);
            sendButton.setEnabled(false);
        }
        
    }//GEN-LAST:event_loginButtonActionPerformed

    private void joinGroupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_joinGroupButtonActionPerformed
        // TODO add your handling code here:
        client.joinGroup(joinGroupField.getText());
        
        enterGroupButton.setEnabled(false);
        exitGroupButton.setEnabled(true);
        leaveGroupButton.setEnabled(true);
        sendButton.setEnabled(true);
    }//GEN-LAST:event_joinGroupButtonActionPerformed

    private void leaveGroupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leaveGroupButtonActionPerformed
        // TODO add your handling code here:
        int groupID = Integer.parseInt(groupRadio.getSelection().getActionCommand());
        client.leaveGroup(groupID);
        
        if(listGroup.size() > 0) listGroup.get(0).setSelected(true);
        
        isEnter = false;
        enterGroupButton.setEnabled(true);
        exitGroupButton.setEnabled(false);
        leaveGroupButton.setEnabled(false);
        sendButton.setEnabled(false);
    }//GEN-LAST:event_leaveGroupButtonActionPerformed

    private void enterGroupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterGroupButtonActionPerformed
        // TODO add your handling code here:
        
        int groupID = Integer.parseInt(groupRadio.getSelection().getActionCommand());
        client.enterGroup(groupID);
        
        
        isEnter = true;
        enterGroupButton.setEnabled(false);
        exitGroupButton.setEnabled(true);
        leaveGroupButton.setEnabled(true);
        sendButton.setEnabled(true);
    }//GEN-LAST:event_enterGroupButtonActionPerformed

    private void exitGroupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitGroupButtonActionPerformed
        // TODO add your handling code here:
        int groupID = Integer.parseInt(groupRadio.getSelection().getActionCommand());
        client.exitGroup(groupID);
        
        isEnter = false;
        enterGroupButton.setEnabled(true);
        exitGroupButton.setEnabled(false);
        leaveGroupButton.setEnabled(false);
        sendButton.setEnabled(false);
    }//GEN-LAST:event_exitGroupButtonActionPerformed

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
        // TODO add your handling code here:
        int groupID = Integer.parseInt(groupRadio.getSelection().getActionCommand());
        client.message(messageField.getText(), groupID);
        
        messageField.setText("");
    }//GEN-LAST:event_sendButtonActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        if(login) 
            client.logout();
    }//GEN-LAST:event_formWindowClosing

    private void createGroupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createGroupButtonActionPerformed
        // TODO add your handling code here:
        client.createGroup(createGroupField.getText());
        
        enterGroupButton.setEnabled(true);
        exitGroupButton.setEnabled(false);
        leaveGroupButton.setEnabled(false);
        sendButton.setEnabled(false);
    }//GEN-LAST:event_createGroupButtonActionPerformed

    private void messageFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_messageFieldKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            sendButton.doClick();
        }
    }//GEN-LAST:event_messageFieldKeyPressed

    private void LGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LGActionPerformed
        // TODO add your handling code here:
        client.listInGroup();
    }//GEN-LAST:event_LGActionPerformed

    
    
    /**
     * HELPER FUNCTION
     */
    public void append(String str) {
        jTextArea1.append(str);
    }
    
    public void showMessageDialog(String str) {
        JOptionPane.showMessageDialog(null, str);
    }
    
    public void addGroup(int groupID, String name) {
        JRadioButton c = new JRadioButton(name);
        c.setActionCommand(String.valueOf(groupID));
        System.out.println("TEST ADD GROUP " + groupID + " " + name);
        listGroup.add(c);
        groupRadio.add(listGroup.get(listGroup.size()-1));
        listGroupPanel.add(listGroup.get(listGroup.size()-1));
        listGroup.get(listGroup.size()-1).setSelected(true);
        
        listGroupPanel.revalidate();
        sendButton.setEnabled(true);
    }
    
    void connectionFailed() {
        /*
        login.setEnabled(true);
        logout.setEnabled(false);
        whoIsIn.setEnabled(false);
        label.setText("Enter your username below");
        tf.setText("Anonymous");
        // reset port number and host name as a construction time
        tfPort.setText("" + defaultPort);
        tfServer.setText(defaultHost);
        // let the user change them
        tfServer.setEditable(false);
        tfPort.setEditable(false);
        // don't react to a <CR> after the username
        tf.removeActionListener(this);
        connected = false;
        */
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TestGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TestGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TestGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TestGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TestGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LG;
    private javax.swing.JTextField addressField;
    private javax.swing.JButton createGroupButton;
    private javax.swing.JTextField createGroupField;
    private javax.swing.JButton enterGroupButton;
    private javax.swing.JButton exitGroupButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton joinGroupButton;
    private javax.swing.JTextField joinGroupField;
    private javax.swing.JButton leaveGroupButton;
    private javax.swing.JPanel listGroupPanel;
    private javax.swing.JButton loginButton;
    private javax.swing.JTextField messageField;
    private javax.swing.JTextField portField;
    private javax.swing.JButton sendButton;
    private javax.swing.JTextField usernameField;
    // End of variables declaration//GEN-END:variables
}
