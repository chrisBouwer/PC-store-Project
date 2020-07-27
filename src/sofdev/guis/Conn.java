package sofdev.guis;

import java.io.File;
import java.sql.*;
import javax.swing.JOptionPane;

public class Conn {

    public Conn() {

    }

    public Connection con() {
        Connection con = null;
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String filename = (new File("Frontosa.accdb")).getAbsolutePath();
            con = DriverManager.getConnection("jdbc:ucanaccess://" + filename);
            return con;
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Cannot connect to database", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return con;
    }
}
