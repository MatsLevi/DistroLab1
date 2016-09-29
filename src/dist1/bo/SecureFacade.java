
package dist1.bo;

import dist1.ui.TokenView;

/**
 *
 * @author Gunnlaugur, Mats
 */
public class SecureFacade {
    
    private final LoginLogic login;
    
    public SecureFacade() {
        login = new LoginLogic();
    }
    
    public TokenView authorizeRequest(String username, String pw) {
        System.out.println("kom in i authorize: " + username + " " + pw);
        Token t = login.authorize(username, pw);

        // Undviker att skicka orginal referencen av strängen.
        return new TokenView(new String(t.getId().toCharArray()), t.getTimeStamp(), t.getAuthorized());
    }
}
