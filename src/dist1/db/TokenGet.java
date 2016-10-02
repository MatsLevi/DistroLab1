
package dist1.db;

import dist1.bo.Token;

/**
 *
 * @author Gunnlaugur, Mats
 */
public class TokenGet extends Token{
    
    private TokenGet(int id, long timeStamp) {
        super(id, timeStamp);
    }

    private TokenGet() {
        super();
    }

    public static Token getToken(String username, String pw) {
        DBConnector db = null;
        int id;
        
        try {
            db = new DBMYSQLConnector();
            db.connect("store", "login_user", "123456");
            
            id = db.getUser(username, pw);
            db.disconnect();
            
            if(id == -1)
                return new TokenGet();
            else
                return new TokenGet(id, System.currentTimeMillis());
        } catch (Exception ex) {
            System.out.println("getToken: " + ex.toString());
            if(db != null) 
                db.disconnect();
            
            return new TokenGet();
        }
    }
}
