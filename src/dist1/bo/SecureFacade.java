
package dist1.bo;

import dist1.ui.TokenView;

/**
 *
 * @author Gunnlaugur, Mats
 */
public class SecureFacade {

    /**
     * authoizeses a loggin request
     * @param username user username
     * @param pw user password
     * @return tokenview
     */
    public static TokenView authorizeRequest(String username, String pw) {
        LoginLogic login = new LoginLogic();

        Token t = login.authorize(username, pw);

        return new TokenView(t.getId(), t.getTimeStamp(), t.getAuthorized());
    }

    /**
     * Rigisters user in database
     * @param username user username
     * @param pw user password
     * @return boolean
     */
    public static boolean registerUser(String username, String pw){
        LoginLogic login = new LoginLogic();
        boolean regResult;

        regResult = login.register(username, pw);

        return regResult;
    }
}
