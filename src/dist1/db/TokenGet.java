
package dist1.db;

import dist1.bo.Token;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gunnlaugur, Mats
 */
public class TokenGet extends Token{
    
    private TokenGet(String id, long timeStamp) {
        super(id, timeStamp);
    }

    private TokenGet() {
        super();
    }

    public static Token getToken(String username, String pw) {
        try {
            DBConnector db = new DBMYSQLConnector();
            db.connect("store", "login", "123456");
            
            
        } catch (Exception ex) {
            return new TokenGet();
        }
        
        // TODO remove after try is completed!
        return new TokenGet();
    }
}
