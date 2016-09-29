
package dist1.db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Gunnlaugur, Mats
 */
public class DBConnector {
    private Connection con;
    private String username, pw;
    
    public DBConnector() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            System.out.println("DB Driver successfully loaded!");
        } catch(ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            System.out.println("DB Driver failed to load!");
            throw new Exception("DB Failed! " + e.toString());
        }
        
        username = "Unknown"; pw = "NotSet";
    }
    
    public void connect(String database, String username, String password) throws Exception {
        this.username = username; this.pw = password;
        String Server = "jdbc:mysql://localhost:3306/" + database + "?UseClientEnc=UTF8";
        con = null;
        
        try {
            con = DriverManager.getConnection(Server, username, pw);
            System.out.println("Connected to db");
        } catch(Exception e) {
            System.out.println("Failed to connect");
            throw new Exception("Connection Failed! " + e.toString());
        }
    }
}
