
package dist1.bo;

import dist1.db.RegisterUser;
import dist1.db.TokenGet;

/**
 *
 * @author Gunnlaugur, Mats
 */
public class LoginLogic {

    /**
     * Tries to log a user into the system
     * @param username your username
     * @param pw your password
     * @return Token
     */
    public Token authorize(String username, String pw) {
        //TODO write down token on disk (to be used later for purchase)
        // do so that authorize returns boolean instead of token.
        
        return TokenGet.getToken(username, pw);
    }

    /**
     * registers a new user
     * @param username your usename
     * @param pw your password
     * @return boolean, true if sucsessfull and false if not
     */
    public boolean register(String username, String pw) {
        return RegisterUser.registerUser(username, pw);
    }
}
