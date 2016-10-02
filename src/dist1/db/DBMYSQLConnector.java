
package dist1.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    @Override
    public int getUser(String username, String password) {
        Statement statement = null;
        ResultSet result = null;
        
        try{
            statement = con.createStatement();
            String query = "select id from Login where (username like '%" + username.toLowerCase() + "%' and pw like '%" + password.toLowerCase() + "%')";
            System.out.println("selectar: \n" + query);
            result = statement.executeQuery(query);
            
            result.next();
            return Integer.parseInt(result.getObject(1).toString());
        } catch(SQLException | NumberFormatException ex) {
            System.out.println("Exception in getUser: " + ex.toString());
            return -1;
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {}
            }
            if(result != null) {
                try {
                    result.close();
                } catch (SQLException ex) {}
            }
        }
    }

    @Override
    public boolean addUser(String username, String password) {
        Statement statement = null;
        
        try{
            statement = con.createStatement();
            String query = "insert into Login (username,pw) values ('" + username.toLowerCase() + "', '" + password.toLowerCase() + "')";
            System.out.println("insertar: \n" + query);
            statement.executeUpdate(query);
            return true;
        } catch (SQLException ex) {
            System.out.println("Exception in addUser: " + ex.toString());
            return false;
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {}
            }
        }
    }
}
