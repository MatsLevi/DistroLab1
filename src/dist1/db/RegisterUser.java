
package dist1.db;

/**
 * The <code>RegisterUser</code> acts as a connector between the <code>LoginLogic</code> 
 * and the <code>DBConnector</code>.
 * 
 * @author Mats, Gunnlaugur
 * @see dist1.bo.LoginLogic
 * @see dist1.db.DBConnector
 */
public class RegisterUser {

    /**
     * Tries to connect to the db and register a user.
     * 
     * @param username <code>String</code> containing the name of the user.
     * @param pw <code>String</code> containing users password.
     * @return <code>boolean</code>, <code>true</code> for success and <code>false</code> for failure.
     */
    public static boolean registerUser(String username, String pw) {
        DBConnector db = null;
        boolean addSuccess;

        try {
            db = new DBMYSQLConnector();
            db.connect("store", "login_user", "123456");

            addSuccess = db.addUser(username, pw);
            db.disconnect();
            
            return addSuccess;
        } catch (Exception ex) {
            System.out.println("DB error" + ex.toString());
            if(db != null) 
                db.disconnect();

            return false;
        }
    }
}
