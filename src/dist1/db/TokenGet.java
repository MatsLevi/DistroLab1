
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
    
    public static Token getToken() {
        // TODO change with db data
        return new TokenGet("temp", -1);
    }
}
