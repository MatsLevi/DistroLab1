
package dist1.bo;

import dist1.ui.TokenView;

/**
 *
 * @author Gunnlaugur, Mats
 */
public class SecureFacade {
    
    public static TokenView authorizeRequest(String username, String pw) {
        LoginLogic login = new LoginLogic();

        Token t = login.authorize(username, pw);

        // Undviker att skicka orginal referencen av strängen.
        try {
            return new TokenView(new String(t.getId().toCharArray()), t.getTimeStamp(), t.getAuthorized());
        } catch(NullPointerException e) {
            return new TokenView(null, t.getTimeStamp(), t.getAuthorized());
        }
    }
}
