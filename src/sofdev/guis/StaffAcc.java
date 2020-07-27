package sofdev.guis;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class StaffAcc extends javax.swing.JFrame {
 Conn con = new Conn();
 static int userID;
 static String mem;
 ResultSet rs;
 
    public StaffAcc(int userID, String mem) {
        initComponents();
         StaffAcc.userID = userID;
         StaffAcc.mem = mem;
        
        displayTxtArea();
        try {
            Statement stmt = con.con().createStatement();
            if(mem.equals("Staff")){
            rs = stmt.executeQuery("SELECT USERNAMES FROM STAFF WHERE STAFFID = "+userID+";");
            if(rs.next()){jMenu1.setText(rs.getString("usernames"));System.out.println(rs.getString("usernames"));}
                System.out.println("s");
            }
            else {
                rs = stmt.executeQuery("SELECT USERNAMEU FROM USER WHERE USERID = "+userID+";");
            if(rs.next()){jMenu1.setText(rs.getString("usernameu"));}}
             
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Components could not be displayed.",
                            "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
private void displayTxtArea() {
        staffTxtA.setText("");
        String sql = "SELECT staffID, sName, surnames, title, authority, userNameS, passwordS FROM Staff;";
        try {

            Statement stmt = con.con().createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            
            staffTxtA.append(String.format("%-16s%-30s%-30s%-30s%-30s%-30s%-30s\n", "Staff ID", "Name", "Surname",
                    "Title", "Authority", "User Name", "Password"));

            while (rs.next()) {
                staffTxtA.append(String.format("%-30d%-34s%-34s%-48s%-30b%-34s%-34s\n", rs.getInt("staffID"), rs.getString("sName"),
                        rs.getString("surnameS"), rs.getString("title"), rs.getBoolean("authority"), rs.getString("userNameS"), rs.getString("passwordS")));
            }
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Cannot connect to database",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        staffTxtA = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        removeBut = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        updateBut = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        nameTxtFld = new javax.swing.JTextField();
        surnameTxtFld = new javax.swing.JTextField();
        usernameTxtFld = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        titleTxtFld = new javax.swing.JTextField();
        passwordTxtFld = new javax.swing.JTextField();
        addBut1 = new javax.swing.JButton();
        authorityCBox = new javax.swing.JComboBox<>();
        staffIDSpin = new javax.swing.JSpinner();
        searchBut = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        staffAccMenu = new javax.swing.JMenu();
        userAccMItem1 = new javax.swing.JMenuItem();
        componentMItem1 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        helpMItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        staffTxtA.setColumns(20);
        staffTxtA.setRows(5);
        jScrollPane2.setViewportView(staffTxtA);

        jLabel3.setText("Staff ID");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setText("User Name");

        jLabel9.setText("Password");

        jLabel7.setText("Authority");

        removeBut.setText("Remove");
        removeBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButActionPerformed(evt);
            }
        });

        jLabel4.setText("Surname");

        updateBut.setText("Update");
        updateBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButActionPerformed(evt);
            }
        });

        jLabel2.setText("Name");

        jLabel10.setText("Title");

        addBut1.setText("Add");
        addBut1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBut1ActionPerformed(evt);
            }
        });

        authorityCBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yes", "No" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(nameTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(surnameTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(titleTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(authorityCBox, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usernameTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(passwordTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 11, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(101, 101, 101)
                                .addComponent(jLabel4)
                                .addGap(86, 86, 86)
                                .addComponent(jLabel10))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(254, 254, 254)
                                .addComponent(updateBut, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(removeBut, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(addBut1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(211, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel10)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(surnameTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titleTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(authorityCBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(removeBut)
                    .addComponent(updateBut)
                    .addComponent(addBut1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        searchBut.setText("Search");
        searchBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButActionPerformed(evt);
            }
        });

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sofdev/guis/user_icon.png"))); // NOI18N
        jMenu1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuBar1.add(jMenu1);

        staffAccMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sofdev/guis/menu_icon.png"))); // NOI18N
        staffAccMenu.setText("Menu");

        userAccMItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sofdev/guis/user_icon.png"))); // NOI18N
        userAccMItem1.setText("User Accounts");
        userAccMItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userAccMItem1ActionPerformed(evt);
            }
        });
        staffAccMenu.add(userAccMItem1);

        componentMItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sofdev/guis/select_icon.png"))); // NOI18N
        componentMItem1.setText("Components Edit");
        componentMItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                componentMItem1ActionPerformed(evt);
            }
        });
        staffAccMenu.add(componentMItem1);

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sofdev/guis/order_icon.png"))); // NOI18N
        jMenuItem1.setText("Orders");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        staffAccMenu.add(jMenuItem1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sofdev/guis/home_icon.png"))); // NOI18N
        jMenuItem2.setText("Log out");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        staffAccMenu.add(jMenuItem2);

        helpMItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sofdev/guis/help_icon.png"))); // NOI18N
        helpMItem.setText("Help");
        staffAccMenu.add(helpMItem);

        jMenuBar1.add(staffAccMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 919, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(searchBut, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(staffIDSpin, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(staffIDSpin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(searchBut))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButActionPerformed
         try {
            Statement stmt = con.con().createStatement();
            int id = Integer.parseInt(staffIDSpin.getValue().toString());
            String rsID = "";
             rs = stmt.executeQuery("SELECT staffID FROM Staff WHERE staffID = " + id);

            if (rs.next()) {
                rsID += rs.getInt("staffID");
            }

            if (rsID.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Staff with that ID not found!",
                        "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                ResultSet rs2 = stmt.executeQuery("SELECT * FROM Staff WHERE staffID = " + id);
                if (rs2.next()) {
                    nameTxtFld.setText(rs2.getString("sName"));
                    surnameTxtFld.setText(rs2.getString("surnameS"));
                    titleTxtFld.setText(rs2.getString("title"));
                    if (rs2.getBoolean("authority")) {
                        authorityCBox.setSelectedIndex(0);
                    } else {
                        authorityCBox.setSelectedIndex(1);
                    }
                    usernameTxtFld.setText(rs2.getString("userNameS"));
                    passwordTxtFld.setText(rs2.getString("passwordS"));
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Cannot connect to database",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_searchButActionPerformed

    private void updateButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButActionPerformed
           try {
            Statement stmt = con.con().createStatement();
            int staffID = Integer.parseInt(staffIDSpin.getValue().toString());
            boolean auth;
            auth = authorityCBox.getSelectedIndex() == 0;
            stmt.executeUpdate("UPDATE staff SET sName = '" + nameTxtFld.getText()
                    + "', surnameS = '" + surnameTxtFld.getText() + "', title = '" + titleTxtFld.getText()
                    + "', authority = " + auth + ", userNameS = '" + usernameTxtFld.getText()
                    + "', passwordS = '" + passwordTxtFld.getText() + "' WHERE staffID = " + staffID + ";");
        } catch (NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Staff could not be updated.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
        displayTxtArea();
    }//GEN-LAST:event_updateButActionPerformed

    private void removeButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButActionPerformed
         try {
             int conf= JOptionPane.showConfirmDialog(rootPane,"Are you sure you want to remove this user?","Confirm",JOptionPane.OK_OPTION,JOptionPane.NO_OPTION);
         System.out.println(conf);
         if(conf==0){
            Statement stmt = con.con().createStatement();
            int staffID = Integer.parseInt(staffIDSpin.getValue().toString());
            stmt.executeUpdate("DELETE FROM staff WHERE staffID = " + staffID + ";");
         }
        } catch (SQLException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Component could not be deleted.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
        displayTxtArea();
    }//GEN-LAST:event_removeButActionPerformed

    private void addBut1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBut1ActionPerformed
        Statement stmt;
        try {
            stmt = con.con().createStatement();
            boolean auth;
            if (authorityCBox.getSelectedIndex() == 0) {
                auth = true;
            } else {
                auth = false;
            }
            stmt.executeUpdate("INSERT INTO staff (sName,surnameS,title,authority,userNameS,passwordS) VALUES('" + nameTxtFld.getText() + "','"
                + surnameTxtFld.getText() + "','" + titleTxtFld.getText() + "','" + auth + "','" + usernameTxtFld.getText() + "','"
                + passwordTxtFld.getText() + "');");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Component could not be added.",
                "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println(ex);
        }
        displayTxtArea();
    }//GEN-LAST:event_addBut1ActionPerformed

    private void userAccMItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userAccMItem1ActionPerformed
         StaffAcc.this.setVisible(false);
        java.awt.EventQueue.invokeLater(() -> {
            new UserAcc(userID,mem).setVisible(true);
        });
    }//GEN-LAST:event_userAccMItem1ActionPerformed

    private void componentMItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_componentMItem1ActionPerformed
        StaffAcc.this.setVisible(false);
        java.awt.EventQueue.invokeLater(() -> {
            new ComponentEdit(userID,mem).setVisible(true);
        });
    }//GEN-LAST:event_componentMItem1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
         StaffAcc.this.setVisible(false);
        java.awt.EventQueue.invokeLater(() -> {
            new Orders(userID,mem).setVisible(true);
        });
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
         java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
       StaffAcc.this.setVisible(false);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBut1;
    private javax.swing.JComboBox<String> authorityCBox;
    private javax.swing.JMenuItem componentMItem1;
    private javax.swing.JMenuItem helpMItem;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nameTxtFld;
    private javax.swing.JTextField passwordTxtFld;
    private javax.swing.JButton removeBut;
    private javax.swing.JButton searchBut;
    private javax.swing.JMenu staffAccMenu;
    private javax.swing.JSpinner staffIDSpin;
    private javax.swing.JTextArea staffTxtA;
    private javax.swing.JTextField surnameTxtFld;
    private javax.swing.JTextField titleTxtFld;
    private javax.swing.JButton updateBut;
    private javax.swing.JMenuItem userAccMItem1;
    private javax.swing.JTextField usernameTxtFld;
    // End of variables declaration//GEN-END:variables
}
