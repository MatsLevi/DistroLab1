
package dist1.db;

import dist1.bo.Token;

/**
 *
 * @author Gunnlaugur, Mats
 */
public class TokenGet extends Token{
    
    public TokenGet() {
        super();
    }
    
    public static Token getToken() {
        return new TokenGet();
    }
}
