
package dist1.bo;

import dist1.ui.TokenView;

/**
 *
 * @author Gunnlaugur, Mats
 */
public class SecureFacade {
    
    private LoginLogic login;
    
    public SecureFacade() {
        login = new LoginLogic();
    }
    
    public TokenView authorizeRequest() {
        Token t = login.authorize();
        
        return new TokenView();
    }
}
