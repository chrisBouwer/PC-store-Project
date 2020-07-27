package sofdev.guis;
import java.awt.HeadlessException;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;


public class Components extends javax.swing.JFrame {
      static ArrayList<Integer> compList = new ArrayList<>();
      static int userID;
      static String mem;
      Conn con = new Conn();
      ResultSet rs;
    public Components(ArrayList<Integer> compList, int userID,String mem) {
        Components.compList =compList;
        Components.userID = userID;
        Components.mem = mem;
        initComponents();
        
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
          displayTxtArea();
    }
private void displayTxtArea(){
        compTxtA.setText("");
        String sql = "SELECT componentID, brand, compName, price FROM Component WHERE category = '"
                + categoryComBox.getSelectedItem().toString() + "'AND type ='" + componentComBox.getSelectedItem().toString() + "';";
        try {
            Conn conn = new Conn();
            Statement stmt = conn.con().createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            compTxtA.append(String.format("%-16s%-30s%-30s%-30s\n", "Component ID",
                    "Brand", "Component Name", "Price"));

            while (rs.next()) {
                compTxtA.append(String.format("%-30d%-34s%-48s%-30.2f\n", rs.getInt("componentID"),
                        rs.getString("brand"), rs.getString("compName"), rs.getDouble("price")));
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

        jLabel1 = new javax.swing.JLabel();
        addToCartBut = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        categoryComBox = new javax.swing.JComboBox<>();
        viewCartBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        compTxtA = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        orderIDSpin = new javax.swing.JSpinner();
        componentComBox = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        compMenu = new javax.swing.JMenu();
        userAccMItem = new javax.swing.JMenuItem();
        shoppingMItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        helpMItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Component");

        addToCartBut.setText("Add To Cart");
        addToCartBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToCartButActionPerformed(evt);
            }
        });

        jLabel2.setText("Category");

        categoryComBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Home", "Gaming ", "Productivity" }));
        categoryComBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryComBoxActionPerformed(evt);
            }
        });

        viewCartBtn.setText("View Cart");
        viewCartBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewCartBtnActionPerformed(evt);
            }
        });

        compTxtA.setColumns(20);
        compTxtA.setRows(5);
        compTxtA.setTabSize(20);
        jScrollPane2.setViewportView(compTxtA);

        jLabel3.setText("Component ID:");

        componentComBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CPU", "Motherboard", "RAM", "Power Supply", "HardDrive", "Graphics Card", "Chassis" }));
        componentComBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                componentComBoxActionPerformed(evt);
            }
        });

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sofdev/guis/user_icon.png"))); // NOI18N
        jMenu2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuBar1.add(jMenu2);

        compMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sofdev/guis/menu_icon.png"))); // NOI18N
        compMenu.setText("Menu");

        userAccMItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sofdev/guis/user_icon.png"))); // NOI18N
        userAccMItem.setText("User Account");
        userAccMItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userAccMItemActionPerformed(evt);
            }
        });
        compMenu.add(userAccMItem);

        shoppingMItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sofdev/guis/cart_icon.png"))); // NOI18N
        shoppingMItem1.setText("Shopping Cart");
        shoppingMItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shoppingMItem1ActionPerformed(evt);
            }
        });
        compMenu.add(shoppingMItem1);

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
        helpMItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpMItemActionPerformed(evt);
            }
        });
        compMenu.add(helpMItem);

        jMenuBar1.add(compMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(jLabel3)
                .addGap(9, 9, 9)
                .addComponent(orderIDSpin, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(addToCartBut)
                .addGap(35, 35, 35)
                .addComponent(viewCartBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(203, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addGap(34, 34, 34))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(categoryComBox, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(107, 107, 107)
                        .addComponent(jLabel1)
                        .addGap(39, 39, 39)
                        .addComponent(componentComBox, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 222, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(categoryComBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(componentComBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(addToCartBut)
                    .addComponent(viewCartBtn)
                    .addComponent(orderIDSpin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void viewCartBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewCartBtnActionPerformed
          Components.this.setVisible(false);
        java.awt.EventQueue.invokeLater(() -> {
            new ShoppingCart(compList,userID,mem).setVisible(true);
        });

    }//GEN-LAST:event_viewCartBtnActionPerformed

    private void addToCartButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToCartButActionPerformed
 try {

            Conn con = new Conn();
            
            Statement stmt = con.con().createStatement();
            int id = Integer.parseInt(orderIDSpin.getValue().toString());
            String rsID = "";
            ResultSet rs = stmt.executeQuery("SELECT componentID FROM Component WHERE componentID = " + id);

            if (rs.next()) {
                rsID += rs.getInt("componentID");
            }

            if (rsID.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Component with that ID not found!",
                    "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                compList.add((Integer) orderIDSpin.getValue());
             }
                       
        } catch (SQLException | NumberFormatException | HeadlessException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Cannot connect to database",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_addToCartButActionPerformed

    private void shoppingMItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shoppingMItem1ActionPerformed
         Components.this.setVisible(false);
        java.awt.EventQueue.invokeLater(() -> {
            new ShoppingCart(compList,userID,mem).setVisible(true);
        });
    }//GEN-LAST:event_shoppingMItem1ActionPerformed

    private void categoryComBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryComBoxActionPerformed
        displayTxtArea();
    }//GEN-LAST:event_categoryComBoxActionPerformed

    private void userAccMItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userAccMItemActionPerformed
      Components.this.setVisible(false);
        java.awt.EventQueue.invokeLater(() -> {
            new Acc(compList,userID,mem).setVisible(true);
        });
    }//GEN-LAST:event_userAccMItemActionPerformed

    private void helpMItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpMItemActionPerformed
        JOptionPane.showMessageDialog(null, "- Choose the Category and Component you are looking for then click search\n"
                + "- Find the component you are looking for, enter the Component ID then select Add To Cart\n"
                + "- To view your Shopping Cart click View Cart",
                "Help", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_helpMItemActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
       Components.this.setVisible(false);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void componentComBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_componentComBoxActionPerformed
        displayTxtArea();
    }//GEN-LAST:event_componentComBoxActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addToCartBut;
    private javax.swing.JComboBox<String> categoryComBox;
    private javax.swing.JMenu compMenu;
    private javax.swing.JTextArea compTxtA;
    private javax.swing.JComboBox<String> componentComBox;
    private javax.swing.JMenuItem helpMItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner orderIDSpin;
    private javax.swing.JMenuItem shoppingMItem1;
    private javax.swing.JMenuItem userAccMItem;
    private javax.swing.JButton viewCartBtn;
    // End of variables declaration//GEN-END:variables
}
