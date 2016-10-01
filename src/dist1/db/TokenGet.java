
package dist1.db;

import dist1.bo.Token;

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
        DBConnector db = null;
        
        try {
            db = new DBMYSQLConnector();
            db.connect("store", "login", "123456");
            
            
            
            db.disconnect();
        } catch (Exception ex) {
            System.out.println("getToken: " + ex.toString());
            if(db != null) db.disconnect();
            
            return new TokenGet();
        }
        
        // TODO remove after try is completed!
        return new TokenGet();
    }
}
