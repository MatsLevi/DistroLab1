
package dist1.db;

import dist1.bo.Token;

/**
 *
 * @author Gunnlaugur, Mats
 */
public class TokenGet extends Token{
    
    private TokenGet(String id, long timeStamp) {
        super(id, timeStamp);
    }

    private TokenGet() {
        super();
    }

    public static Token getToken(String username, String pw) {
        System.out.println("Token username: " + username + " \nToken pw: " + pw);

        // TODO change with db connector
        return new TokenGet();
    }
}
