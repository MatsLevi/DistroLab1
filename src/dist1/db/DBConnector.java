
package dist1.db;

/**
 *
 * @author Gunnlaugur, Mats
 */
public interface DBConnector {
    
    public void connect(String dbName, String username, String password) throws Exception;
    public void disconnect();
}
