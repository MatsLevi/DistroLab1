
package dist1.bo;

import dist1.db.TokenGet;

/**
 *
 * @author Gunnlaugur, Mats
 */
public class LoginLogic {
    
    public Token authorize() {
        return TokenGet.getToken();
    }
}
