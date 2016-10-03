
package dist1.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
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

    @Override
    public ArrayList<ItemGet> getItems(int userId) {
        ArrayList<ItemGet> items = new ArrayList<>();
        StringBuilder removeConcats = new StringBuilder();
        Statement statement = null;
        ResultSet result = null;
        String name, type;
        int price, quantity, id;
        
        System.out.println("getItems userId: " + userId);
        
        try{
            statement = con.createStatement();
            
            String query = "select * from Item";
            removeConcats(removeConcats,userId);
            query = query + removeConcats;
            
            System.out.println("selectar: \n" + query);
            result = statement.executeQuery(query);

            while(result.next()) {
                name = result.getObject(1).toString();
                type = result.getObject(2).toString();
                price = Integer.parseInt(result.getObject(3).toString());
                quantity = Integer.parseInt(result.getObject(4).toString());
                id = Integer.parseInt(result.getObject(5).toString());
                
                items.add(new ItemGet(name,type,price,quantity,id));
            }
        } catch(SQLException | NumberFormatException ex) {
            System.out.println("Exception in getItems: " + ex.toString());
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
        
        return items;
    }

    @Override
    public ArrayList<ItemGet> getItems(int[] idValues) {
        ArrayList<ItemGet> items = new ArrayList<>();
        StringBuilder idConcats = new StringBuilder();
        Statement statement = null;
        ResultSet result = null;
        String name, type;
        int price, quantity, id;
        
        try{
            if(idValues.length == 0) throw new Exception("idValues empty");
            
            statement = con.createStatement();
            
            String query = "select * from Item where ";
            addConcats(idConcats, idValues);
            query = query + idConcats.toString();
            
            System.out.println("selectar: \n" + query);
            result = statement.executeQuery(query);
            
            while(result.next()) {
                name = result.getObject(1).toString();
                type = result.getObject(2).toString();
                price = Integer.parseInt(result.getObject(3).toString());
                quantity = Integer.parseInt(result.getObject(4).toString());
                id = Integer.parseInt(result.getObject(5).toString());
                
                items.add(new ItemGet(name,type,price,quantity,id));
            }
        } catch(SQLException | NumberFormatException ex) {
            System.out.println("Exception in getItems2: " + ex.toString());
        } catch (Exception ex) {
            System.out.println("Exception in getItems2: " + ex.toString());
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
        
        return items;
    }
    
    private void removeConcats(StringBuilder idConcats, int userId) {
        
    }
    
    private void addConcats(StringBuilder idConcats, int[] idValues) {
        for(int i = 0; i < idValues.length; i++) {
            if(i == 0) {
                idConcats.append("id = ").append(Integer.toString(idValues[i])).append(" ");
            } else {
                idConcats.append("or id = ").append(Integer.toString(idValues[i])).append(" ");
            }
        }
    }
}
