
package dist1.bo;

import dist1.db.RegisterUser;
import dist1.db.TokenGet;

/**
 *
 * @author Gunnlaugur, Mats
 */
public class LoginLogic {
    
    public Token authorize(String username, String pw) {
        //TODO write down token on disk (to be used later for purchase)
        // do so that authorize returns boolean instead of token.
        
        return TokenGet.getToken(username, pw);
    }

    public boolean register(String username, String pw) {
        return RegisterUser.registerUser(username, pw);
    }
}
