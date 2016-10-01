
package dist1.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    public void connect(String dbName, String username, String password) throws SQLException {
        this.username = username; this.pw = password;
        String Server = "jdbc:mysql://localhost:3306/" + dbName + "?UseClientEnc=UTF8";
        
        con = DriverManager.getConnection(Server, username, pw);
        System.out.println("Connected to db");
    }

    @Override
    public void disconnect() {
        try{
            con.close();
            System.out.println("Connection closed!");
        } catch (SQLException ex) {}
    }
}
