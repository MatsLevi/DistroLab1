
package dist1.db;

import dist1.ui.TokenView;
import java.util.ArrayList;

/**
 *
 * @author Gunnlaugur, Mats
 */
public class BasketGet {

    /**
     * Setsup a connector and tries to gett intems from the database
     * @param userId int containing ID of user
     * @return ItemGet array containing items
     */
    public static ItemGet[] getItem(int userId) {
        DBConnector db = null;
        
        try{
            db = new DBMYSQLConnector();
            db.connect("store", "item_user", "123");
            
            ArrayList<ItemGet> items = db.getBasketItems(userId);
            db.disconnect();
            
            ItemGet[] ig = new ItemGet[items.size()];
            for(int i = 0; i < items.size(); i++)
                ig[i] = items.get(i);
            
            return ig;
        } catch(Exception ex) {
            System.out.println("getItem2: " + ex.toString());
            if(db != null) 
                db.disconnect();
            
            return new ItemGet[1];
        }
    }

    /**
     * adds itms into the basket in the database
     * @param userId int containing user ID
     * @param itemIdValues int array containing ID of the items
     */
    public static void addItem(int userId, int[] itemIdValues) {
        DBConnector db = null;
        
        try{
            db = new DBMYSQLConnector();
            db.connect("store", "item_user", "123");
            
            db.addToBasket(userId, itemIdValues);
            db.disconnect();
        } catch(Exception ex) {
            System.out.println("addItem5: " + ex.toString());
            if(db != null) 
                db.disconnect();
        }
    }

    public static void removeItems(int userId, int[] itemIdValues) {
        DBConnector db = null;
        
        try{
            db = new DBMYSQLConnector();
            db.connect("store", "item_user", "123");
            
            db.removeFromBasket(userId, itemIdValues);
            db.disconnect();
        } catch(Exception ex) {
            System.out.println("removeItems: " + ex.toString());
            if(db != null) 
                db.disconnect();
        }
    }
}
