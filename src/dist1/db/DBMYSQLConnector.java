
package dist1.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * The <code>DBMYSQLConnector</code> uses jdbc in order to communicate with an 
 * sql database.
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
    
    /**
     * Connects the database user to the specified database. It should be noted 
     * that this user is only used for database connections, not shop logins.
     * 
     * @param dbName the database name.
     * @param username the database user name.
     * @param password the database user password.
     * @throws java.sql.SQLException thrown if connection fails.
     */
    @Override
    public void connect(String dbName, String username, String password) throws SQLException {
        this.username = username; this.pw = password;
        String Server = "jdbc:mysql://localhost:3306/" + dbName + "?UseClientEnc=UTF8";
        
        con = DriverManager.getConnection(Server, username, pw);
        System.out.println("Connected to db");
    }

    /**
     * Disconnects the connection to the database.
     */
    @Override
    public void disconnect() {
        try{
            con.close();
            System.out.println("Connection closed!");
        } catch (SQLException ex) {}
    }

    /**
     * Returns a user id if the user is found in the database.
     * 
     * @param username the user to search for in the database.
     * @param password the password to search for in the database.
     * @return returns -1 if the user is not found, else a user id.
     */
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

    /**
     * Tries to add the specified user to the database. If the user already 
     * exists the method returns <code>false</code>.
     * 
     * @param username the user to be added to the database.
     * @param password the password to be added to the database.
     * @return <code>true</code> if the user is added.
     */
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

    /**
     * Gets all the items within the database, except those that are registered in 
     * the user basket.
     * 
     * @param userId the users id.
     * @return returns all items except those within the users basket.
     */
    @Override
    public ArrayList<ItemGet> getItems(int userId) {
        ArrayList<ItemGet> items = new ArrayList<>();
        StringBuilder removeConcats = new StringBuilder();
        Statement statement = null;
        ResultSet result = null;
        String name, type;
        int price, quantity, id;
        
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

    /**
     * Gets all items within the specified users basket.
     * 
     * @param userId the users id.
     * @return items within the users basket.
     */
    @Override
    public ArrayList<ItemGet> getBasketItems(int userId) {
        ArrayList<ItemGet> items = new ArrayList<>();
        StringBuilder idConcats = new StringBuilder();
        Statement statement = null;
        ResultSet result = null;
        String name, type;
        int price, quantity, id;
        boolean basketIsEmpty;
        
        try{
            statement = con.createStatement();
            
            String query = "select * from Item";
            basketIsEmpty = addConcats(idConcats, userId);
            query += idConcats.toString();
            
            if(basketIsEmpty) {
                return items;
            }
            
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
    
    private void removeConcats(StringBuilder removeConcats, int userId) {
        ArrayList<Integer> itemIdValues = getBasketItemIdValues(userId);
        
        if(itemIdValues == null)
            return;
        
        removeConcats.append(" where ");
        
        for(int i = 0; i < itemIdValues.size(); i++) {
            if(i == 0) {
                removeConcats.append("id != ").append(Integer.toString(itemIdValues.get(i))).append(" ");
            } else {
                removeConcats.append("and id != ").append(Integer.toString(itemIdValues.get(i))).append(" ");
            }
        }
    }
    
    private ArrayList<Integer> getBasketItemIdValues(int userId) {
        ArrayList<Integer> itemIdValues = new ArrayList<>();
        Statement statement = null;
        ResultSet result = null;
        
        try{
            statement = con.createStatement();
            String query = "select item_id from Basket where user_id = " + userId;
            System.out.println("basket: " + query);
            result = statement.executeQuery(query);
            
            while(result.next()) {
                itemIdValues.add(Integer.parseInt(result.getObject(1).toString()));
            }
            
            if(itemIdValues.isEmpty())
                return null;
            
            return itemIdValues;
        } catch(SQLException | NumberFormatException ex) {
            System.out.println("getBasketItemIdValues: " + ex.toString());
            return null;
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
    
    private boolean addConcats(StringBuilder idConcats, int userId) {
        ArrayList<Integer> itemIdValues = getBasketItemIdValues(userId);
        
        if(itemIdValues == null)
            return true;
        
        idConcats.append(" where ");
        
        for(int i = 0; i < itemIdValues.size(); i++) {
            if(i == 0) {
                idConcats.append("id = ").append(Integer.toString(itemIdValues.get(i))).append(" ");
            } else {
                idConcats.append("or id = ").append(Integer.toString(itemIdValues.get(i))).append(" ");
            }
        }
        
        return false;
    }

    /**
     * Adds items to the user basket based on the item ids stored in the 
     * <code>itemIdValues</code>.
     * 
     * @param userId the user id.
     * @param itemIdValues the ids of the items to be added.
     */
    @Override
    public void addToBasket(int userId, int[] itemIdValues) {
        Statement statement = null;
        String query;
        
        for(int i = 0; i < itemIdValues.length; i++) {
            try{
                statement = con.createStatement();
                query = "insert into Basket (user_id,item_id) values (" + userId + ", " + itemIdValues[i] + ")";
                System.out.println("insertar: \n" + query);
                statement.executeUpdate(query);
            } catch (SQLException ex) {
                System.out.println("Exception in addToBasket: " + ex.toString());
            } finally {
                if(statement != null) {
                    try {
                        statement.close();
                    } catch (SQLException ex) {}
                }
            }
        }
    }

    /**
     * Removes items from the user basket based on the item ids stored in the 
     * <code>itemIdValues</code>.
     * 
     * @param userId the user id.
     * @param itemIdValues the ids of the items to be removed.
     */
    @Override
    public void removeFromBasket(int userId, int[] itemIdValues) {
        Statement statement = null;
        String query;
        
        for(int i = 0; i < itemIdValues.length; i++) {
            try{
                statement = con.createStatement();
                query = "delete from Basket where item_id = " + itemIdValues[i];
                System.out.println("deletar: \n" + query);
                statement.executeUpdate(query);
            } catch (SQLException ex) {
                System.out.println("Exception in addToBasket: " + ex.toString());
            } finally {
                if(statement != null) {
                    try {
                        statement.close();
                    } catch (SQLException ex) {}
                }
            }
        }
    }
}
