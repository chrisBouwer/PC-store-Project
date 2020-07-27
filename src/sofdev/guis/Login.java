package sofdev.guis;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    String mem;

    public Login() {
        initComponents();
        passwordTxtFld.setText("");
        staffRBut.setSelected(true);

        radioButGroup.add(staffRBut);
        radioButGroup.add(userRBut);
        this.getRootPane().setDefaultButton(loginBut);
    }
    int userID;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        radioButGroup = new javax.swing.ButtonGroup();
        loginBut = new javax.swing.JButton();
        usernameTxtFld = new javax.swing.JTextField();
        passwordTxtFld = new javax.swing.JPasswordField();
        staffRBut = new javax.swing.JRadioButton();
        userRBut = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 102));
        setForeground(java.awt.Color.gray);

        loginBut.setText("Login");
        loginBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButActionPerformed(evt);
            }
        });

        passwordTxtFld.setText("jPasswordField1");

        staffRBut.setText("Staff");
        staffRBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staffRButActionPerformed(evt);
            }
        });

        userRBut.setText("User");
        userRBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userRButActionPerformed(evt);
            }
        });

        jLabel2.setText("Username");

        jLabel3.setText("Password");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sofdev/guis/frontosa.PNG"))); // NOI18N

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sofdev/guis/help_icon.png"))); // NOI18N
        jMenu1.setText("Help");

        jMenuItem1.setText("Enter your details to login or call Frontosa for assistance");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usernameTxtFld)
                    .addComponent(passwordTxtFld))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(staffRBut)
                        .addGap(27, 27, 27)
                        .addComponent(userRBut))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel1)))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addComponent(loginBut, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(staffRBut)
                    .addComponent(userRBut))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(usernameTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(passwordTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(loginBut)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userRButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userRButActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userRButActionPerformed

    private void staffRButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staffRButActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_staffRButActionPerformed

    private void loginButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButActionPerformed
        String pass = String.valueOf(passwordTxtFld.getPassword());
        String passwordD = "";
        try {
            Conn conne = new Conn();
            Statement stmt = conne.con().createStatement();

            if (staffRBut.isSelected()) {
                mem = "Staff";
                ResultSet rs = stmt.executeQuery("SELECT passwordS,staffID FROM Staff "
                        + "WHERE userNameS ='" + usernameTxtFld.getText() + "';");

                if (rs.next()) {
                    passwordD = rs.getString(1);
                    userID = rs.getInt("staffid");
                }

                if (passwordD.equals("") || usernameTxtFld.getText().equals("")) {
                    JOptionPane.showMessageDialog(rootPane, "Please enter correct username and password",
                            "Error", JOptionPane.ERROR_MESSAGE);
                } else {

                    if (passwordD.equals(pass)) {
                        JOptionPane.showMessageDialog(rootPane, "Login successful", "Login", JOptionPane.PLAIN_MESSAGE);
                        Login.this.setVisible(false);
                        java.awt.EventQueue.invokeLater(() -> {
                            new StaffAcc(userID, mem).setVisible(true);
                        });
                    } else {

                        JOptionPane.showMessageDialog(rootPane, "Please enter correct username and password",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }

            } else if (userRBut.isSelected()) {
                mem = "User";
                ResultSet rs = stmt.executeQuery("SELECT passwordU,userID FROM User WHERE userNameU ='"
                        + usernameTxtFld.getText() + "';");

                if (rs.next()) {
                    passwordD = rs.getString(1);
                    userID = rs.getInt("userid");
                }
                if (passwordD.equals("") || usernameTxtFld.getText().equals("")) {
                    JOptionPane.showMessageDialog(rootPane, "Please enter correct username and password",
                            "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    if (passwordD.equals(pass)) {
                        JOptionPane.showMessageDialog(rootPane, "Login successful", "Login", JOptionPane.PLAIN_MESSAGE);
                        ArrayList<Integer> compList = new ArrayList<>();
                        Login.this.setVisible(false);
                        java.awt.EventQueue.invokeLater(() -> {
                            new Components(compList, userID, mem).setVisible(true);
                        });
                    } else {

                        JOptionPane.showMessageDialog(rootPane, "Please enter correct username and password",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(rootPane, "Cannot connect to database",
                    "Error", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_loginButActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JButton loginBut;
    private javax.swing.JPasswordField passwordTxtFld;
    private javax.swing.ButtonGroup radioButGroup;
    private javax.swing.JRadioButton staffRBut;
    private javax.swing.JRadioButton userRBut;
    private javax.swing.JTextField usernameTxtFld;
    // End of variables declaration//GEN-END:variables
}
