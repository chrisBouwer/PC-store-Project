package sofdev.guis;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class UserAcc extends javax.swing.JFrame {
    static int userID;
    static String mem;
      public UserAcc(int userID, String mem) {
        initComponents();
        UserAcc.userID = userID;
        UserAcc.mem = mem;
        try {
            Statement stmt = con.con().createStatement();
            if(mem.equals("Staff")){
            rs = stmt.executeQuery("SELECT USERNAMES FROM STAFF WHERE STAFFID = "+userID+";");
            if(rs.next()){jMenu1.setText(rs.getString("usernames"));}
            }
            else {
                rs = stmt.executeQuery("SELECT USERNAMEU FROM USER WHERE USERID = "+userID+";");
            if(rs.next()){jMenu1.setText(rs.getString("usernameu"));}}
             
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Components could not be displayed.",
                            "Error", JOptionPane.ERROR_MESSAGE);
        }
        refresh();
    }
Conn con = new Conn();
ResultSet rs;

    private void refresh(){
    userAccTxtA.setText("");
    
    try{
        Statement stmt = con.con().createStatement();
        rs = stmt.executeQuery("SELECT * FROM USER;");
        userAccTxtA.append(String.format("%-20s%-20s%-20s%-20s%-40s%-50s%-30s%-30s\n","User ID",
                    "Name", "Surname","Cell Number","Email","Address","Username","Password"));
        userAccTxtA.append("_________________________________________________________________________________________________________________________\n");
        while(rs.next()){
            
            userAccTxtA.append(String.format("%-26d%-24s%-26s%-19s%-25s%-36s%-35s%-30s\n",rs.getInt("userID"),
                    rs.getString("uName"),rs.getString("surname"),rs.getString("cellNumber"),rs.getString("email"),
                    rs.getString("address"),rs.getString("userNameU"),rs.getString("passwordU")));
        }
    
    }
    catch(Exception e)
    {
    
       JOptionPane.showMessageDialog(rootPane, "Users could not be displayed.",
                            "Error", JOptionPane.ERROR_MESSAGE);
           System.out.println(e);
    }
    
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        userAccTxtA = new javax.swing.JTextArea();
        orderIDSpin = new javax.swing.JSpinner();
        searchBut = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        removeBut = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nameTxtFld = new javax.swing.JTextField();
        surnameTxtFld = new javax.swing.JTextField();
        cellTxtFld = new javax.swing.JTextField();
        emailTxtFld = new javax.swing.JTextField();
        addressTxtFld = new javax.swing.JTextField();
        usernameTxtFld = new javax.swing.JTextField();
        passwordTxtFld = new javax.swing.JTextField();
        updateBut = new javax.swing.JButton();
        addBut1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        userAccMenu = new javax.swing.JMenu();
        componentMItem = new javax.swing.JMenuItem();
        staffAccMItem = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        helpMItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        userAccTxtA.setColumns(20);
        userAccTxtA.setRows(5);
        jScrollPane2.setViewportView(userAccTxtA);

        searchBut.setText("Search");
        searchBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButActionPerformed(evt);
            }
        });

        jLabel3.setText("User ID");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setText("User Name");

        jLabel9.setText("Password");

        jLabel6.setText("Email");

        jLabel7.setText("Address");

        removeBut.setText("Remove");
        removeBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButActionPerformed(evt);
            }
        });

        jLabel5.setText("Cell Number");

        jLabel4.setText("Surname");

        jLabel2.setText("Name");

        updateBut.setText("Update");
        updateBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButActionPerformed(evt);
            }
        });

        addBut1.setText("Add");
        addBut1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBut1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel8)
                    .addComponent(nameTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(surnameTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(cellTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(emailTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(addressTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                                .addComponent(updateBut, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(removeBut, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(addBut1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(37, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(usernameTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(passwordTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(surnameTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cellTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addressTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(updateBut)
                            .addComponent(removeBut)
                            .addComponent(addBut1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sofdev/guis/user_icon.png"))); // NOI18N
        jMenu1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuBar1.add(jMenu1);

        userAccMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sofdev/guis/menu_icon.png"))); // NOI18N
        userAccMenu.setText("Menu");

        componentMItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sofdev/guis/select_icon.png"))); // NOI18N
        componentMItem.setText("Components Edit");
        componentMItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                componentMItemActionPerformed(evt);
            }
        });
        userAccMenu.add(componentMItem);

        staffAccMItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sofdev/guis/controls_icon.png"))); // NOI18N
        staffAccMItem.setText("Staff Accounts");
        staffAccMItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staffAccMItemActionPerformed(evt);
            }
        });
        userAccMenu.add(staffAccMItem);

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sofdev/guis/order_icon.png"))); // NOI18N
        jMenuItem1.setText("Orders");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        userAccMenu.add(jMenuItem1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sofdev/guis/home_icon.png"))); // NOI18N
        jMenuItem2.setText("Log out");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        userAccMenu.add(jMenuItem2);

        helpMItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sofdev/guis/help_icon.png"))); // NOI18N
        helpMItem.setText("Help");
        userAccMenu.add(helpMItem);

        jMenuBar1.add(userAccMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(orderIDSpin, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(searchBut, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(orderIDSpin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addComponent(searchBut))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addBut1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBut1ActionPerformed
     try {
             Statement stmt = con.con().createStatement();
             int usID = Integer.parseInt(orderIDSpin.getValue().toString());
             
            stmt.executeUpdate("INSERT INTO USER (UNAME,SURNAME,CELLNUMBER,EMAIL,ADDRESS,USERNAMEU,PASSWORDU)"
                    + "VALUES ('"+nameTxtFld.getText()+"','"+ surnameTxtFld.getText()+"','"+cellTxtFld.getText()
                    +"','"+ emailTxtFld.getText() +"','"+ addressTxtFld.getText()+"','"+ usernameTxtFld.getText() 
                    +"','"+ passwordTxtFld.getText()+"');");
             
         } catch (SQLException ex) {
           JOptionPane.showMessageDialog(rootPane, "Add unsuccessful.",
                            "Error", JOptionPane.ERROR_MESSAGE);
             System.out.println(ex);
         }
     refresh();
    }//GEN-LAST:event_addBut1ActionPerformed

    private void searchButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButActionPerformed
                try {
            
             Statement stmt = con.con().createStatement();
             int usID = Integer.parseInt(orderIDSpin.getValue().toString());
             
            rs = stmt.executeQuery("SELECT * FROM USER WHERE USERID = "+usID+";");
             
              if(rs.next()){
              nameTxtFld.setText(rs.getString("uname"));
              surnameTxtFld.setText(rs.getString("surname"));
              cellTxtFld.setText(rs.getString("cellnumber"));
              emailTxtFld.setText(rs.getString("email"));
              addressTxtFld.setText(rs.getString("address"));
              usernameTxtFld.setText(rs.getString("usernameu"));
              passwordTxtFld.setText(rs.getString("passwordu"));
                
              }
             
         } catch (SQLException ex) {
           JOptionPane.showMessageDialog(rootPane, "Search unsuccessful.",
                            "Error", JOptionPane.ERROR_MESSAGE);
             System.out.println(ex);
         }
    }//GEN-LAST:event_searchButActionPerformed

    private void removeButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButActionPerformed
         try{
             int conf= JOptionPane.showConfirmDialog(rootPane,"Are you sure you want to remove this user?","Confirm",JOptionPane.OK_OPTION,JOptionPane.NO_OPTION);
         System.out.println(conf);
         if(conf==0){
        Statement stmt = con.con().createStatement();
        int usID = Integer.parseInt(orderIDSpin.getValue().toString());
        stmt.executeUpdate("DELETE FROM USER WHERE USERID = "+usID+";");
    }
         }
    catch(SQLException | NumberFormatException e){
    JOptionPane.showMessageDialog(rootPane, "User could not be deleted.",
                            "Error", JOptionPane.ERROR_MESSAGE);
           System.out.println(e);
    }
    refresh();
    }//GEN-LAST:event_removeButActionPerformed

    private void updateButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButActionPerformed
          try{ Statement stmt = con.con().createStatement();
        int usID = Integer.parseInt(orderIDSpin.getValue().toString());
        stmt.executeUpdate("UPDATE USER SET UNAME = '"+  nameTxtFld.getText()
                +"', SURNAME = '"+surnameTxtFld.getText() +"', CELLNUMBER = '"+cellTxtFld.getText()+
                "', EMAIL = '"+ emailTxtFld.getText() +"', ADDRESS = '"+ addressTxtFld.getText()+"', USERNAMEU = '"
                +usernameTxtFld.getText() +"', PASSWORDU = '"+passwordTxtFld.getText()+"' WHERE USERID ="+usID+";");}
         
       catch(NumberFormatException | SQLException e){
       JOptionPane.showMessageDialog(rootPane, "User could not be updated.",
                            "Error", JOptionPane.ERROR_MESSAGE);
           System.out.println(e);
       }
       refresh();
    }//GEN-LAST:event_updateButActionPerformed

    private void componentMItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_componentMItemActionPerformed
         java.awt.EventQueue.invokeLater(() -> {
            new ComponentEdit(userID,mem).setVisible(true);
        });
       UserAcc.this.setVisible(false);
    }//GEN-LAST:event_componentMItemActionPerformed

    private void staffAccMItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staffAccMItemActionPerformed
          java.awt.EventQueue.invokeLater(() -> {
            new StaffAcc(userID,mem).setVisible(true);
        });
       UserAcc.this.setVisible(false);
    }//GEN-LAST:event_staffAccMItemActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
         java.awt.EventQueue.invokeLater(() -> {
            new Orders(userID,mem).setVisible(true);
        });
       UserAcc.this.setVisible(false);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
       java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
       UserAcc.this.setVisible(false);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBut1;
    private javax.swing.JTextField addressTxtFld;
    private javax.swing.JTextField cellTxtFld;
    private javax.swing.JMenuItem componentMItem;
    private javax.swing.JTextField emailTxtFld;
    private javax.swing.JMenuItem helpMItem;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
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
    private javax.swing.JSpinner orderIDSpin;
    private javax.swing.JTextField passwordTxtFld;
    private javax.swing.JButton removeBut;
    private javax.swing.JButton searchBut;
    private javax.swing.JMenuItem staffAccMItem;
    private javax.swing.JTextField surnameTxtFld;
    private javax.swing.JButton updateBut;
    private javax.swing.JMenu userAccMenu;
    private javax.swing.JTextArea userAccTxtA;
    private javax.swing.JTextField usernameTxtFld;
    // End of variables declaration//GEN-END:variables
}
