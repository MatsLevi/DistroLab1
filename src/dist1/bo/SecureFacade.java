
package dist1.bo;

import dist1.ui.TokenView;

/**
 * The <code>SecureFacade</code> acts as a facade for the 
 * <code>LoginServlet</code>.
 * 
 * @author Gunnlaugur, Mats
 * @see dist1.ui.ItemServlet
 */
public class SecureFacade {

    /**
     * Authorizes a login request.
     * 
     * @param username user username.
     * @param pw user password.
     * @return <code>TokenView</code> used for authorization.
     */
    public static TokenView authorizeRequest(String username, String pw) {
        LoginLogic login = new LoginLogic();

        Token t = login.authorize(username, pw);

        return new TokenView(t.getId(), t.getTimeStamp(), t.getAuthorized());
    }

    /**
     * Registers user in database.
     * 
     * @param username user username.
     * @param pw user password.
     * @return <code>boolean</code>, <code>true</code> if successful.
     */
    public static boolean registerUser(String username, String pw){
        LoginLogic login = new LoginLogic();
        boolean regResult;

        regResult = login.register(username, pw);

        return regResult;
    }
}
