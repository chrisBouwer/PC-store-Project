package sofdev.guis;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class Orders extends javax.swing.JFrame {
    
    Conn con = new Conn();
     ResultSet rs;
     ResultSet rs2;
     static int userID;
     static String mem;
    public Orders(int userID,String mem) {
        initComponents();
        Orders.userID = userID;
        Orders.mem = mem;
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
    
    private void refresh(){
     ordersTxtA.setText("");
       try {
            Statement stmt = con.con().createStatement();
            rs = stmt.executeQuery("SELECT * FROM order;");
            
            while (rs.next()) {
                
                int oID = rs.getInt("OrderID");
                Date dateO =rs.getDate("dateO");
                double amount = rs.getDouble("totalAmount");
                int userID=rs.getInt("userID");
                
                rs2 = stmt.executeQuery("SELECT * FROM COMPONENT,SHOPPINGLIST WHERE SHOPPINGLIST.ORDERID ='" +oID
                        +"' AND COMPONENT.COMPONENTID = SHOPPINGLIST.COMPONENTID;");
               
                ordersTxtA.append(String.format("%-30s%-50s%-50s%-50s\n\n","Order ID: "+oID,
                        "Date of Order: "+dateO,"Total Amount: R"+amount, "User ID: "+userID));
                      
                ordersTxtA.append(String.format("%-16s%-26s%-32s%-30s%-30s%-30s\n","Component ID", "Category", 
                        "Type","Brand","Component Name","Price"));
               
                while(rs2.next()){
                                       
                    ordersTxtA.append(String.format("%-30d%-30s%-30s%-40s%-50sR%-30.2f\n",rs2.getInt("componentID"),
                    rs2.getString("category"),rs2.getString("type"),
                        rs2.getString("brand"), rs2.getString("compName"), rs2.getDouble("price")));
                }
                
                     ordersTxtA.append("__________________________________________________________________________________________________________\n");
                    
                }
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(rootPane, "Orders could not be displayed.",
                            "Error", JOptionPane.ERROR_MESSAGE);
           System.out.println(ex);
                    
        }
        
    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        ordersTxtA = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        updateBut1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        orderIDSpin = new javax.swing.JSpinner();
        updateBut2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        deleteCompBut = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        compIDSpin = new javax.swing.JSpinner();
        deleteOrderBut = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        ordersMenu = new javax.swing.JMenu();
        userAccMItem1 = new javax.swing.JMenuItem();
        componentMItem1 = new javax.swing.JMenuItem();
        staffAccMItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        helpMItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ordersTxtA.setColumns(20);
        ordersTxtA.setRows(5);
        jScrollPane2.setViewportView(ordersTxtA);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        updateBut1.setText("Search");
        updateBut1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBut1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Order ID");

        updateBut2.setText("Show Orders");
        updateBut2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBut2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(updateBut2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(orderIDSpin, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(updateBut1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(orderIDSpin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(updateBut1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(updateBut2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        deleteCompBut.setText("Delete Component");
        deleteCompBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteCompButActionPerformed(evt);
            }
        });

        jLabel3.setText("Component ID");

        deleteOrderBut.setText("Delete Order");
        deleteOrderBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteOrderButActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(compIDSpin, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deleteOrderBut, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(deleteCompBut)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(compIDSpin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteOrderBut))
                .addGap(18, 18, 18)
                .addComponent(deleteCompBut)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sofdev/guis/user_icon.png"))); // NOI18N
        jMenu1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuBar1.add(jMenu1);

        ordersMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sofdev/guis/menu_icon.png"))); // NOI18N
        ordersMenu.setText("Menu");

        userAccMItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sofdev/guis/user_icon.png"))); // NOI18N
        userAccMItem1.setText("User Accounts");
        userAccMItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userAccMItem1ActionPerformed(evt);
            }
        });
        ordersMenu.add(userAccMItem1);

        componentMItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sofdev/guis/select_icon.png"))); // NOI18N
        componentMItem1.setText("Components Edit");
        componentMItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                componentMItem1ActionPerformed(evt);
            }
        });
        ordersMenu.add(componentMItem1);

        staffAccMItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sofdev/guis/controls_icon.png"))); // NOI18N
        staffAccMItem1.setText("Staff Accounts");
        staffAccMItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staffAccMItem1ActionPerformed(evt);
            }
        });
        ordersMenu.add(staffAccMItem1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sofdev/guis/home_icon.png"))); // NOI18N
        jMenuItem2.setText("Log out");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        ordersMenu.add(jMenuItem2);

        helpMItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sofdev/guis/help_icon.png"))); // NOI18N
        helpMItem.setText("Help");
        ordersMenu.add(helpMItem);

        jMenuBar1.add(ordersMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 764, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updateBut1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBut1ActionPerformed
         try {
             ordersTxtA.setText("");
             Statement stmt = con.con().createStatement();
             int ordID = Integer.parseInt(orderIDSpin.getValue().toString());
             
            rs = stmt.executeQuery("SELECT * FROM ORDER WHERE ORDERID = "+ordID+";");
             
              if(rs.next()){
                int oID = rs.getInt("OrderID");
                Date dateO =rs.getDate("dateO");
                double amount = rs.getDouble("totalAmount");
                int userID=rs.getInt("userID");
                
                ResultSet rs2 = stmt.executeQuery("SELECT * FROM COMPONENT, SHOPPINGLIST WHERE SHOPPINGLIST.ORDERID ='"
                       +oID+"' AND SHOPPINGLIST.COMPONENTID=COMPONENT.COMPONENTID;");
                
                ordersTxtA.append(String.format("%-30s%-50s%-50s%-50s\n\n","Order ID: "+oID,
                        "Date of Order: "+dateO,"Total Amount: R"+amount, "User ID: "+userID));
                      
                ordersTxtA.append(String.format("%-16s%-26s%-32s%-30s%-30s%-30s\n\n","Component ID", "Category", 
                        "Type","Brand","Component Name","Price"));
               
                while(rs2.next()){
                    ordersTxtA.append(String.format("%-30d%-26s%-31s%-34s%-48sR%-30.2f\n",rs2.getInt("componentID"),
                    rs2.getString("category"),rs2.getString("type"),
                        rs2.getString("brand"), rs2.getString("compName"), rs2.getDouble("price")));
                }
                
                     ordersTxtA.append("__________________________________________________________________________________________________________\n");
                    }
             
         } catch (SQLException ex) {
           JOptionPane.showMessageDialog(rootPane, "Search unsuccessful.",
                            "Error", JOptionPane.ERROR_MESSAGE);
             System.out.println(ex);
         }
    }//GEN-LAST:event_updateBut1ActionPerformed

    private void updateBut2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBut2ActionPerformed
        refresh();
        
    }//GEN-LAST:event_updateBut2ActionPerformed

    private void deleteOrderButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteOrderButActionPerformed
        try {int conf= JOptionPane.showConfirmDialog(rootPane,"Are you sure you want to remove this component?","Confirm",JOptionPane.OK_OPTION,JOptionPane.NO_OPTION);
         System.out.println(conf);
         if(conf==0){
             Statement stmt = con.con().createStatement();
             int ordID = Integer.parseInt(orderIDSpin.getValue().toString());
             stmt.executeUpdate("DELETE FROM SHOPPINGLIST WHERE SHOPPINGLIST.ORDERID ="
                       +ordID+";");
             stmt.executeUpdate("DELETE FROM ORDER WHERE ORDERID ="
                       +ordID+";");
         }
         } catch (SQLException ex) {
           JOptionPane.showMessageDialog(rootPane, "Removal unsuccessful.",
                            "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println(ex);
         }
        refresh();
    }//GEN-LAST:event_deleteOrderButActionPerformed

    private void deleteCompButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteCompButActionPerformed
         try {
             int conf= JOptionPane.showConfirmDialog(rootPane,"Are you sure you want to remove this component?","Confirm",JOptionPane.OK_OPTION,JOptionPane.NO_OPTION);
         System.out.println(conf);
         if(conf==0){
             Statement stmt = con.con().createStatement();
             int ordID = Integer.parseInt(orderIDSpin.getValue().toString());
             int compID = Integer.parseInt(compIDSpin.getValue().toString());
             stmt.executeUpdate("DELETE FROM SHOPPINGLIST WHERE SHOPPINGLIST.ORDERID ="
                       +ordID+" AND SHOPPINGLIST.COMPONENTID = "+compID+";");
         }
         } catch (SQLException ex) {
           JOptionPane.showMessageDialog(rootPane, "Removal unsuccessful.",
                            "Error", JOptionPane.ERROR_MESSAGE);
             System.out.println(ex);
         }
         refresh();
    }//GEN-LAST:event_deleteCompButActionPerformed

    private void userAccMItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userAccMItem1ActionPerformed
       java.awt.EventQueue.invokeLater(() -> {
            new UserAcc(userID,mem).setVisible(true);
        });
       Orders.this.setVisible(false);
    }//GEN-LAST:event_userAccMItem1ActionPerformed

    private void componentMItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_componentMItem1ActionPerformed
       java.awt.EventQueue.invokeLater(() -> {
            new ComponentEdit(userID,mem).setVisible(true);
        });
        Orders.this.setVisible(false);
    }//GEN-LAST:event_componentMItem1ActionPerformed

    private void staffAccMItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staffAccMItem1ActionPerformed
        java.awt.EventQueue.invokeLater(() -> {
            new StaffAcc(userID,mem).setVisible(true);
        });
         Orders.this.setVisible(false);
    }//GEN-LAST:event_staffAccMItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
       Orders.this.setVisible(false);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner compIDSpin;
    private javax.swing.JMenuItem componentMItem1;
    private javax.swing.JButton deleteCompBut;
    private javax.swing.JButton deleteOrderBut;
    private javax.swing.JMenuItem helpMItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner orderIDSpin;
    private javax.swing.JMenu ordersMenu;
    private javax.swing.JTextArea ordersTxtA;
    private javax.swing.JMenuItem staffAccMItem1;
    private javax.swing.JButton updateBut1;
    private javax.swing.JButton updateBut2;
    private javax.swing.JMenuItem userAccMItem1;
    // End of variables declaration//GEN-END:variables
}
