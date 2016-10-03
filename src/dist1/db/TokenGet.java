
package dist1.db;

import dist1.bo.Token;

/**
 * The <code>TokenGet</code> acts as a connector between the <code>LoginLogic</code> 
 * and the <code>DBConnector</code>.
 * 
 * @author Gunnlaugur, Mats
 */
public class TokenGet extends Token{

    /**
     * Constructs a <code>TokenGet</code> with given parameters.
     * 
     * @param id int containing id of a user
     * @param timeStamp long containing time
     */
    private TokenGet(int id, long timeStamp) {
        super(id, timeStamp);
    }

    /**
     * Constructs an empty <code>TokenGet</code>.
     */
    private TokenGet() {
        super();
    }

    /**
     * Connects to the database and tries to authenticate the user.
     * 
     * @param username <code>String</code> containing the user name.
     * @param pw <code>String</code> containing the user password.
     * @return returns valid token if successful and a unvalid one if authentication failed.
     */
    public static TokenGet getToken(String username, String pw) {
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
