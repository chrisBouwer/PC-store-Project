package sofdev.guis;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ShoppingCart extends javax.swing.JFrame {
 Conn con = new Conn();
    ResultSet rs;
    int sum = 0;
   static ArrayList<Integer> list;
   static int userID;
   static String mem;
   
    public ShoppingCart(ArrayList<Integer> list,int userID,String mem){
        
        initComponents();
       ShoppingCart.list = list;
       ShoppingCart.userID = userID;
       ShoppingCart.mem = mem;
        System.out.println(userID);
       refresh();
        try {
            Statement stmt = con.con().createStatement();
            if(mem.equals("Staff")){
            rs = stmt.executeQuery("SELECT USERNAMES FROM STAFF WHERE STAFFID = "+userID+";");
            if(rs.next()){jMenu2.setText(rs.getString("usernames"));}
            }
            else {
                rs = stmt.executeQuery("SELECT USERNAMEU FROM USER WHERE USERID = "+userID+";");
            if(rs.next()){jMenu2.setText(rs.getString("usernameu"));}}
             
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Components could not be displayed.",
                            "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void refresh(){
    
        try {
          Statement stmt = con.con().createStatement();
          sum = 0;
        cpuCBox.removeAllItems();
        mBoardCBox.removeAllItems();
        jComboBox3.removeAllItems();
        jComboBox4.removeAllItems();
        jComboBox5.removeAllItems();
        jComboBox6.removeAllItems();
        jComboBox7.removeAllItems();
        
        
        
         for(int i =0;i<list.size();i++){
             
             rs = stmt.executeQuery("SELECT TYPE, COMPNAME, PRICE FROM COMPONENT WHERE COMPONENTID = "+list.get(i)+";");
            
             if(rs.next()){
                switch(rs.getString("type")){
                     case "CPU" : cpuCBox.addItem(rs.getString("compname"));break;
                     case "Motherboard" :mBoardCBox.addItem(rs.getString("compname"));break;
                     case "RAM" : jComboBox3.addItem(rs.getString("compname"));break;
                     case "Power Supply" :jComboBox4.addItem(rs.getString("compname")) ;break;
                     case "HardDrive" :jComboBox5.addItem(rs.getString("compname")) ;break;
                     case "Graphics Card":jComboBox6.addItem(rs.getString("compname"));break;
                     case "Chassis" :jComboBox7.addItem(rs.getString("compname")) ;break;
                
                }
                sum += rs.getInt("price");
             }
         }  jTextField15.setText("R"+sum);
      /*   if(cpuCBox.getItemCount()==0){jButton1.setVisible(false);}else{jButton1.setVisible(true);}
         if(mBoardCBox.getItemCount()==0){jButton8.setVisible(false);} else{jButton8.setVisible(true);}
        
         if(jComboBox3.getItemCount()==0){jButton9.setVisible(false);}else{jButton8.setVisible(true);}
         if(jComboBox4.getItemCount()==0){jButton10.setVisible(false);}else{jButton10.setVisible(true);}
         if(jComboBox5.getItemCount()==0){jButton11.setVisible(false);}else{jButton11.setVisible(true);}
         if(jComboBox6.getItemCount()==0){jButton12.setVisible(false);}else{jButton12.setVisible(true);}
         if(jComboBox7.getItemCount()==0){jButton13.setVisible(false);}else{jButton13.setVisible(true);}*/
     } catch (SQLException ex) {
        JOptionPane.showMessageDialog(rootPane, "Components could not be displayed.",
                            "Error", JOptionPane.ERROR_MESSAGE);
           System.out.println(ex);
     }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        orderBut = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        cpuCBox = new javax.swing.JComboBox<>();
        mBoardCBox = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();
        jComboBox5 = new javax.swing.JComboBox<>();
        jComboBox6 = new javax.swing.JComboBox<>();
        jComboBox7 = new javax.swing.JComboBox<>();
        backBut = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        userAccMItem = new javax.swing.JMenuItem();
        componentMItem = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        helpMItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("CPU");

        jLabel2.setText("Motherboard");

        jLabel3.setText("RAM");

        jLabel4.setText("Power Supply");

        jLabel5.setText("Hard Drive");

        jLabel6.setText("Graphics Card");

        jLabel7.setText("Chassis");

        orderBut.setText("Order");
        orderBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderButActionPerformed(evt);
            }
        });

        jLabel9.setText("Total:");

        jTextField15.setEditable(false);

        cpuCBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpuCBoxActionPerformed(evt);
            }
        });

        backBut.setText("Back");
        backBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sofdev/guis/close_icon.png"))); // NOI18N
        jButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sofdev/guis/close_icon.png"))); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sofdev/guis/close_icon.png"))); // NOI18N
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sofdev/guis/close_icon.png"))); // NOI18N
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sofdev/guis/close_icon.png"))); // NOI18N
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sofdev/guis/close_icon.png"))); // NOI18N
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sofdev/guis/close_icon.png"))); // NOI18N
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sofdev/guis/user_icon.png"))); // NOI18N
        jMenu2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuBar1.add(jMenu2);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sofdev/guis/menu_icon.png"))); // NOI18N
        jMenu1.setText("Menu");

        userAccMItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sofdev/guis/user_icon.png"))); // NOI18N
        userAccMItem.setText("User Account");
        userAccMItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userAccMItemActionPerformed(evt);
            }
        });
        jMenu1.add(userAccMItem);

        componentMItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sofdev/guis/select_icon.png"))); // NOI18N
        componentMItem.setText("Component Select");
        componentMItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                componentMItemActionPerformed(evt);
            }
        });
        jMenu1.add(componentMItem);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sofdev/guis/home_icon.png"))); // NOI18N
        jMenuItem2.setText("Log out");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        helpMItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sofdev/guis/help_icon.png"))); // NOI18N
        helpMItem.setText("Help");
        helpMItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpMItemActionPerformed(evt);
            }
        });
        jMenu1.add(helpMItem);

        jMenuBar1.add(jMenu1);

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
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBox5, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBox4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(mBoardCBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cpuCBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBox6, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBox7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jButton11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jButton10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jButton9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jButton8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(orderBut, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(backBut, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(cpuCBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(mBoardCBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backBut)
                    .addComponent(orderBut))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userAccMItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userAccMItemActionPerformed
java.awt.EventQueue.invokeLater(() -> {
            new Acc(list,userID,mem).setVisible(true);
        });
       ShoppingCart.this.setVisible(false);        
    }//GEN-LAST:event_userAccMItemActionPerformed

    private void orderButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderButActionPerformed
     try {
         int sID = 0;
         sum = 0;
         Statement stmt = con.con().createStatement();
         String show= "";
         for(int i =0;i<list.size();i++){
             
             rs = stmt.executeQuery("SELECT TYPE, COMPNAME, PRICE FROM COMPONENT WHERE COMPONENTID = "+list.get(i)+";");
            
             if(rs.next()){
               show +=rs.getString("type")+": "+rs.getString("compname")+" R"+rs.getDouble("price")+"\n";
                sum += rs.getInt("price");
             }
         } 
         show +="Total due: R"+sum;
         int conf= JOptionPane.showConfirmDialog(rootPane,show,"Confirm Order",JOptionPane.OK_OPTION,JOptionPane.NO_OPTION);
         System.out.println(conf);
         if(conf==0){  
             rs = stmt.executeQuery("SELECT STAFFID FROM STAFF WHERE AUTHORITY = TRUE");
         if(rs.next()){ sID = rs.getInt("staffid");}
        
                stmt.executeUpdate("INSERT INTO ORDER (USERID,DATEO,TOTALAMOUNT,STAFFID) VALUES("+userID
               +",DATE(),"+sum+","+sID+");");
      rs = stmt.executeQuery("SELECT ORDERID FROM ORDER WHERE ORDERID =(SELECT MAX(ORDERID) FROM ORDER)");
      
      if(rs.next()){
          
       for(int i = 0; i<list.size();i++){
            stmt.executeUpdate("INSERT INTO SHOPPINGLIST (COMPONENTID,ORDERID) VALUES("+list.get(i)+", "+rs.getInt("orderid")+");");
       }
       }
         JOptionPane.showMessageDialog(rootPane, "Your order was successfull");
         
         }
       
     } catch (SQLException ex) {
         JOptionPane.showMessageDialog(rootPane, "Order Failed.",
                            "Error", JOptionPane.ERROR_MESSAGE);
           System.out.println(ex);
     }
        
      
    }//GEN-LAST:event_orderButActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         try {
         Statement stmt = con.con().createStatement();
         String name  = cpuCBox.getSelectedItem().toString();
         rs = stmt.executeQuery("SELECT COMPONENTID FROM COMPONENT WHERE COMPNAME ='"+name+"' AND TYPE = 'CPU';");
         
         if(rs.next()){
             for (int i = 0; i < list.size(); i++) {
                 if(list.get(i)==rs.getInt("componentID")){
                 list.remove(i);}
                 }
             }
             
         refresh();
     } catch (SQLException ex) {
        JOptionPane.showMessageDialog(rootPane, "Components could not be displayed.",
                            "Error", JOptionPane.ERROR_MESSAGE);
           System.out.println(ex);
     }
    
    }//GEN-LAST:event_jButton1ActionPerformed

    private void backButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButActionPerformed
ShoppingCart.this.setVisible(false);
        java.awt.EventQueue.invokeLater(() -> {
            new Components(list,userID,mem).setVisible(true);
        });     
    }//GEN-LAST:event_backButActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
       try {
         Statement stmt = con.con().createStatement();
         String name  = mBoardCBox.getSelectedItem().toString();
         rs = stmt.executeQuery("SELECT COMPONENTID FROM COMPONENT WHERE COMPNAME ='"+name+"' AND TYPE = 'motherboard';");
         
         if(rs.next()){
             for (int i = 0; i < list.size(); i++) {
                 if(list.get(i)==rs.getInt("componentID")){
                 list.remove(i);}
                 }
             }
             
         refresh();
     } catch (SQLException ex) {
        JOptionPane.showMessageDialog(rootPane, "Components could not be displayed.",
                            "Error", JOptionPane.ERROR_MESSAGE);
           System.out.println(ex);
     }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        try {
         Statement stmt = con.con().createStatement();
         String name  = jComboBox3.getSelectedItem().toString();
         rs = stmt.executeQuery("SELECT COMPONENTID FROM COMPONENT WHERE COMPNAME ='"+name+"' AND TYPE = 'Ram';");
        
         if(rs.next()){
             for (int i = 0; i < list.size(); i++) {
                 if(list.get(i)==rs.getInt("componentID")){
                 list.remove(i);}
                 }
             }
             
         refresh();
     } catch (SQLException ex) {
        JOptionPane.showMessageDialog(rootPane, "Components could not be displayed.",
                            "Error", JOptionPane.ERROR_MESSAGE);
           System.out.println(ex);
     }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        try {
         Statement stmt = con.con().createStatement();
         String name  = jComboBox4.getSelectedItem().toString();
         rs = stmt.executeQuery("SELECT COMPONENTID FROM COMPONENT WHERE COMPNAME ='"+name+"' AND TYPE = 'Power Supply';");
      
         if(rs.next()){
             for (int i = 0; i < list.size(); i++) {
                 if(list.get(i)==rs.getInt("componentID")){
                 list.remove(i);}
                 }
             }
             
         refresh();
     } catch (SQLException ex) {
        JOptionPane.showMessageDialog(rootPane, "Components could not be displayed.",
                            "Error", JOptionPane.ERROR_MESSAGE);
           System.out.println(ex);
     }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        try {
         Statement stmt = con.con().createStatement();
         String name  = jComboBox5.getSelectedItem().toString();
         rs = stmt.executeQuery("SELECT COMPONENTID FROM COMPONENT WHERE COMPNAME ='"+name+"' AND TYPE = 'HardDrive';");
         
         if(rs.next()){
             for (int i = 0; i < list.size(); i++) {
                 if(list.get(i)==rs.getInt("componentID")){
                 list.remove(i);}
                 }
             }
             
         refresh();
     } catch (SQLException ex) {
        JOptionPane.showMessageDialog(rootPane, "Components could not be displayed.",
                            "Error", JOptionPane.ERROR_MESSAGE);
           System.out.println(ex);
     }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        try {
         Statement stmt = con.con().createStatement();
         String name  = jComboBox6.getSelectedItem().toString();
         rs = stmt.executeQuery("SELECT COMPONENTID FROM COMPONENT WHERE COMPNAME ='"+name+"' AND TYPE = 'Graphics card';");
         
         if(rs.next()){
             for (int i = 0; i < list.size(); i++) {
                 if(list.get(i)==rs.getInt("componentID")){
                 list.remove(i);}
                 }
             }
             
         refresh();
     } catch (SQLException ex) {
        JOptionPane.showMessageDialog(rootPane, "Components could not be displayed.",
                            "Error", JOptionPane.ERROR_MESSAGE);
           System.out.println(ex);
     }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
       try {
         Statement stmt = con.con().createStatement();
         String name  = jComboBox7.getSelectedItem().toString();
         rs = stmt.executeQuery("SELECT COMPONENTID FROM COMPONENT WHERE COMPNAME ='"+name+"' AND TYPE = 'chassis';");
         
         if(rs.next()){
             for (int i = 0; i < list.size(); i++) {
                 if(list.get(i)==rs.getInt("componentID")){
                 list.remove(i);}
                 }
             }
             
         refresh();
     } catch (SQLException ex) {
        JOptionPane.showMessageDialog(rootPane, "Components could not be displayed.",
                            "Error", JOptionPane.ERROR_MESSAGE);
           System.out.println(ex);
     }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void componentMItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_componentMItemActionPerformed
java.awt.EventQueue.invokeLater(() -> {
            new Components(list,userID,mem).setVisible(true);
        });
       ShoppingCart.this.setVisible(false);         
    }//GEN-LAST:event_componentMItemActionPerformed

    private void helpMItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpMItemActionPerformed
        
    }//GEN-LAST:event_helpMItemActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
        ShoppingCart.this.setVisible(false);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void cpuCBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpuCBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cpuCBoxActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBut;
    private javax.swing.JMenuItem componentMItem;
    private javax.swing.JComboBox<String> cpuCBox;
    private javax.swing.JMenuItem helpMItem;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JComboBox<String> mBoardCBox;
    private javax.swing.JButton orderBut;
    private javax.swing.JMenuItem userAccMItem;
    // End of variables declaration//GEN-END:variables
}
