package dist1.db;

/**
 * Created by mats on 10/1/16.
 */
public class RegisterUser {

    public static boolean registerUser(String username, String pw) {
        DBConnector db = null;

        try {
            db = new DBMYSQLConnector();
            db.connect("store", "login", "123456");

            db.disconnect();
        } catch (Exception ex) {
            System.out.println("DB close error" + ex.toString());
            if(db != null) db.disconnect();

            return false;
        }

        return true;
    }
}
