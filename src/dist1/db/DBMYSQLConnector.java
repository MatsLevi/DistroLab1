
package dist1.db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Gunnlaugur, Mats
 */
public class DBMYSQLConnector implements DBConnector{
    private Connection con;
    private String username, pw;
    
    public DBMYSQLConnector() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            System.out.println("DB Driver successfully loaded!");
        } catch(ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            System.out.println("DB Driver failed to load!");
            throw new Exception("DB Failed! " + e.toString());
        }
        
        username = "Unknown"; pw = "NotSet";
    }
    
    @Override
    public void connect(String dbName, String username, String password) throws Exception {
        this.username = username; this.pw = password;
        String Server = "jdbc:mysql://localhost:3306/" + dbName + "?UseClientEnc=UTF8";
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
