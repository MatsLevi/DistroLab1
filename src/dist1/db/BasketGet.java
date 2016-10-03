
package dist1.db;

/**
 *
 * @author Gunnlaugur, Mats
 */
public class BasketGet {
    
    public static ItemGet[] getItem(int[] idValues) {
        DBConnector db = null;
        
        try{
            db = new DBMYSQLConnector();
            db.connect("store", "item_user", "123");
            
            
        } catch(Exception ex) {
            System.out.println("getItem: " + ex.toString());
            if(db != null) 
                db.disconnect();
            
            return new ItemGet[1];
        }
        
        // TODO REMOVE
        return null;
    }
}
