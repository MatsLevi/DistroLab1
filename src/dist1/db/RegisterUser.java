package dist1.db;

/**
 *
 * @author Mats, Gunnlaugur
 */
public class RegisterUser {

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
