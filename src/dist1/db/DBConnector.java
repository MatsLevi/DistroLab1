
package dist1.db;

import java.util.ArrayList;

/**
 *
 * @author Gunnlaugur, Mats
 */
public interface DBConnector {
    
    public void connect(String dbName, String username, String password) throws Exception;
    public void disconnect();
    public int getUser(String username, String password);
    public boolean addUser(String username, String password);
    public ArrayList<ItemGet> getItems();
    public ArrayList<ItemGet> getItems(int[] idValues);
}
