
package dist1.db;

import java.util.ArrayList;

/**
 * Implementing this <code>interface</code> enables a <code>class</code> to act 
 * as a connector for a database handler.
 * 
 * @author Gunnlaugur, Mats
 */
public interface DBConnector {
    
    /**
     * Connects the database user to the specified database. It should be noted 
     * that this user is only used for database connections, not shop logins.
     * 
     * @param dbName the database name.
     * @param username the database user name.
     * @param password the database user password.
     * @throws Exception thrown if connection fails.
     */
    public void connect(String dbName, String username, String password) throws Exception;
    
    /**
     * Disconnects the connection to the database.
     */
    public void disconnect();
    
    /**
     * Returns a user id if the user is found in the database.
     * 
     * @param username the user to search for in the database.
     * @param password the password to search for in the database.
     * @return returns -1 if the user is not found, else a user id.
     */
    public int getUser(String username, String password);
    
    /**
     * Tries to add the specified user to the database. If the user already 
     * exists the method returns <code>false</code>.
     * 
     * @param username the user to be added to the database.
     * @param password the password to be added to the database.
     * @return <code>true</code> if the user is added.
     */
    public boolean addUser(String username, String password);
    
    /**
     * Gets all the items within the database, except those that are registered in 
     * the user basket.
     * 
     * @param userId the users id.
     * @return returns all items except those within the users basket.
     */
    public ArrayList<ItemGet> getItems(int userId);
    
    /**
     * Gets all items within the specified users basket.
     * 
     * @param userId the users id.
     * @return items within the users basket.
     */
    public ArrayList<ItemGet> getBasketItems(int userId);
    
    /**
     * Adds items to the user basket based on the item ids stored in the 
     * <code>itemIdValues</code>.
     * 
     * @param userId the user id.
     * @param itemIdValues the ids of the items to be added.
     */
    public void addToBasket(int userId, int[] itemIdValues);
    
    /**
     * Removes items from the user basket based on the item ids stored in the 
     * <code>itemIdValues</code>.
     * 
     * @param userId the user id.
     * @param itemIdValues the ids of the items to be removed.
     */
    public void removeFromBasket(int userId, int[] itemIdValues);
}
