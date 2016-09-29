
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
    
    public TokenView authorizeRequest() {
        Token t = login.authorize();

        // Undviker att skicka orginal referencen av strängen.
        return new TokenView(new String(t.getId().toCharArray()), t.getTimeStamp(), t.getAuthorized());
    }
}
