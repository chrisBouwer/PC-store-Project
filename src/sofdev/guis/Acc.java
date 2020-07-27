package sofdev.guis;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Acc extends javax.swing.JFrame {
 static ArrayList<Integer> compList = new ArrayList<>();
      static int userID;
      static String mem;
      ResultSet rs;
       Conn con = new Conn();
       
    public Acc(ArrayList<Integer> compList, int userID,String mem) {
        Acc.compList =  compList;
        Acc.userID = userID;
        Acc.mem = mem;
        initComponents();
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
        try {
           
             Statement stmt = con.con().createStatement();
            
             rs = stmt.executeQuery("SELECT * FROM USER WHERE USERID = "+Acc.userID+";");
             
              if(rs.next()){
              jTextField1.setText(rs.getString("uname"));
              jTextField3.setText(rs.getString("surname"));
              jTextField4.setText(rs.getString("cellnumber"));
              jTextField5.setText(rs.getString("email"));
              jTextField6.setText(rs.getString("address"));
              jTextField7.setText(rs.getString("usernameu"));
              jTextField8.setText(rs.getString("passwordu"));
                
              }
             
         } catch (SQLException ex) {
           JOptionPane.showMessageDialog(rootPane, "Couldn't display account details.",
                            "Error", JOptionPane.ERROR_MESSAGE);
             System.out.println(ex);
         }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem2 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        updateBut = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        accMenu = new javax.swing.JMenu();
        shoppingMItem1 = new javax.swing.JMenuItem();
        componentMItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        helpMItem = new javax.swing.JMenuItem();

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Name");

        jLabel2.setText("Surname");

        jLabel3.setText("Cellphone");

        jLabel4.setText("Email");

        jLabel5.setText("Address");

        updateBut.setText("Update");
        updateBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButActionPerformed(evt);
            }
        });

        jLabel6.setText("User Name");

        jLabel7.setText("Password");

        jLabel8.setText("Confirm Password");

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sofdev/guis/user_icon.png"))); // NOI18N
        jMenu1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuBar1.add(jMenu1);

        accMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sofdev/guis/menu_icon.png"))); // NOI18N
        accMenu.setText("Menu");

        shoppingMItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sofdev/guis/cart_icon.png"))); // NOI18N
        shoppingMItem1.setText("Shopping Cart");
        shoppingMItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shoppingMItem1ActionPerformed(evt);
            }
        });
        accMenu.add(shoppingMItem1);

        componentMItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sofdev/guis/select_icon.png"))); // NOI18N
        componentMItem1.setText("Component Select");
        componentMItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                componentMItem1ActionPerformed(evt);
            }
        });
        accMenu.add(componentMItem1);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sofdev/guis/home_icon.png"))); // NOI18N
        jMenuItem3.setText("Log out");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        accMenu.add(jMenuItem3);

        helpMItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sofdev/guis/help_icon.png"))); // NOI18N
        helpMItem.setText("Help");
        accMenu.add(helpMItem);

        jMenuBar1.add(accMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(updateBut)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(updateBut)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void shoppingMItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shoppingMItem1ActionPerformed
        
        Acc.this.setVisible(false);
        java.awt.EventQueue.invokeLater(() -> {
            new ShoppingCart(compList,userID,mem).setVisible(true);
        });
    }//GEN-LAST:event_shoppingMItem1ActionPerformed

    private void componentMItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_componentMItem1ActionPerformed
       Acc.this.setVisible(false);
        java.awt.EventQueue.invokeLater(() -> {
            new Components(compList,userID,mem).setVisible(true);
        });
    }//GEN-LAST:event_componentMItem1ActionPerformed

    private void updateButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButActionPerformed
       if (jTextField8.getText().equals(jTextField9.getText()) && !jTextField8.getText().equals("")) {
            try {
                Conn con = new Conn();
                Statement stmt = con.con().createStatement();
                
                    stmt.executeUpdate("UPDATE User SET uName = '" + jTextField1.getText()
                            + "', surname = '" + jTextField3.getText() + "', cellNumber = '" + jTextField4.getText()
                            + "', email = '" + jTextField5.getText() + "', address = '" + jTextField6.getText()
                            + "', userNameU = '" + jTextField7.getText() + "', passwordU = '" + jTextField8.getText()
                            + "' WHERE userID = " + userID + ";");
                    
                    JOptionPane.showMessageDialog(null, "User has been updated!");
               
                

            } catch (NumberFormatException | SQLException e) {
                JOptionPane.showMessageDialog(null, "User could not be updated.",
                        "Error", JOptionPane.ERROR_MESSAGE);
                System.out.println(e);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Passwords must match!",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_updateButActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
         java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
       Acc.this.setVisible(false);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu accMenu;
    private javax.swing.JMenuItem componentMItem1;
    private javax.swing.JMenuItem helpMItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JMenuItem shoppingMItem1;
    private javax.swing.JButton updateBut;
    // End of variables declaration//GEN-END:variables
}
