
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.text.DefaultCaret;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LotK
 */
public class ClientGUI extends javax.swing.JFrame {
    
    Client client;
    boolean login;
    boolean isEnter;
    ButtonGroup groupRadio;
    ArrayList<JRadioButton> listGroup;
    
    /**
     * Creates new form ClientGUI
     */
    
    void setObjectEnable(boolean bl) {
        joinGroupButton.setEnabled(bl);
        leaveGroupButton.setEnabled(bl);
        enterGroupButton.setEnabled(bl);
        messageField.setEnabled(bl);
        createGroupButton.setEnabled(bl);
    }
    
    void setObjectIsEnter() {
        if(isEnter) {
            Component[] gc = listGroupPanel.getComponents();
            for(Component c : gc) {
                c.setEnabled(false);
            }
            listGroupPanel.setEnabled(false);
            
            //enterGroupButton.setEnabled(false);
            enterGroupButton.setText("Exit");
            //exitGroupButton.setEnabled(true);
            leaveGroupButton.setEnabled(true);
            sendButton.setEnabled(true);
            joinGroupButton.setEnabled(false);
            createGroupButton.setEnabled(false);
        }
        else {
            Component[] gc = listGroupPanel.getComponents();
            for(Component c : gc) {
                c.setEnabled(true);
            }
            listGroupPanel.setEnabled(true);
            
            //enterGroupButton.setEnabled(true);
            enterGroupButton.setText("Enter");
            //exitGroupButton.setEnabled(false);
            leaveGroupButton.setEnabled(false);
            sendButton.setEnabled(false);
            joinGroupButton.setEnabled(true);
            createGroupButton.setEnabled(true);
        }
    }
    
    
    String testRadio = "testRadio";
    public ClientGUI() {
        initComponents();
        
        this.setTitle("Simple LINE-like app");
        
        login = false;
        client = null;
        isEnter = false;
        setObjectEnable(false);
        sendButton.setEnabled(false);
        
        groupRadio = new ButtonGroup();
        listGroup = new ArrayList<>();
        listGroupPanel.setLayout(new BoxLayout(listGroupPanel, BoxLayout.Y_AXIS));
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
        jLabel1 = new javax.swing.JLabel();
        addressField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        portField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        joinGroupField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        createGroupField = new javax.swing.JTextField();
        createGroupButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        usernameField.setText("Anonymous");

        loginButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ON30.png"))); // NOI18N
        loginButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        jScrollPane2.setMinimumSize(new java.awt.Dimension(0, 0));

        javax.swing.GroupLayout listGroupPanelLayout = new javax.swing.GroupLayout(listGroupPanel);
        listGroupPanel.setLayout(listGroupPanelLayout);
        listGroupPanelLayout.setHorizontalGroup(
            listGroupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 204, Short.MAX_VALUE)
        );
        listGroupPanelLayout.setVerticalGroup(
            listGroupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
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

        joinGroupButton.setText("Join");
        joinGroupButton.setMaximumSize(new java.awt.Dimension(65, 23));
        joinGroupButton.setMinimumSize(new java.awt.Dimension(65, 23));
        joinGroupButton.setPreferredSize(new java.awt.Dimension(65, 23));
        joinGroupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                joinGroupButtonActionPerformed(evt);
            }
        });

        leaveGroupButton.setText("Leave");
        leaveGroupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leaveGroupButtonActionPerformed(evt);
            }
        });

        enterGroupButton.setText("Enter");
        enterGroupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterGroupButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Server:");

        addressField.setText("Localhost");

        jLabel2.setText("Port:");

        portField.setText("1500");

        jLabel3.setText("Username:");

        jLabel4.setText("group:");

        createGroupButton.setText("Create");
        createGroupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createGroupButtonActionPerformed(evt);
            }
        });

        jLabel5.setText("group:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(4, 4, 4)
                                .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                                .addComponent(loginButton))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(enterGroupButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(leaveGroupButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(4, 4, 4)
                            .addComponent(addressField, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(4, 4, 4)
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(portField, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(createGroupField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(joinGroupField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(createGroupButton, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(joinGroupButton, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(messageField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sendButton))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(loginButton))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(portField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(createGroupField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(createGroupButton))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(joinGroupField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(joinGroupButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enterGroupButton)
                    .addComponent(leaveGroupButton)
                    .addComponent(messageField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sendButton))
                .addContainerGap(15, Short.MAX_VALUE))
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

            client.listInGroup();           // show group if already is in
            jTextArea1.setText("");
            
            login = true;
            //loginButton.setText("Log Out");
            loginButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/OFF30.png")));
            setObjectEnable(true);
            leaveGroupButton.setEnabled(false);
            usernameField.setEnabled(false);
        }
        else {
            client.logout();
            
            // clear Radio button
            listGroupPanel.removeAll();
            listGroup.clear();
            while(groupRadio.getElements().hasMoreElements()) {
                groupRadio.remove(groupRadio.getElements().nextElement());
            }
            
            login = false;
            //loginButton.setText("Log In");
            loginButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/ON30.png")));
            setObjectEnable(false);
            sendButton.setEnabled(false);
            usernameField.setEnabled(true);
            
            jTextArea1.setText("");
        }
        
    }//GEN-LAST:event_loginButtonActionPerformed

    private void joinGroupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_joinGroupButtonActionPerformed
        // TODO add your handling code here:
        client.joinGroup(joinGroupField.getText());
        joinGroupField.setText("");
        
        //isEnter = true;
    }//GEN-LAST:event_joinGroupButtonActionPerformed

    private void leaveGroupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leaveGroupButtonActionPerformed
        // TODO add your handling code here:
        
        // find which Radio is selected
        JRadioButton c = null;
        for(int i=0 ; i<listGroup.size() ; i++) {
            if(listGroup.get(i).isSelected()) {
                c = listGroup.get(i);
                break;
            }
        }
        
        if(c != null) {
            int groupID = Integer.parseInt(c.getActionCommand());
            System.out.println("leave group ID: " + groupID + " " + c.getText());

            client.leaveGroup(groupID);

            if(listGroup.size() > 0) listGroup.get(0).setSelected(true);

            isEnter = false;
            setObjectIsEnter();
        }
        
        
        listGroupPanel.removeAll();
        listGroup.clear();
        while(groupRadio.getElements().hasMoreElements()) {
            groupRadio.remove(groupRadio.getElements().nextElement());
        }
        listGroupPanel.revalidate();
        client.listInGroup();
        
        jTextArea1.setText("");
    }//GEN-LAST:event_leaveGroupButtonActionPerformed

    private void enterGroupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterGroupButtonActionPerformed
        // TODO add your handling code here:
        if(isEnter == false){
            JRadioButton r = null;
            for(JRadioButton rb : listGroup) {
                if(rb.isSelected()) {
                    r = rb;
                    break;
                }
            }
            if(r != null) {
                int groupID = Integer.parseInt(groupRadio.getSelection().getActionCommand());
                client.enterGroup(groupID);


                isEnter = true;
                setObjectIsEnter();
            }
        }
        else{
            int groupID = Integer.parseInt(groupRadio.getSelection().getActionCommand());
            client.exitGroup(groupID);

            isEnter = false;
            setObjectIsEnter();
            
            jTextArea1.setText("");
        }
    }//GEN-LAST:event_enterGroupButtonActionPerformed

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
        createGroupField.setText("");
    }//GEN-LAST:event_createGroupButtonActionPerformed

    private void messageFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_messageFieldKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            sendButton.doClick();
        }
    }//GEN-LAST:event_messageFieldKeyPressed

    
    
    /**
     * HELPER FUNCTION
     */
    public void append(String str) {
        jTextArea1.append(str);
//        jTextArea1.setCaretPosition(jTextArea1.getDocument().getLength());
        DefaultCaret caret = (DefaultCaret)jTextArea1.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
    }
    
    public void showMessageDialog(String str) {
        JOptionPane.showMessageDialog(null, str);
    }
    
    public void addGroup(int groupID, String name) {
        JRadioButton c = new JRadioButton(name);
        c.setActionCommand(String.valueOf(groupID));
        System.out.println("ADD GROUP ID: " + groupID + ", GROUP NAME: " + name);
        listGroup.add(c);
        groupRadio.add(listGroup.get(listGroup.size()-1));
        listGroupPanel.add(listGroup.get(listGroup.size()-1));
        listGroup.get(listGroup.size()-1).setSelected(true);
        
        listGroupPanel.revalidate();
    }
    
    public void setIsEnter(boolean bl) {
        isEnter = bl;
        if(isEnter) {
            setObjectIsEnter();
            listGroupPanel.revalidate();
        }
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
        /*try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        */
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addressField;
    private javax.swing.JButton createGroupButton;
    private javax.swing.JTextField createGroupField;
    private javax.swing.JButton enterGroupButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
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
