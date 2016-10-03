
package dist1.bo;

import dist1.db.RegisterUser;
import dist1.db.TokenGet;

/**
 * The <code>LoginLogic</code> contains all logical methods to be performed during 
 * login.
 * 
 * @author Gunnlaugur, Mats
 */
public class LoginLogic {

    /**
     * Tries to log a user into the system.
     * 
     * @param username your username.
     * @param pw your password.
     * @return authentication <code>Token</code>.
     */
    public Token authorize(String username, String pw) {
        return TokenGet.getToken(username, pw);
    }

    /**
     * Registers a new user.
     * 
     * @param username your usename.
     * @param pw your password.
     * @return <code>boolean</code>, <code>true</code> if successful and <code>false</code> if not.
     */
    public boolean register(String username, String pw) {
        return RegisterUser.registerUser(username, pw);
    }
}
