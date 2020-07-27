package sofdev.guis;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ComponentEdit extends javax.swing.JFrame {

    Conn con = new Conn();
     ResultSet rs;
     static int userID;
     static String mem;
    public ComponentEdit(int userID, String mem) {
        ComponentEdit.userID = userID;
        ComponentEdit.mem = mem;
        
       
      
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
        refresh();
              
    }

   private void refresh(){
   
         compTxtA.setText("");
        try {
            Statement stmt = con.con().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM COMPONENT;");
             compTxtA.append(String.format("%-16s%-26s%-32s%-30s%-30s%-30s\n","Component ID", "Category", 
                        "Type","Brand","Component Name","Price"));
             compTxtA.append("__________________________________________________________________________________________________________\n");
            
            while(rs.next()){ 
                compTxtA.append(String.format("%-30d%-26s%-31s%-34s%-48s%-30.2f\n",rs.getInt("componentID"),
                    rs.getString("category"),rs.getString("type"),
                        rs.getString("brand"), rs.getString("compName"), rs.getDouble("price")));
            }
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Components could not be displayed.",
                            "Error", JOptionPane.ERROR_MESSAGE);
           System.out.println(ex);
        }
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        compTxtA = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        orderIDSpin = new javax.swing.JSpinner();
        jPanel1 = new javax.swing.JPanel();
        priceSpin = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        brandTxtFld = new javax.swing.JTextField();
        typeComBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        removeBut = new javax.swing.JButton();
        updateBut = new javax.swing.JButton();
        catComBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        compTxtFld = new javax.swing.JTextField();
        addBut1 = new javax.swing.JButton();
        searchBut = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        compMenu = new javax.swing.JMenu();
        userAccMItem = new javax.swing.JMenuItem();
        staffAccMItem = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        helpMItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        compTxtA.setColumns(20);
        compTxtA.setRows(5);
        jScrollPane2.setViewportView(compTxtA);

        jLabel3.setText("Component ID");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setText("Price");

        jLabel5.setText("Component Name");

        typeComBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CPU", "Motherboard", "RAM", "Power Supply", "HardDrive", "Graphics Card", "Chassis" }));

        jLabel2.setText("Type");

        jLabel4.setText("Brand");

        removeBut.setText("Remove");
        removeBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButActionPerformed(evt);
            }
        });

        updateBut.setText("Update");
        updateBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButActionPerformed(evt);
            }
        });

        catComBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Home", "Gaming", "Productivity" }));
        catComBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                catComBoxActionPerformed(evt);
            }
        });

        jLabel1.setText("Category");

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
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(catComBox, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(addBut1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(typeComBox, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(updateBut, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(brandTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(removeBut, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(compTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(priceSpin, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel5))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(catComBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(typeComBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(brandTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(compTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(priceSpin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(removeBut)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(addBut1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(updateBut)))
                .addContainerGap())
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

        compMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sofdev/guis/menu_icon.png"))); // NOI18N
        compMenu.setText("Menu");

        userAccMItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sofdev/guis/user_icon.png"))); // NOI18N
        userAccMItem.setText("User Accounts");
        userAccMItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userAccMItemActionPerformed(evt);
            }
        });
        compMenu.add(userAccMItem);

        staffAccMItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sofdev/guis/controls_icon.png"))); // NOI18N
        staffAccMItem.setText("Staff Accounts");
        staffAccMItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staffAccMItemActionPerformed(evt);
            }
        });
        compMenu.add(staffAccMItem);

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sofdev/guis/order_icon.png"))); // NOI18N
        jMenuItem1.setText("Orders");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        compMenu.add(jMenuItem1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sofdev/guis/home_icon.png"))); // NOI18N
        jMenuItem2.setText("Log out");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        compMenu.add(jMenuItem2);

        helpMItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sofdev/guis/help_icon.png"))); // NOI18N
        helpMItem.setText("Help");
        compMenu.add(helpMItem);

        jMenuBar1.add(compMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(orderIDSpin, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(searchBut, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(9, 9, 9)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2)))
                .addGap(0, 8, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(orderIDSpin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(searchBut))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButActionPerformed
        try {
            Statement stmt = con.con().createStatement();
            int compID = Integer.parseInt(orderIDSpin.getValue().toString());
             rs = stmt.executeQuery("SELECT CATEGORY,TYPE,BRAND,COMPNAME,PRICE FROM COMPONENT WHERE COMPONENTID = "+compID+";");
             if(rs.next()){
                 
                 switch(rs.getString("category"))
                 {
                     case "Home": catComBox.setSelectedIndex(0);break;
                     case "Gaming": catComBox.setSelectedIndex(1);break;
                     case "Productivity": catComBox.setSelectedIndex(2);break;
                  }
                 
                 switch(rs.getString("type")){
                 
                     case "CPU" : typeComBox.setSelectedIndex(0);break;
                     case "Motherboard" : typeComBox.setSelectedIndex(1);break;
                     case "RAM" : typeComBox.setSelectedIndex(2);break;
                     case "Power Supply" : typeComBox.setSelectedIndex(3);break;
                     case "HardDrive" : typeComBox.setSelectedIndex(4);break;
                     case "Graphics Card" : typeComBox.setSelectedIndex(5);break;
                     case "Chassis" : typeComBox.setSelectedIndex(6);break;
                 }
                 
                 brandTxtFld.setText(rs.getString("brand"));
                 compTxtFld.setText(rs.getString("compname"));
                 priceSpin.setValue(rs.getInt("price"));
             
             }
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Components could not be found.",
                            "Error", JOptionPane.ERROR_MESSAGE);
           System.out.println(ex);
        }
    }//GEN-LAST:event_searchButActionPerformed

    private void updateButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButActionPerformed
       try{ Statement stmt = con.con().createStatement();
        int compID = Integer.parseInt(orderIDSpin.getValue().toString());
        stmt.executeUpdate("UPDATE COMPONENT SET CATEGORY = '"+catComBox.getSelectedItem().toString()
                +"', TYPE = '"+ typeComBox.getSelectedItem().toString()+"', BRAND = '"+brandTxtFld.getText()+
                "', COMPNAME = '"+compTxtFld.getText()+"', PRICE = "+priceSpin.getValue().toString()+" WHERE COMPONENTID ="+compID+";");}
       catch(NumberFormatException | SQLException e){
       JOptionPane.showMessageDialog(null, "Component could not be updated.",
                            "Error", JOptionPane.ERROR_MESSAGE);
           System.out.println(e);
       }
       refresh();
    }//GEN-LAST:event_updateButActionPerformed

    private void removeButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButActionPerformed
    try{
        int conf= JOptionPane.showConfirmDialog(rootPane,"Are you sure you want to remove this component?","Confirm",JOptionPane.OK_OPTION,JOptionPane.NO_OPTION);
         System.out.println(conf);
         if(conf==0){
        Statement stmt = con.con().createStatement();
        int compID = Integer.parseInt(orderIDSpin.getValue().toString());
        stmt.executeUpdate("DELETE FROM COMPONENT WHERE COMPONENTID = "+compID+";");
         }
    }
    catch(SQLException | NumberFormatException e){
    JOptionPane.showMessageDialog(null, "Component could not be deleted.",
                            "Error", JOptionPane.ERROR_MESSAGE);
           System.out.println(e);
    }
    refresh();
    }//GEN-LAST:event_removeButActionPerformed

    private void addBut1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBut1ActionPerformed
        Statement stmt;
        try {
            stmt = con.con().createStatement(); 
            stmt.executeUpdate("INSERT INTO COMPONENT (category,type,brand,compName,price) VALUES('"+catComBox.getSelectedItem().toString()
                +"','"+typeComBox.getSelectedItem().toString()+"','"+  brandTxtFld.getText()+"','"+compTxtFld.getText()
                +"',"+priceSpin.getValue().toString()+");");
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Component could not be added.",
                            "Error", JOptionPane.ERROR_MESSAGE);
           System.out.println(ex);
        }
       
        refresh();
    }//GEN-LAST:event_addBut1ActionPerformed

    private void userAccMItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userAccMItemActionPerformed
         java.awt.EventQueue.invokeLater(() -> {
            new UserAcc(userID,mem).setVisible(true);
        });
       ComponentEdit.this.setVisible(false);
    }//GEN-LAST:event_userAccMItemActionPerformed

    private void staffAccMItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staffAccMItemActionPerformed
        java.awt.EventQueue.invokeLater(() -> {
            new StaffAcc(userID,mem).setVisible(true);
        });
       ComponentEdit.this.setVisible(false);
    }//GEN-LAST:event_staffAccMItemActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        java.awt.EventQueue.invokeLater(() -> {
            new Orders(userID,mem).setVisible(true);
        });
       ComponentEdit.this.setVisible(false);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void catComBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_catComBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_catComBoxActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
       ComponentEdit.this.setVisible(false);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBut1;
    private javax.swing.JTextField brandTxtFld;
    private javax.swing.JComboBox<String> catComBox;
    private javax.swing.JMenu compMenu;
    private javax.swing.JTextArea compTxtA;
    private javax.swing.JTextField compTxtFld;
    private javax.swing.JMenuItem helpMItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner orderIDSpin;
    private javax.swing.JSpinner priceSpin;
    private javax.swing.JButton removeBut;
    private javax.swing.JButton searchBut;
    private javax.swing.JMenuItem staffAccMItem;
    private javax.swing.JComboBox<String> typeComBox;
    private javax.swing.JButton updateBut;
    private javax.swing.JMenuItem userAccMItem;
    // End of variables declaration//GEN-END:variables

}
