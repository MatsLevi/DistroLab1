
package dist1.db;

import dist1.bo.Token;

/**
 *
 * @author Gunnlaugur, Mats
 */
public class TokenGet extends Token{

    /**
     * Constructor
     * @param id int containing id of a user
     * @param timeStamp long containing time
     */
    private TokenGet(int id, long timeStamp) {
        super(id, timeStamp);
    }

    /**
     * Constructor simply calling super
     */
    private TokenGet() {
        super();
    }

    /**
     * connects to the database and tries to authenticate the user
     * @param username String containg user name
     * @param pw String containg user password
     * @return returns valid token if sucsesfull and a unvalid one if authentication failed
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
