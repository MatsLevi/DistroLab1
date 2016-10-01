
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
        return new TokenView(t.getId(), t.getTimeStamp(), t.getAuthorized());
    }

    public static boolean registerUser(String username, String pw){

        LoginLogic login = new LoginLogic();
        boolean regResult;

        regResult = login.register(username, pw);

        return regResult;
    }
}
