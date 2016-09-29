
package dist1.db;

import dist1.bo.Token;

/**
 *
 * @author Gunnlaugur, Mats
 */
public class TokenGet extends Token{
    
    public TokenGet(String id, long timeStamp) {
        super(id, timeStamp);
    }
    
    public TokenGet() {
        super();
    }
    
    public static Token getToken(String username, String pw) {
        // TODO change with db data
        return new TokenGet();
    }
}
